package com.emailage.javawrapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import com.emailage.javawrapper.model.*;
import com.emailage.javawrapper.utilities.AutoCloseableHttpsUrlConnection;
import com.emailage.javawrapper.utilities.OAuth;
import com.emailage.javawrapper.utilities.Validation;

/**
 * Sample Java Wrapper Class
 */
public class EmailageClient {
	/* Email Query Endpoint */
	/* SANDBOX Environment */
	private static final String RequestBaseUrlSand = "https://sandbox.emailage.com/emailagevalidator/";

	/** PRODUCTION Environment */
	private static final String RequestBaseUrlProd = "https://api.emailage.com/emailagevalidator/";

	/* Email Fraud Endpoint */
	/** SANDBOX Environment */
	private static final String RequestBaseFraudUrlSand = "https://sandbox.emailage.com/emailageValidator/flag/";

	/** PRODUCTION Environment */
	private static final String RequestBaseFraudUrlProd = "https://api.emailage.com/emailageValidator/flag/";
	
	/**
	 * Defaults to validating params before querying API 
	 * Note: Uses Apache Commons validator for validation of email and IP.  Must include this library for validation to work
	 * Please see documentation here : https://commons.apache.org/proper/commons-validator/
	 * You can disable this by setting to false
	 */
	private static final boolean validateEmailAndIpInClient = true;

	/** Use java.util.logging.  NOTE: this can be captured and redirected to other logging libraries using slf4j. */
	private static Logger Log = Logger.getLogger(EmailageClient.class.getName());

	public static URL Url;

	/**
	 * This method is used to query an Email Address.
	 * 
	 * @param email
	 *            Transaction Email Address
	 * @param parameters
	 * 			  Security parameter information, see {@link ConfigurationParameters}
	 * @return Result of the API call.
	 * @throws IOException test
	 * @throws IllegalArgumentException test
	 * @throws EmailageApiRequestException test
	 */
	public static String QueryEmail(String email, ConfigurationParameters parameters)
			throws IOException, IllegalArgumentException, EmailageApiRequestException {

		validateParams(email);
		String query = "query=" + java.net.URLEncoder.encode(email, "UTF-8");
		return PostQuery(APIUrl.Query, null, query, parameters);
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
	 * @throws IOException test
	 * @throws IllegalArgumentException test
	 * @throws EmailageApiRequestException test
	 */
	public static String QueryEmailAndIP(String email, String IP, ConfigurationParameters parameters)
			throws IOException, IllegalArgumentException, EmailageApiRequestException {

		validateParams(email, IP);
		String query = "query=" + java.net.URLEncoder.encode(email + "+" + IP, "UTF-8");
		return PostQuery(APIUrl.Query,null, query, parameters);
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
	 * @throws IOException test
	 * @throws IllegalArgumentException test
	 * @throws EmailageApiRequestException test
	 */
	public static String QueryEmailAndIPPlusExtraArgs(String email, String IP, ExtraInputParameter extraArgs,
			ConfigurationParameters parameters)
			throws IOException, EmailageParameterException, EmailageApiRequestException {

		validateParams(email, IP);
		String query = "query=" + java.net.URLEncoder.encode(email + "+" + IP, "UTF-8");
		query += extraArgs.buildExtraInputParameterRequest();

		return PostQuery(
				APIUrl.Query,
				null,
				query,
				parameters);
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
	 * @throws IOException test
	 * @throws IllegalArgumentException test
	 * @throws EmailageApiRequestException test
	 */
	public static String MarkEmailAsFraud(String email, Enums.FraudType fraudType, Enums.FraudCode fraudCode,
										  ConfigurationParameters parameters)
			throws IOException, EmailageApiRequestException {

		// Option #1 Email+IP
		String query = "query=" + java.net.URLEncoder.encode(email, "UTF-8")
		// Specify Fraud Code ID.
		// Only applicable if you are marking an email as Fraud.
				+ "&fraudcodeID=" + fraudCode.toInt()
				// Specify Fraud Type: Fraud or Good
				+ "&flag=" + fraudType;

		return PostQuery(APIUrl.MarkAsFraud, fraudType, query, parameters);
	}

	private static String PostQuery(APIUrl endpoint, Enums.FraudType fraudType, String urlParameters,
			ConfigurationParameters parameters)
			throws IOException, EmailageApiRequestException {

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
				conn.setRequestProperty("Accept-Charset", "UTF-8");
				conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
				conn.setDoOutput(true);

				try (
					DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"))
				) {
					String value = new String(postData, "UTF-8");
					writer.write(value);
				}

				Charset charset = Charset.forName("UTF-8");
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

		return removeUTFCharacters(answer.toString()).toString();
	}

	public static StringBuffer removeUTFCharacters(String data) {
		Pattern p = Pattern.compile("\\\\u(\\p{XDigit}{4})");
		Matcher m = p.matcher(data);
		StringBuffer buf = new StringBuffer(data.length());

		while (m.find()) {
			String ch = String.valueOf((char) Integer.parseInt(m.group(1), 16));
			m.appendReplacement(buf, Matcher.quoteReplacement(ch));
		}
		m.appendTail(buf);
		return buf;
	}

	protected static HttpsURLConnection getHttpsURLConnection(URL url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
		double version = Double.parseDouble(System.getProperty("java.specification.version"));
		SSLContext context;
		HttpsURLConnection conn;// TODO: MKD how to check for max TLS version instead of checking for java version
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
	
	private static boolean validateParams(String email) throws IllegalArgumentException {
		if (validateEmailAndIpInClient && !Validation.validateEmail(email)) {
			throw new IllegalArgumentException("Email supplied is not valid : " + email);
		}
		return true;
	}

	private static boolean validateParams(String email, String ipAddress) throws IllegalArgumentException {
		if (validateEmailAndIpInClient) {
			if (!Validation.validateEmail(email)) {
				throw new IllegalArgumentException("Email supplied is not valid : " + email);
			} else if (!Validation.validateIpAddress(ipAddress)) {
				throw new IllegalArgumentException("Ip Address supplied is not a valid ipv4 or ipv6 address : " + email);
			}
		}
		return true;
	}


	private enum APIUrl {
		Query, MarkAsFraud

	}

}
