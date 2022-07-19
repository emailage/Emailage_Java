package com.emailage.javawrapper;

import com.emailage.javawrapper.model.ConfigurationParameters;
import com.emailage.javawrapper.model.Enums;
import com.emailage.javawrapper.model.ExtraInputParameter;
import com.emailage.javawrapper.model.exception.EmailageApiRequestException;
import com.emailage.javawrapper.model.exception.EmailageParameterException;
import com.emailage.javawrapper.model.response.EmailageResponse;
import com.emailage.javawrapper.utilities.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.blackbird.BlackbirdModule;


import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sample Java Wrapper Class
 */
public class EmailageClient {
	/* Email Query Endpoint */

	/* SANDBOX Environment */
	private static final String RequestBaseUrlSand = "https://api.dev.eaorg.us/EmailAgeValidator/";


	/* PRODUCTION Environment */
	private static final String RequestBaseUrlProd = "https://api.emailage.com/emailagevalidator/";


	/* Email Fraud Endpoint */
	/* SANDBOX Environment */
	private static final String RequestBaseFraudUrlSand = "https://sandbox.emailage.com/emailageValidator/flag/";

	/* PRODUCTION Environment */
	private static final String RequestBaseFraudUrlProd = "https://api.emailage.com/emailageValidator/flag/";

	/** Use java.util.logging.  NOTE: this can be captured and redirected to other logging libraries using slf4j. */
	private static final Logger Log = Logger.getLogger(EmailageClient.class.getName());

	/** <p>Regex Pattern is thread-safe, but regex matcher is not.</p>
	 * <p>"Instances of this class are immutable and are safe for use by multiple concurrent threads. Instances of the Matcher class are not safe for such use.", see Oracle's docs <a href="https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html">here</a>.</p>
	 */
	private static final Pattern compiledUTF8Pattern = Pattern.compile("\ufeff");

	/**
	 * <p>Jackson ObjectMapper is fully thread-safe according to the Jackson docs <a href="http://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.9.8/com/fasterxml/jackson/databind/ObjectMapper.html">here.</a></p>
	 */
	private static final ObjectMapper mapper;

	public static HttpHelper httpHelper;

	/** Static block that executes before everything else
	 */
	static
	{
		// Configure jackson-blackbird
		mapper = new ObjectMapper();
		mapper.registerModule(new BlackbirdModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

		httpHelper = new HttpHelper();
	}

	/**
	 * This method is used to query an Email Address.
	 *
	 * @param email
	 *            Transaction Email Address
	 * @param parameters
	 * 			  Security parameter information, see {@link ConfigurationParameters}
	 * @return Result of the API call.
	 * @throws IOException If JSON deserialization fails, the target url is incorrect, or UTF-8 is not supported by the JVM.
	 * @throws EmailageApiRequestException If there is an unexpected issue sending the data to the server or there an issue retrieving a response from the server.
	 */
	public static EmailageResponse QueryEmail(String email, ConfigurationParameters parameters)
			throws IOException, EmailageApiRequestException {

		validateParams(email, parameters.isValidateBeforeSending());
		String query = "query=" + java.net.URLEncoder.encode(email, StandardCharsets.UTF_8.name());
		String result = PostQuery(APIUrl.Query, null, query, parameters);
		String decodedString =  java.net.URLDecoder.decode(result, StandardCharsets.UTF_8.name());
		return deserialize(decodedString);
	}

	/**
	 * This method is used to query an Email Address + IP.
	 *
	 * @param email
	 *            Transaction Email Address
	 * @param IP
	 *            IP of the transaction.
	 * @param parameters
	 * 			  Security parameter information, see {@link ConfigurationParameters}
	 * @return Result of the API call.
	 * @throws IOException If JSON deserialization fails, the target url is incorrect, or UTF-8 is not supported by the JVM.
	 * @throws EmailageApiRequestException If there is an unexpected issue sending the data to the server or there an issue retrieving a response from the server.
	 */
	public static EmailageResponse QueryEmailAndIP(String email, String IP, ConfigurationParameters parameters)
			throws IOException, EmailageApiRequestException {

		validateParams(email, IP, parameters.isValidateBeforeSending());
		String queryElement = constructQueryField(email, IP);

		StringBuffer queryBuffer = new StringBuffer("query=");
		queryBuffer.append(queryElement);
		String result = PostQuery(APIUrl.Query,null, queryBuffer.toString(), parameters);
		String decodedString =  java.net.URLDecoder.decode(result, StandardCharsets.UTF_8.name());
		return deserialize(decodedString);
	}

	/**
	 * This method is used to query an Email Address passing extra
	 * arguments, such as billing zip code, city, country and so on.
	 *
	 * @param email
	 *            Transaction Email Address
	 * @param extraArgs
	 *            Hash table containing a list of extra arguments.
	 * @param parameters
	 * 			  Security parameter information, see {@link ConfigurationParameters}
	 * @return Result of the API call.
	 * @throws IOException If JSON deserialization fails, the target url is incorrect, or UTF-8 is not supported by the JVM.
	 * @throws EmailageApiRequestException If there is an unexpected issue sending the data to the server or there an issue retrieving a response from the server.
	 * @throws EmailageParameterException If there is a problem with the parsing of the extraInputParameters.
	 */
	public static EmailageResponse QueryEmailPlusExtraArgs(String email, ExtraInputParameter extraArgs, ConfigurationParameters parameters)
			throws IOException, EmailageParameterException, EmailageApiRequestException {

		validateParams(email, parameters.isValidateBeforeSending());
		String queryElement = constructQueryField(email, null);

		StringBuffer queryBuffer = new StringBuffer("query=");
		queryBuffer.append(queryElement);
		queryBuffer.append(extraArgs.buildExtraInputParameterRequest());

		return  deserialize(PostQuery(
				APIUrl.Query,
				null,
				queryBuffer.toString(),
				parameters));
	}

	/**
	 * This method is used to query an Email Address + IP passing extra
	 * arguments, such as billing zip code, city, country and so on.
	 *
	 * @param email
	 *            Transaction Email Address
	 * @param IP
	 *            IP of the transaction.
	 * @param extraArgs
	 *            Hash table containing a list of extra arguments.
	 * @param parameters
	 * 			  Security parameter information, see {@link ConfigurationParameters}
	 * @return Result of the API call.
	 * @throws IOException If JSON deserialization fails, the target url is incorrect, or UTF-8 is not supported by the JVM.
	 * @throws EmailageApiRequestException If there is an unexpected issue sending the data to the server or there an issue retrieving a response from the server.
	 * @throws EmailageParameterException If there is a problem with the parsing of the extraInputParameters.
	 */
	public static EmailageResponse QueryEmailAndIPPlusExtraArgs(String email, String IP, ExtraInputParameter extraArgs, ConfigurationParameters parameters)
			throws IOException, EmailageParameterException, EmailageApiRequestException {

		validateParams(email, IP, parameters.isValidateBeforeSending());
		String queryElement = constructQueryField(email, IP);

		StringBuffer queryBuffer = new StringBuffer("query=");
		queryBuffer.append(queryElement);
		queryBuffer.append(extraArgs.buildExtraInputParameterRequest());

		return  deserialize(PostQuery(
				APIUrl.Query,
				null,
				queryBuffer.toString(),
				parameters));
	}

	/**
	 * This method is used to report cases where a confirmed fraud or confirmed
	 * good email is found at the customer site.
	 *
	 * @param email
	 *            Email to be marked as either Fraud or Good
	 * @param fraudType
	 *            Value indicating the fraud type. Valid values: neutral, good
	 *            and fraud, see {@link Enums.FraudType}.
	 * @param fraudCode
	 *            Class of the fraud. Only required if you are marking an
	 *            email as Fraud, see {@link Enums.FraudCode}.
	 * @param parameters
	 * 			  Security parameter information, see {@link ConfigurationParameters}
	 * @return Result of the API call.
	 * @throws IOException If JSON deserialization fails, the target url is incorrect, or UTF-8 is not supported by the JVM.
	 * @throws EmailageApiRequestException If there is an unexpected issue sending the data to the server or there an issue retrieving a response from the server.
	 */
	public static EmailageResponse MarkEmailAsFraud(String email, Enums.FraudType fraudType, Enums.FraudCode fraudCode, ConfigurationParameters parameters)
			throws EmailageApiRequestException, IOException {

		// Option #1 Email+IP
		String query = "query=" + java.net.URLEncoder.encode(email, StandardCharsets.UTF_8.name())
				// Specify Fraud Code ID.
				// Only applicable if you are marking an email as Fraud.
				+ "&fraudcodeID=" + fraudCode.toInt()
				// Specify Fraud Type: Fraud or Good
				+ "&flag=" + fraudType;
		String result = PostQuery(APIUrl.MarkAsFraud, fraudType, query, parameters);
		String decodedString =  java.net.URLDecoder.decode(result, StandardCharsets.UTF_8.name());
		EmailageResponse response =  deserialize(decodedString);
		response.getQuery().setEmail(java.net.URLDecoder.decode(response.getQuery().getEmail(), StandardCharsets.UTF_8.name()));

		return response;
	}

	private static String PostQuery(APIUrl endpoint, Enums.FraudType fraudType, String urlParameters,
									ConfigurationParameters parameters)
			throws EmailageApiRequestException, MalformedURLException {

		String result = null;
		String resultFormat = parameters.getResultFormat().toString();
		String endpointurl = getEndpointurl(endpoint, parameters);

		String oriUrl;
		if ( null != fraudType){
			oriUrl = endpointurl + "?flag="+ fraudType.toString()+"&format=" + resultFormat + "&" + urlParameters;

		} else {
			oriUrl = endpointurl + "?format=" + resultFormat;
		}

		switch (parameters.getAuthenticationType()){
			case OAUTH1:
				result = PostOAuth1(fraudType, urlParameters, parameters, oriUrl);
				break;
			case OAUTH2:
				result = PostOAuth2(fraudType, urlParameters, parameters, oriUrl);
		}

		return result;
	}

	private static String PostOAuth2(Enums.FraudType fraudType, String urlParameters, ConfigurationParameters parameters, String oriUrl)
			throws MalformedURLException, EmailageApiRequestException {

		/* POST value */
		URL url = new URL(oriUrl);

		/* find token endpoint */
		String tokenString = String.format("%s://%s/oauth/v2/token", url.getProtocol(), url.getHost());
		URL tokenUrl = new URL(tokenString);

		String answer;
		try {

			OAuth2Wrapper auth = OAuth2Wrapper.getInstance(parameters.getAcccountToken(), parameters.getAccountSecret(), tokenUrl, httpHelper);
			answer = auth.doOAuth2Request(url, urlParameters);

		} catch (Exception e1) {
			throw new EmailageApiRequestException("Could not complete API request",e1);
		}

		return answer;
	}

	private static String PostOAuth1(Enums.FraudType fraudType, String urlParameters, ConfigurationParameters parameters, String oriUrl)
			throws MalformedURLException, EmailageApiRequestException {
		String hashAlgorithmString = parameters.getHashAlgorithm().toString();

		if (parameters.getUserEmail() != null && parameters.getUserEmail().trim().length() > 0) {
			oriUrl = oriUrl + "&user_email=" + parameters.getUserEmail();
		}

		// Only support POST at the moment, but the oauth function has the
		// capability of supporting get too.
		String requestUrl = OAuth.getUrl("POST", hashAlgorithmString, oriUrl, parameters.getAccountSecret(), parameters.getAcccountToken());
		Log.finer("requestUrl: " + requestUrl);

		/* POST value */
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		URL url = new URL(requestUrl);

		// create an object for return
		String answer;
		try {
			HttpsURLConnection conn = httpHelper.getHttpsURLConnection(url);
			try(AutoCloseable conc = new AutoCloseableHttpsUrlConnection(conn)) {
				answer = httpHelper.PostRequest(postData, conn);
			}
		} catch (Exception e1) {
			throw new EmailageApiRequestException("Could not complete API request",e1);
		}

		return answer;
	}

	private static String getEndpointurl(APIUrl endpoint, ConfigurationParameters parameters) {
		String result = null;
		if (parameters.getEnvironment() == Enums.Environment.Production && endpoint == APIUrl.Query)
			result = RequestBaseUrlProd;
		else if (parameters.getEnvironment() == Enums.Environment.Sandbox && endpoint == APIUrl.Query)
			result = RequestBaseUrlSand;
		else if (parameters.getEnvironment() == Enums.Environment.Production && endpoint == APIUrl.MarkAsFraud)
			result = RequestBaseFraudUrlProd;
		else if (parameters.getEnvironment() == Enums.Environment.Sandbox && endpoint == APIUrl.MarkAsFraud)
			result = RequestBaseFraudUrlSand;

		if( parameters.getAuthenticationType() == Enums.AuthenticationType.OAUTH2)
			result = result.concat("v2");

		return result;
	}

	private static EmailageResponse deserialize(String response) throws IOException {
		Matcher matcher = compiledUTF8Pattern.matcher(response.trim());
		EmailageResponse query = mapper.readValue(matcher.replaceFirst(""), EmailageResponse.class);
		query.getQuery().setRaw(response);
		return query;
	}

	private static boolean validateParams(String email, boolean isValidationActive) throws IllegalArgumentException {
		if (isValidationActive && !Validation.validateEmail(email)) {
			throw new IllegalArgumentException("Email supplied is not valid : " + email);
		}
		return true;
	}

	/**
	 * Validate parameters that are provided.  Either email OR IP address is required.
	 * @param email valid email address
	 * @param ipAddress valid ipv4 or ipv6 ip address
	 * @param isValidationActive whether or not to execute validation logic
	 * @return if email and/or ip address are valid.
	 * @throws IllegalArgumentException thrown if email and/or ip address is not valid
	 */
	private static boolean validateParams(String email, String ipAddress, boolean isValidationActive) throws IllegalArgumentException {
		if (isValidationActive) {
			if(email == null && ipAddress == null){
				throw new IllegalArgumentException("Email or Ip Address must be supplied");
			} else if (email != null && !Validation.validateEmail(email)) {
				throw new IllegalArgumentException("Email supplied is not valid : " + email);
			} else if (ipAddress != null && !Validation.validateIpAddress(ipAddress)) {
				throw new IllegalArgumentException("Ip Address supplied is not a valid ipv4 or ipv6 address : " + email);
			}
		}
		return true;
	}

	private static String constructQueryField(String email, String IP) throws UnsupportedEncodingException {
		StringBuffer queryElement = new StringBuffer();
		if (email != null) queryElement.append(email);
		if (email != null && IP != null) queryElement.append("+");
		if (IP != null) queryElement.append(IP);
		return java.net.URLEncoder.encode(queryElement.toString(),StandardCharsets.UTF_8.name());
	}

	private enum APIUrl {
		Query, MarkAsFraud
	}

}
