package com.emailage.javawrapper;

import com.emailage.javawrapper.model.ConfigurationParameters;
import com.emailage.javawrapper.model.Enums;
import com.emailage.javawrapper.model.ExtraInputParameter;
import com.emailage.javawrapper.model.exception.EmailageApiRequestException;
import com.emailage.javawrapper.model.response.EmailageResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmailageClient.class)
@PowerMockIgnore({"javax.crypto.*"})
public class EmailageClientTest {

    private static final String accountSecret = "test";
    private static final String authToken = "test";

    @Test()
    public void queryEmailSimple() throws Exception {

        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        oStream.write(rajeshResponse.getBytes());

        ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

        HttpsURLConnection mock = mock(HttpsURLConnection.class);
        when(mock.getOutputStream()).thenReturn(oStream);
        when(mock.getInputStream()).thenReturn(iStream);

        PowerMockito.spy(EmailageClient.class);
        PowerMockito.doReturn(mock).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

        verify(mock).getOutputStream();
        verify(mock).getInputStream();
        assertNotNull(result);
    }

    @Test()
    public void queryEmailSimple100() throws Exception {

        for(int i = 0; i < 100; i++) {

            ByteArrayOutputStream oStream = new ByteArrayOutputStream();
            oStream.write(rajeshResponse.getBytes());

            ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

            HttpsURLConnection mock = mock(HttpsURLConnection.class);
            when(mock.getOutputStream()).thenReturn(oStream);
            when(mock.getInputStream()).thenReturn(iStream);

            PowerMockito.spy(EmailageClient.class);
            PowerMockito.doReturn(mock).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));

            ConfigurationParameters parameters = new ConfigurationParameters();
            parameters.setUserEmail("me@dne.com");
            parameters.setAcccountToken(authToken);
            parameters.setAccountSecret(accountSecret);
            parameters.setEnvironment(Enums.Environment.Sandbox);
            parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
            parameters.setResultFormat(Enums.Format.Json);


            EmailageClient.QueryEmail("tmp@dne.com", parameters);
        }
    }

    @Test(expected = EmailageApiRequestException.class)
    public void queryEmailSimpleServerDown() throws Exception {

        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        oStream.write(rajeshResponse.getBytes());

        ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

        HttpsURLConnection mock = mock(HttpsURLConnection.class);
        when(mock.getOutputStream()).thenReturn(oStream);
        when(mock.getInputStream()).thenReturn(iStream);

        PowerMockito.spy(EmailageClient.class);
        PowerMockito.doThrow(new IOException("test")).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));
        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmail("tmp@dne.com", parameters);

        verify(mock).getOutputStream();
        verify(mock).getInputStream();
        assertEquals(expectedResult, result);
    }

    @Test
    public void queryEmailAndIP() throws Exception {

        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        oStream.write(rajeshResponse.getBytes());

        ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

        HttpsURLConnection mock = mock(HttpsURLConnection.class);
        when(mock.getOutputStream()).thenReturn(oStream);
        when(mock.getInputStream()).thenReturn(iStream);

        PowerMockito.spy(EmailageClient.class);
        PowerMockito.doReturn(mock).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIP("tmp@dne.com","1.1.1.1",parameters);

        verify(mock).getOutputStream();
        verify(mock).getInputStream();
        assertNotNull(result);
    }

    @Test
    public void queryEmailAndIPPlusExtraArgs() throws Exception {

        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        oStream.write(rajeshResponse.getBytes());

        ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

        HttpsURLConnection mock = mock(HttpsURLConnection.class);
        when(mock.getOutputStream()).thenReturn(oStream);
        when(mock.getInputStream()).thenReturn(iStream);

        PowerMockito.spy(EmailageClient.class);
        PowerMockito.doReturn(mock).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setuser_email("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIPPlusExtraArgs("tmp@dne.com","1.1.1.1", extraInputParameter, parameters);

        verify(mock).getOutputStream();
        verify(mock).getInputStream();
        assertNotNull(result);
    }

    @Test
    public void queryEmailAndIPPlusExtraArgsNullIp() throws Exception {

        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        oStream.write(rajeshResponse.getBytes());

        ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

        HttpsURLConnection mock = mock(HttpsURLConnection.class);
        when(mock.getOutputStream()).thenReturn(oStream);
        when(mock.getInputStream()).thenReturn(iStream);

        PowerMockito.spy(EmailageClient.class);
        PowerMockito.doReturn(mock).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setuser_email("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.QueryEmailAndIPPlusExtraArgs("tmp@dne.com",null, extraInputParameter, parameters);

        verify(mock).getOutputStream();
        verify(mock).getInputStream();
        assertNotNull(result);
    }

    @Test
    public void markEmailAsFraud() throws Exception {

        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        oStream.write(rajeshResponse.getBytes());

        ByteArrayInputStream iStream = new ByteArrayInputStream(rajeshResponse.getBytes());

        HttpsURLConnection mock = mock(HttpsURLConnection.class);
        when(mock.getOutputStream()).thenReturn(oStream);
        when(mock.getInputStream()).thenReturn(iStream);

        PowerMockito.spy(EmailageClient.class);
        PowerMockito.doReturn(mock).when(EmailageClient.class,"getHttpsURLConnection", Mockito.any(URL.class));

        ExtraInputParameter extraInputParameter = new ExtraInputParameter();
        extraInputParameter.setuser_email("me@dne.com");

        ConfigurationParameters parameters = new ConfigurationParameters();
        parameters.setUserEmail("me@dne.com");
        parameters.setAcccountToken(authToken);
        parameters.setAccountSecret(accountSecret);
        parameters.setEnvironment(Enums.Environment.Sandbox);
        parameters.setHashAlgorithm(Enums.SignatureMethod.HMAC_SHA256);
        parameters.setResultFormat(Enums.Format.Json);

        EmailageResponse result = EmailageClient.MarkEmailAsFraud("tmp@dne.com", Enums.FraudType.Fraud, Enums.FraudCode.IDENTITY_THEFT_ACCOUNT_TAKE_OVER, parameters);

        verify(mock).getOutputStream();
        verify(mock).getInputStream();
        assertNotNull(result);

    }

    @Test
    public void removeUTFCharacters() {
        String data = "Bb test\t!";
        String result = EmailageClient.removeUTFCharacters(data);

        assertNotNull(result);
    }

    String rajeshResponse = "{\n" +
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
            "                \"imageurl\": \"https://app.dev.eaorg.us/Image/Get/bZ33smVLqTYWzkhDOhnykAEO7Qko9rszrajn0oPhj0.aODm9ij-.auNsQ8b3eNTkb-.png\",\n" +
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

    String expectedResult = "{    \"query\": {        \"email\": \"rajesh@yahoo.com\",        \"queryType\": \"EmailAgeVerification\",        \"count\": 1,        \"created\": \"2019-02-12T18:51:31Z\",        \"lang\": \"en-US\",        \"responseCount\": 1,        \"response_language\": \"json\",        \"results\": [            {                \"userdefinedrecordid\": \"\",                \"email\": \"rajesh@yahoo.com\",                \"eName\": \"\",                \"emailAge\": \"\",                \"email_creation_days\": \"\",                \"domainAge\": \"1995-01-18T05:00:00Z\",                \"domain_creation_days\": \"8790\",                \"firstVerificationDate\": \"2019-01-23T23:41:58Z\",                \"first_seen_days\": \"19\",                \"lastVerificationDate\": \"2019-01-29T18:22:38Z\",                \"status\": \"ValidDomain\",                \"country\": \"US\",                \"fraudRisk\": \"995 Very High\",                \"EAScore\": \"995\",                \"EAReason\": \"Fraud Level 2\",                \"EAStatusID\": \"4\",                \"EAReasonID\": \"1\",                \"EAAdviceID\": \"1\",                \"EAAdvice\": \"Fraud Review\",                \"EARiskBandID\": \"7\",                \"EARiskBand\": \"test2\",                \"source_industry\": \"Other\",                \"fraud_type\": \"Card Not Present Fraud\",                \"lastflaggedon\": \"2019-02-08T22:58:20Z\",                \"dob\": \"1986\",                \"gender\": \"male\",                \"location\": \"Dubai, United Arab Emirates\",                \"smfriends\": \"515\",                \"totalhits\": \"154\",                \"uniquehits\": \"3\",                \"imageurl\": \"https://app.dev.eaorg.us/Image/Get/bZ33smVLqTYWzkhDOhnykAEO7Qko9rszrajn0oPhj0.aODm9ij-.auNsQ8b3eNTkb-.png\",                \"emailExists\": \"Not Sure\",                \"domainExists\": \"Yes\",                \"company\": \"\",                \"title\": \"\",                \"domainname\": \"yahoo.com\",                \"domaincompany\": \"YahooInc\",                \"domaincountryname\": \"United States\",                \"domaincategory\": \"Webmail\",                \"domaincorporate\": \"No\",                \"domainrisklevel\": \"Low\",                \"domainrelevantinfo\": \"Low Risk Domain\",                \"domainrisklevelID\": \"4\",                \"domainrelevantinfoID\": \"510\",                \"domainriskcountry\": \"No\",                \"smlinks\": [                    {                        \"source\": \"Facebook\",                        \"link\": \"https://www.facebook.com/pmdrajesh\"                    },                    {                        \"source\": \"Flickr\",                        \"link\": \"https://www.flickr.com/people/44791251@N06/\"                    },                    {                        \"source\": \"Gravatar\",                        \"link\": \"https://gravatar.com/openideas123345\"                    },                    {                        \"source\": \"Vimeo\",                        \"link\": \"http://vimeo.com/user7725693\"                    }                ],                \"phone_status\": \"\",                \"shipforward\": \"\"            }        ]    },    \"responseStatus\": {        \"status\": \"success\",        \"errorCode\": \"0\",        \"description\": \"\"    }}";
}