package com.emailage.javawrapper.utilities;

import com.emailage.javawrapper.model.OAuth2Token;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    protected OAuth2Wrapper(String accountToken, String accountSecret, URL tokenUrl){
        this.accountSecret = accountSecret;
        this.accountToken = accountToken;
        this.tokenUrl = tokenUrl;
        this.expiration = LocalDateTime.now().minusMonths(1);
        this.token = new OAuth2Token();
    }

    public OutputStream getOutputStream(HttpsURLConnection conn, int postDataLength, String charset) throws Exception {

        if( expiration.isBefore(LocalDateTime.now())){
            token = getAccessToken(token, accountToken, accountSecret, this.tokenUrl);
            expiration = LocalDateTime.now().plusSeconds(token.getAccessExpiration());
        }

        conn.setRequestProperty("Content-Language", "en-US");
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=" + charset);
        conn.setRequestProperty("Accept-Charset", charset);
        conn.setRequestProperty("Authorization","Bearer " + token.getAccessToken());
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setDoOutput(true);

        return conn.getOutputStream();
    }

    public InputStream getInputStream(HttpsURLConnection conn) throws IOException {
        return conn.getInputStream();
    }

    private OAuth2Token getAccessToken(OAuth2Token token, String accountToken, String accountSecret, URL tokenUrl) throws Exception {

        String form = String.format(tokenForm, accountSecret, accountToken);
        byte[] body = form.getBytes(StandardCharsets.UTF_8);
        int bodySize = body.length;

        String answer = null;
        HttpsURLConnection conn = HttpHelper.getHttpsURLConnection(tokenUrl);
        try(AutoCloseable conc = new AutoCloseableHttpsUrlConnection(conn)) {

            conn.setRequestProperty("Content-Language", "en-US");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            conn.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());
            answer = HttpHelper.PostRequest(body, conn);
        }

        OAuth2Token result = InstanceHolder.mapper.readValue(answer, OAuth2Token.class);
        return result;
    }
}
