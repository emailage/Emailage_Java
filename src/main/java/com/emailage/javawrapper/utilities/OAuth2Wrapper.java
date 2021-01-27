package com.emailage.javawrapper.utilities;

import com.emailage.javawrapper.model.OAuth2Token;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class OAuth2Wrapper {

    private static class InstanceHolder{

        private static final ConcurrentMap<String, OAuth2Wrapper> InstanceCollection = new ConcurrentHashMap<>();
        private static ObjectMapper mapper;

        static
        {
            // Configure jackson-afterburner
            mapper = new ObjectMapper();
            mapper.registerModule(new AfterburnerModule());
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        }
    }
    public static OAuth2Wrapper getInstance(String accountToken, String accountSecret, URL tokenUrl) {
        if(!InstanceHolder.InstanceCollection.containsKey(accountToken)){
            InstanceHolder.InstanceCollection.put(accountToken, new OAuth2Wrapper(accountToken, accountSecret, tokenUrl));
        }

        return InstanceHolder.InstanceCollection.get(accountToken);
    }

    protected String accountToken;
    protected String accountSecret;
    protected LocalDateTime expiration;
    protected OAuth2Token token;
    protected URL tokenUrl;


    private static final String tokenForm = "grant_type=client_credentials&client_id=%s&client_secret=%s";
    private static final String refreshForm = "grant_type=token_refresh&client_id=%s&refresh_token=%s";

    protected OAuth2Wrapper(String accountToken, String accountSecret, URL tokenUrl){
        this.accountSecret = accountSecret;
        this.accountToken = accountToken;
        this.tokenUrl = tokenUrl;
        this.expiration = LocalDateTime.now().minusMonths(1);
        this.token = new OAuth2Token();
    }

    public String doOAuth2Request(URL url, String form) throws Exception {

        if(expiration.isBefore(LocalDateTime.now())){
            token = getAccessToken(token, accountToken, accountSecret, this.tokenUrl);
            expiration = LocalDateTime.now().plusSeconds(token.getAccessExpiration());
        }

        String answer = null;
        byte[] body = form.getBytes(StandardCharsets.UTF_8);
        HttpsURLConnection conn = HttpHelper.getHttpsURLConnection(url);
        try (AutoCloseable conc = new AutoCloseableHttpsUrlConnection(conn)) {
            answer = HttpHelper.PostRequest(body, conn);
        }

        return answer;
    }

    private OAuth2Token getAccessToken(OAuth2Token token, String accountToken, String accountSecret, URL tokenUrl) throws Exception {

        String answer = null;
        try {
            HttpsURLConnection conn = HttpHelper.getHttpsURLConnection(tokenUrl);
            try (AutoCloseable conc = new AutoCloseableHttpsUrlConnection(conn)) {

                String form = null;
                if(token.getAccessToken() != null){
                    form = String.format(refreshForm, accountSecret, token.getRefreshToken());
                } else {
                    form = String.format(tokenForm, accountSecret, accountToken);
                }

                byte[] body = form.getBytes(StandardCharsets.UTF_8);
                answer = HttpHelper.PostRequest(body, conn);
            }
        } catch (Exception ex){
            // refresh token has expired so set the refresh token to null and try
            // using the full credentials.
            if(token.getRefreshToken() != null) {
                token.setRefreshToken(null);
                getAccessToken(token, accountToken, accountSecret, tokenUrl);
            } else {
                throw ex;
            }
        }

        OAuth2Token result = InstanceHolder.mapper.readValue(answer,OAuth2Token.class);
        return result;
    }
}
