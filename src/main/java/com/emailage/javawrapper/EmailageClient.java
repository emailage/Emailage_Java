package com.emailage.javawrapper;

import com.emailage.javawrapper.model.ConfigurationParameters;
import com.emailage.javawrapper.model.Enums;
import com.emailage.javawrapper.model.ExtraInputParameter;
import com.emailage.javawrapper.model.exception.EmailageApiRequestException;
import com.emailage.javawrapper.model.exception.EmailageParameterException;
import com.emailage.javawrapper.model.response.EmailageResponse;
import com.emailage.javawrapper.utilities.AutoCloseableHttpsUrlConnection;
import com.emailage.javawrapper.utilities.OAuth;
import com.emailage.javawrapper.utilities.Validation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sample Java Wrapper Class
 */
public class EmailageClient {
	/* Email Query Endpoint */
	/* SANDBOX Environment */
	private static final String RequestBaseUrlSand = "https://sandbox.emailage.com/emailagevalidator/";

	/* PRODUCTION Environment */
	private static final String RequestBaseUrlProd = "https://api.emailage.com/emailagevalidator/";


	/* Email Fraud Endpoint */
	/* SANDBOX Environment */
	private static final String RequestBaseFraudUrlSand = "https://sandbox.emailage.com/emailageValidator/flag/";

	/* PRODUCTION Environment */
	private static final String RequestBaseFraudUrlProd = "https://api.emailage.com/emailageValidator/flag/";

	/** Use java.util.logging.  NOTE: this can be captured and redirected to other logging libraries using slf4j. */
	private static Logger Log = Logger.getLogger(EmailageClient.class.getName());

	/** <p>Regex Pattern is thread-safe, but regex matcher is not.</p>
	 * <p>"Instances of this class are immutable and are safe for use by multiple concurrent threads. Instances of the Matcher class are not safe for such use.", see Oracle's docs <a href="https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html">here</a>.</p>
	 */
	private static Pattern compiledPattern = Pattern.compile("\\\\u(\\p{XDigit}{4})");

	private static Pattern compiledUTF8Pattern = Pattern.compile("\ufeff");

	/**
	 * <p>Jackson ObjectMapper is fully thread-safe according to the Jackson docs <a href="http://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.9.8/com/fasterxml/jackson/databind/ObjectMapper.html">here.</a></p>
	 */
	private static ObjectMapper mapper;

	/** Static block that executes before everything else */
	static
	{
		// Configure jackson-afterburner
		mapper = new ObjectMapper();
		mapper.registerModule(new AfterburnerModule());
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
		return deserialize(PostQuery(APIUrl.Query, null, query, parameters));
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
		return deserialize(PostQuery(APIUrl.Query,null, queryBuffer.toString(), parameters));
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
	public static EmailageResponse QueryEmailAndIPPlusExtraArgs(String email, String IP, ExtraInputParameter extraArgs,
															 ConfigurationParameters parameters)
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
	public static EmailageResponse MarkEmailAsFraud(String email, Enums.FraudType fraudType, Enums.FraudCode fraudCode,
												 ConfigurationParameters parameters)
			throws EmailageApiRequestException, IOException {

		// Option #1 Email+IP
		String query = "query=" + java.net.URLEncoder.encode(email, StandardCharsets.UTF_8.name())
		// Specify Fraud Code ID.
		// Only applicable if you are marking an email as Fraud.
				+ "&fraudcodeID=" + fraudCode.toInt()
				// Specify Fraud Type: Fraud or Good
				+ "&flag=" + fraudType;

		return deserialize(PostQuery(APIUrl.MarkAsFraud, fraudType, query, parameters));
	}

	/**
	 * Remove UTF-8 characters that could impact
	 * @param data String to be filtered
	 * @return Filtered string
	 */
	public static String removeUTFCharacters(String data) {
		Matcher m = compiledPattern.matcher(data);
		StringBuffer buf = new StringBuffer(data.length());

		while (m.find()) {
			String ch = String.valueOf((char) Integer.parseInt(m.group(1), 16));
			m.appendReplacement(buf, Matcher.quoteReplacement(ch));
		}
		m.appendTail(buf);
		return buf.toString();
	}

	protected static HttpsURLConnection getHttpsURLConnection(URL url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
		double version = Double.parseDouble(System.getProperty("java.specification.version"));
		SSLContext context;
		HttpsURLConnection conn;
		if (version == 1.7) {
			context = SSLContext.getInstance("TLSv1.1");
			context.init(null, null, null);
			// Tell the URLConnection to use a SocketFactory from our
			// SSLContext
			conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(context.getSocketFactory());
		} else {
			// if Java version is not 1.7( assuming 1.7 and above actually)
			// use the system default.
			conn = (HttpsURLConnection) url.openConnection();
		}
		return conn;
	}

	private static String PostQuery(APIUrl endpoint, Enums.FraudType fraudType, String urlParameters,
			ConfigurationParameters parameters)
			throws EmailageApiRequestException, MalformedURLException {

		String resultFormat = parameters.getResultFormat().toString();

		String hashAlgorithmString = parameters.getHashAlgorithm().toString();

		String endpointurl = null;

		if (parameters.getEnvironment() == Enums.Environment.Production && endpoint == APIUrl.Query)
			endpointurl = RequestBaseUrlProd;
		else if (parameters.getEnvironment() == Enums.Environment.Sandbox && endpoint == APIUrl.Query)
			endpointurl = RequestBaseUrlSand;
		else if (parameters.getEnvironment() == Enums.Environment.Production && endpoint == APIUrl.MarkAsFraud)
			endpointurl = RequestBaseFraudUrlProd;
		else if (parameters.getEnvironment() == Enums.Environment.Sandbox && endpoint == APIUrl.MarkAsFraud)
			endpointurl = RequestBaseFraudUrlSand;

		String oriUrl;
		if ( null != fraudType){
			oriUrl = endpointurl + "?flag="+ fraudType.toString()+"&format=" + resultFormat;

		} else {
			oriUrl = endpointurl + "?format=" + resultFormat;
		}

		if (parameters.getUserEmail() != null && parameters.getUserEmail().trim().length() > 0) {
			oriUrl = oriUrl + "&user_email=" + parameters.getUserEmail();
		}

		// Only support POST at the moment, but the oauth function has the
		// capability of supporting get too.
		String requestUrl = OAuth.getUrl("POST", hashAlgorithmString, oriUrl, parameters.getAccountSecret(), parameters.getAcccountToken());
		Log.finer("requestUrl: " + requestUrl);

		/* POST value */
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;

		URL url = new URL(requestUrl);

		// create an object for return
		StringBuilder answer = new StringBuilder();


		try {

			HttpsURLConnection conn = getHttpsURLConnection(url);
			try(AutoCloseable conc = new AutoCloseableHttpsUrlConnection(conn)) {

				conn.setRequestProperty("Content-Language", "en-US");
				conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
				conn.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());
				conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
				conn.setDoOutput(true);

				try (
					DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, StandardCharsets.UTF_8.name()))
				) {
					String value = new String(postData, StandardCharsets.UTF_8.name());
					writer.write(value);
				}

				Charset charset = Charset.forName(StandardCharsets.UTF_8.name());
				try (BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset))) {
					String str;
					while (null != (str = input.readLine())) {
						answer.append(str);
					}
				}
			}
		} catch (Exception e1) {
			throw new EmailageApiRequestException("Could not complete API request",e1);
		}

		return removeUTFCharacters(answer.toString());
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
     * @throws IllegalArgumentException
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
