package com.emailage.javawrapper;

import com.emailage.javawrapper.model.ConfigurationParameters;
import com.emailage.javawrapper.model.Enums;
import com.emailage.javawrapper.model.ExtraInputParameter;
import com.emailage.javawrapper.model.exception.EmailageApiRequestException;
import com.emailage.javawrapper.model.response.EmailageResponse;
import com.emailage.javawrapper.utilities.HttpHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

public class EmailageClientTest {

    private static final String accountSecret = "test";
    private static final String authToken = "test";
    private HttpsURLConnection urlMock;
    private HttpHelper helpMock;

    @Before()
    public void setup(){
        urlMock = mock(HttpsURLConnection.class);
        helpMock = mock(HttpHelper.class);
    }

    @After()
    public void tearDown(){}

    @Test()
    public void queryEmailSimpleOAuth1() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertNotNull(result);
    }

    @Test()
    public void queryEmailSimpleOAuth2() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(tokenResult).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setAuthenticationType(Enums.AuthenticationType.OAUTH2);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

        verify(urlMock, times(2)).disconnect();
        verify(helpMock, times(2)).getHttpsURLConnection(any());
        verify(helpMock,times(2)).PostRequest(any(),any());
        assertNotNull(result);
    }

    @Test()
    public void queryEmailSimple100() throws Exception {

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        for(int i = 0; i < 100; i++) {
            when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
            when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
            EmailageClient.httpHelper = helpMock;

            EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

            verify(urlMock).disconnect();
            verify(helpMock, times(1)).getHttpsURLConnection(any());
            verify(helpMock,times(1)).PostRequest(any(),any());
            assertNotNull(result);
            reset(urlMock, helpMock);
        }
    }

    @Test()
    public void oAuth2queryEmailSimple100() throws Exception {

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setResultFormat(Enums.Format.Json);
        parameters.setAuthenticationType(Enums.AuthenticationType.OAUTH2);
        parameters.setAcccountToken(authToken + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        parameters.setAccountSecret(accountSecret + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));

        for(int i = 0; i < 100; i++) {

            when(helpMock.PostRequest(eq(tokenRequest.getBytes(StandardCharsets.UTF_8)), any())).thenReturn(tokenResult);
            when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
            when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);

            EmailageClient.httpHelper = helpMock;
            EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

            verify(urlMock, atLeast(1)).disconnect();
            verify(helpMock, atLeast(1)).getHttpsURLConnection(any());
            verify(helpMock, atLeast(1)).PostRequest(any(),any());
            assertNotNull(result);
            reset(urlMock, helpMock);
        }
    }

    @Test(expected = EmailageApiRequestException.class)
    public void queryEmailSimpleServerDown() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenThrow(new IOException("test"));
        EmailageClient.httpHelper = helpMock;

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertEquals(expectedResult, result);
    }

    @Test
    public void queryEmailAndIP() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIP("tmp@dne.com","1.1.1.1",parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertNotNull(result);
    }

    @Test
    public void queryEmailAndIPPlusExtraArgs() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setUserEmail("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIPPlusExtraArgs("tmp@dne.com","1.1.1.1", extraInputParameter, parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertNotNull(result);
    }

    @Test
    public void queryEmailAndIPPlusExtraArgsNullIp() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setUserEmail("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIPPlusExtraArgs("tmp@dne.com",null, extraInputParameter, parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertNotNull(result);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void queryEmailAndIPPlusExtraArgsEmptyIp() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setUserEmail("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIPPlusExtraArgs("tmp@dne.com","", extraInputParameter, parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertNotNull(result);
    }

    @Test
    public void markEmailAsFraud() throws Exception {

        when(helpMock.getHttpsURLConnection(any())).thenReturn(urlMock);
        when(helpMock.PostRequest(any(),any())).thenReturn(rajeshResponse);
        EmailageClient.httpHelper = helpMock;

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setUserEmail("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.MarkEmailAsFraud("tmp@dne.com", Enums.FraudType.Fraud, Enums.FraudCode.IDENTITY_THEFT_ACCOUNT_TAKE_OVER, parameters);

        verify(urlMock).disconnect();
        verify(helpMock, times(1)).getHttpsURLConnection(any());
        verify(helpMock,times(1)).PostRequest(any(),any());
        assertNotNull(result);
    }


    final String rajeshResponse = "{\n" +
            "    \"query\": {\n" +
            "        \"email\": \"rajesh@yahoo.com\",\n" +
            "        \"queryType\": \"EmailAgeVerification\",\n" +
            "        \"count\": 1,\n" +
            "        \"created\": \"2019-02-12T18:51:31Z\",\n" +
            "        \"lang\": \"en-US\",\n" +
            "        \"responseCount\": 1,\n" +
            "        \"response_language\": \"json\",\n" +
            "        \"results\": [\n" +
            "            {\n" +
            "                \"userdefinedrecordid\": \"\",\n" +
            "                \"email\": \"rajesh@yahoo.com\",\n" +
            "                \"eName\": \"\",\n" +
            "                \"emailAge\": \"\",\n" +
            "                \"email_creation_days\": \"\",\n" +
            "                \"domainAge\": \"1995-01-18T05:00:00Z\",\n" +
            "                \"domain_creation_days\": \"8790\",\n" +
            "                \"firstVerificationDate\": \"2019-01-23T23:41:58Z\",\n" +
            "                \"first_seen_days\": \"19\",\n" +
            "                \"lastVerificationDate\": \"2019-01-29T18:22:38Z\",\n" +
            "                \"status\": \"ValidDomain\",\n" +
            "                \"country\": \"US\",\n" +
            "                \"fraudRisk\": \"995 Very High\",\n" +
            "                \"EAScore\": \"995\",\n" +
            "                \"EAReason\": \"Fraud Level 2\",\n" +
            "                \"EAStatusID\": \"4\",\n" +
            "                \"EAReasonID\": \"1\",\n" +
            "                \"EAAdviceID\": \"1\",\n" +
            "                \"EAAdvice\": \"Fraud Review\",\n" +
            "                \"EARiskBandID\": \"7\",\n" +
            "                \"EARiskBand\": \"test2\",\n" +
            "                \"source_industry\": \"Other\",\n" +
            "                \"fraud_type\": \"Card Not Present Fraud\",\n" +
            "                \"lastflaggedon\": \"2019-02-08T22:58:20Z\",\n" +
            "                \"dob\": \"1986\",\n" +
            "                \"gender\": \"male\",\n" +
            "                \"location\": \"Dubai, United Arab Emirates\",\n" +
            "                \"smfriends\": \"515\",\n" +
            "                \"totalhits\": \"154\",\n" +
            "                \"uniquehits\": \"3\",\n" +
            "                \"emailExists\": \"Not Sure\",\n" +
            "                \"domainExists\": \"Yes\",\n" +
            "                \"company\": \"\",\n" +
            "                \"title\": \"\",\n" +
            "                \"domainname\": \"yahoo.com\",\n" +
            "                \"domaincompany\": \"YahooInc\",\n" +
            "                \"domaincountryname\": \"United States\",\n" +
            "                \"domaincategory\": \"Webmail\",\n" +
            "                \"domaincorporate\": \"No\",\n" +
            "                \"domainrisklevel\": \"Low\",\n" +
            "                \"domainrelevantinfo\": \"Low Risk Domain\",\n" +
            "                \"domainrisklevelID\": \"4\",\n" +
            "                \"domainrelevantinfoID\": \"510\",\n" +
            "                \"domainriskcountry\": \"No\",\n" +
            "                \"smlinks\": [\n" +
            "                    {\n" +
            "                        \"source\": \"Facebook\",\n" +
            "                        \"link\": \"https://www.facebook.com/pmdrajesh\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"source\": \"Flickr\",\n" +
            "                        \"link\": \"https://www.flickr.com/people/44791251@N06/\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"source\": \"Gravatar\",\n" +
            "                        \"link\": \"https://gravatar.com/openideas123345\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"source\": \"Vimeo\",\n" +
            "                        \"link\": \"http://vimeo.com/user7725693\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"phone_status\": \"\",\n" +
            "                \"shipforward\": \"\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    \"responseStatus\": {\n" +
            "        \"status\": \"success\",\n" +
            "        \"errorCode\": \"0\",\n" +
            "        \"description\": \"\"\n" +
            "    }\n" +
            "}";

    final String expectedResult = "{    \"query\": {        \"email\": \"rajesh@yahoo.com\",        \"queryType\": \"EmailAgeVerification\",        \"count\": 1,        \"created\": \"2019-02-12T18:51:31Z\",        \"lang\": \"en-US\",        \"responseCount\": 1,        \"response_language\": \"json\",        \"results\": [            {                \"userdefinedrecordid\": \"\",                \"email\": \"rajesh@yahoo.com\",                \"eName\": \"\",                \"emailAge\": \"\",                \"email_creation_days\": \"\",                \"domainAge\": \"1995-01-18T05:00:00Z\",                \"domain_creation_days\": \"8790\",                \"firstVerificationDate\": \"2019-01-23T23:41:58Z\",                \"first_seen_days\": \"19\",                \"lastVerificationDate\": \"2019-01-29T18:22:38Z\",                \"status\": \"ValidDomain\",                \"country\": \"US\",                \"fraudRisk\": \"995 Very High\",                \"EAScore\": \"995\",                \"EAReason\": \"Fraud Level 2\",                \"EAStatusID\": \"4\",                \"EAReasonID\": \"1\",                \"EAAdviceID\": \"1\",                \"EAAdvice\": \"Fraud Review\",                \"EARiskBandID\": \"7\",                \"EARiskBand\": \"test2\",                \"source_industry\": \"Other\",                \"fraud_type\": \"Card Not Present Fraud\",                \"lastflaggedon\": \"2019-02-08T22:58:20Z\",                \"dob\": \"1986\",                \"gender\": \"male\",                \"location\": \"Dubai, United Arab Emirates\",                \"smfriends\": \"515\",                \"totalhits\": \"154\",                \"uniquehits\": \"3\",                \"emailExists\": \"Not Sure\",                \"domainExists\": \"Yes\",                \"company\": \"\",                \"title\": \"\",                \"domainname\": \"yahoo.com\",                \"domaincompany\": \"YahooInc\",                \"domaincountryname\": \"United States\",                \"domaincategory\": \"Webmail\",                \"domaincorporate\": \"No\",                \"domainrisklevel\": \"Low\",                \"domainrelevantinfo\": \"Low Risk Domain\",                \"domainrisklevelID\": \"4\",                \"domainrelevantinfoID\": \"510\",                \"domainriskcountry\": \"No\",                \"smlinks\": [                    {                        \"source\": \"Facebook\",                        \"link\": \"https://www.facebook.com/pmdrajesh\"                    },                    {                        \"source\": \"Flickr\",                        \"link\": \"https://www.flickr.com/people/44791251@N06/\"                    },                    {                        \"source\": \"Gravatar\",                        \"link\": \"https://gravatar.com/openideas123345\"                    },                    {                        \"source\": \"Vimeo\",                        \"link\": \"http://vimeo.com/user7725693\"                    }                ],                \"phone_status\": \"\",                \"shipforward\": \"\"            }        ]    },    \"responseStatus\": {        \"status\": \"success\",        \"errorCode\": \"0\",        \"description\": \"\"    }}";
    final String tokenResult = "{\"client_id\":\"65D7CA94989A4CBE9D7311B933DB2A82\",\"access_token\":\"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI2NUQ3Q0E5NDk4OUE0Q0JFOUQ3MzExQjkzM0RCMkE4MiIsIm5iZiI6MTYxMTg0OTczOSwiZXhwIjoxNjExODUwNjM5LCJpYXQiOjE2MTE4NDk3MzksImlzcyI6Imh0dHBzOi8vYXBpLmVtYWlsYWdlLmNvbSIsImF1ZCI6Imh0dHBzOi8vYXBpLmVtYWlsYWdlLmNvbSJ9.fwfujqOLcjnupGC74FDrTH03h0iqVH_QXW9rXSuD1g4Nsr8k9BYdTYRtT1DYGc3YxB3_u3h1324O6teJ5IxH6g\",\"token_type\":\"bearer\",\"expires_in\":900,\"refresh_token\":\"TsTnQJBEQPAvWeP9RGiZDjOGHyu2PYgjrK75bqIORiYU9PiAjVX6a2jAlJDTN9vVyAxMRi6dMlXZtTUP6uo9iDZKki0dK3n7sH3snlTuClKlVnxfj0SW300trq29bMtR\",\"scope\":null}";
    final String tokenRequest = "grant_type=client_credentials&client_id=test&client_secret=test";
}