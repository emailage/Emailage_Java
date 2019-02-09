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

import com.emailage.javawrapper.model.EmailageParameterException;
import com.emailage.javawrapper.model.Enums;
import com.emailage.javawrapper.model.ExtraInputParameter;
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

	
	/**
	 * ACCOUNT SID. You can find the Account SID in the Settings menu -> API Key
	 * Info.
	 */
	private static final String AccountSID = "INPUT--SID";

	/**
	 * AUTH TOKEN. You can find the AUTH TOKEN in the Settings menu -> API Key
	 * Info.
	 */
	private static final String AuthToken = "INPUT--KEY";

	/** Use java.util.logging.  NOTE: this can be captured and redirected to other logging libraries using slf4j. */
	private static Logger Log = Logger.getLogger(EmailageClient.class.getName());

	public static URL Url;

	/**
	 * This method is used to query an Email Address.
	 * 
	 * @param email
	 *            Transaction Email Address
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML see {@link Enums.Format}.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512" see {@link Enums.SignatureMethod}.
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @param environment
	 * 			  Environment where the call is to be executed.  Valid values: sandbox or production, see {@link Enums.Environment}.
	 * @return Result of the API call.
	 */
	public static String QueryEmail(String email, Enums.Format resultFormat, Enums.SignatureMethod hashAlgorithm,
			String user_email, Enums.Environment environment)
			throws IOException, IllegalArgumentException {

		validateParams(email);
		String query = "query=" + java.net.URLEncoder.encode(email, "UTF-8");
		return PostQuery(environment, APIUrl.Query, query, resultFormat, hashAlgorithm, user_email, null);
	}

	/**
	 * This method is used to query an Email Address + IP.
	 * 
	 * @param email
	 *            Transaction Email Address
	 * @param IP
	 *            IP of the transaction.
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML see {@link Enums.Format}.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512" see {@link Enums.SignatureMethod}.
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @param environment
	 * 			  Environment where the call is to be executed.  Valid values: sandbox or production, see {@link Enums.Environment}.
	 * @return Result of the API call.
	 */
	public static String QueryEmailAndIP(String email, String IP, Enums.Format resultFormat,
			Enums.SignatureMethod hashAlgorithm, String user_email, Enums.Environment environment)
			throws IOException, IllegalArgumentException {

		validateParams(email, IP);
		String query = "query=" + java.net.URLEncoder.encode(email + "+" + IP, "UTF-8");
		return PostQuery(environment, APIUrl.Query, query, resultFormat, hashAlgorithm, user_email, null);
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
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML see {@link Enums.Format}.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512" see {@link Enums.SignatureMethod}.
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @param environment
	 * 			  Environment where the call is to be executed.  Valid values: sandbox or production, see {@link Enums.Environment}.
	 * @return Result of the API call.
	 */
	public static String QueryEmailAndIPPlusExtraArgs(String email, String IP, ExtraInputParameter extraArgs,
			Enums.Format resultFormat, Enums.SignatureMethod hashAlgorithm, String user_email, Enums.Environment environment)
			throws IOException, EmailageParameterException {

		validateParams(email, IP);
		String query = "query=" + java.net.URLEncoder.encode(email + "+" + IP, "UTF-8");
		query += extraArgs.buildExtraInputParameterRequest();

		return PostQuery(environment, APIUrl.Query, query, resultFormat, hashAlgorithm, user_email, null);
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
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML see {@link Enums.Format}.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512" see {@link Enums.SignatureMethod}.
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @param environment
	 * 			  Environment where the call is to be executed.  Valid values: sandbox or production, see {@link Enums.Environment}.
	 * @return Result of the API call.
	 */
	public static String MarkEmailAsFraud(String email, Enums.FraudType fraudType, Enums.FraudCode fraudCode,
										  Enums.Format resultFormat, Enums.SignatureMethod hashAlgorithm, String user_email,
										  Enums.Environment environment) throws IOException {

		// Option #1 Email+IP
		String query = "query=" + java.net.URLEncoder.encode(email, "UTF-8")
		// Specify Fraud Code ID.
		// Only applicable if you are marking an email as Fraud.
				+ "&fraudcodeID=" + fraudCode.toInt()
				// Specify Fraud Type: Fraud or Good
				+ "&flag=" + fraudType;

		return PostQuery(environment, APIUrl.MarkAsFraud, query, resultFormat, hashAlgorithm, user_email, fraudType);
	}

	private static String PostQuery(Enums.Environment environment, APIUrl endpoint, String urlParameters,
			Enums.Format format, Enums.SignatureMethod hashAlgorithm, String user_email, Enums.FraudType fraudType)
			throws IOException {

		String resultFormat = format.toString();

		String hashAlgorithmString = hashAlgorithm.toString();

		String endpointurl = null;

		if (environment == Enums.Environment.Production && endpoint == APIUrl.Query)
			endpointurl = RequestBaseUrlProd;
		else if (environment == Enums.Environment.Sandbox && endpoint == APIUrl.Query)
			endpointurl = RequestBaseUrlSand;
		else if (environment == Enums.Environment.Production && endpoint == APIUrl.MarkAsFraud)
			endpointurl = RequestBaseFraudUrlProd;
		else if (environment == Enums.Environment.Sandbox && endpoint == APIUrl.MarkAsFraud)
			endpointurl = RequestBaseFraudUrlSand;

		String oriUrl;
		if ( null != fraudType){
			oriUrl = endpointurl + "?flag="+ fraudType.toString()+"&format=" + resultFormat;

		} else {
			oriUrl = endpointurl + "?format=" + resultFormat;
		}

		if (user_email != null && user_email.trim().length() > 0) {
			oriUrl = oriUrl + "&user_email=" + user_email;
		}

		// Only support POST at the moment, but the oauth function has the
		// capability of supporting get too.
		String requestUrl = OAuth.getUrl("POST", hashAlgorithmString, oriUrl, AccountSID, AuthToken);
		Log.finer("requestUrl: " + requestUrl);

		/* POST value */
		byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;

		URL url = new URL(requestUrl);

		// Create an SSLContext
		SSLContext context;

		// create an object for return
		StringBuilder answer = new StringBuilder();
		DataOutputStream wr = null;
		BufferedWriter writer = null;
		BufferedReader input = null;

		try {
			double version = Double.parseDouble(System.getProperty("java.specification.version"));
			HttpsURLConnection conn;

			// TODO: how to check for max TLS version instead of checking for java version
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

			conn.setRequestProperty("Content-Language", "en-US");
			conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			conn.setRequestProperty("Accept-Charset", "UTF-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setDoOutput(true);

			wr = new DataOutputStream(conn.getOutputStream());
			writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
			String value = new String(postData, "UTF-8");
			writer.write(value);
			writer.close();
			wr.close();

			Charset charset = Charset.forName("UTF-8");
			input = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

			String str;
			while (null != (str = input.readLine())) {
				answer.append(str);
			}
			input.close();

		} catch (IOException | NoSuchAlgorithmException | KeyManagementException e1) {
			e1.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
			if (wr != null) {
				wr.close();
			}
			if (input != null) {
				input.close();
			}
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
