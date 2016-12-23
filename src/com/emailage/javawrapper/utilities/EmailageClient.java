package com.emailage.javawrapper.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import com.emailage.javawrapper.model.Enums;
import com.emailage.javawrapper.model.ExtraInputParameter;

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

	/*
	 * ACCOUNT SID. You can find the Account SID in the Settings menu -> API Key
	 * Info.
	 */
	private static final String AccountSID = "INPUT--SID";

	/*
	 * AUTH TOKEN. You can find the AUTH TOKEN in the Settings menu -> API Key
	 * Info.
	 */
	private static final String AuthToken = "INPUT--KEY";
	
	private static Enums.FraudFlag FraudType;

	/**
	 * This method is used to query an Email Address.
	 * 
	 * @param email
	 *            Transaction Email Address
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512"
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @return Result of the API call.
	 */
	public static String QueryEmail(String email, Enums.Format resultFormat, Enums.SignatureMethod hashAlgorithm,
			String user_email, Enums.Environment environment) throws UnsupportedEncodingException, IOException {
		String query = "query=" + java.net.URLEncoder.encode(email, "UTF-8");

		return PostQuery(environment, APIUrl.Query, query, resultFormat, hashAlgorithm, user_email);
	}

	/**
	 * This method is used to query an Email Address + IP.
	 * 
	 * @param email
	 *            Transaction Email Address
	 * @param IP
	 *            IP of the transaction.
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512"
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @return Result of the API call.
	 */
	public static String QueryEmailAndIP(String email, String IP, Enums.Format resultFormat,
			Enums.SignatureMethod hashAlgorithm, String user_email, Enums.Environment environment)
			throws UnsupportedEncodingException, IOException {
		String query = "query=" + java.net.URLEncoder.encode(email + "+" + IP, "UTF-8");

		return PostQuery(environment, APIUrl.Query, query, resultFormat, hashAlgorithm, user_email);
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
	 *            Format of the API response call. Valid values: JSON or XML.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512"
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @return Result of the API call.
	 */
	public static String QueryEmailAndIPPlusExtraArgs(String email, String IP, ExtraInputParameter extraArgs,
			Enums.Format resultFormat, Enums.SignatureMethod hashAlgorithm, String user_email, Enums.Environment environment)
			throws UnsupportedEncodingException, IOException {

		String query = "query=" + java.net.URLEncoder.encode(email + "+" + IP, "UTF-8");

		// Loop through the extra args and add them to query string, if any.
		// Enumeration e = extraArgs.keys();
		// while (e.hasMoreElements()) {
		// String key = (String) e.nextElement();
		// query += "&" + key + "=" + extraArgs.get(key);
		// }
		try {
			query += extraArgs.buildExtraInputParameterRequest();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return PostQuery(environment, APIUrl.Query, query, resultFormat, hashAlgorithm, user_email);
	}
	/*
	 * fraudcodeID parameter Reference: Fraud Code ID Description 1 Card Not
	 * Present Fraud 2 Customer Dispute (Chargeback) 3 First Party Fraud 4 First
	 * Payment Default 5 Identify Theft (Fraud Application) 6 Identify Theft
	 * (Account Take Over) 7 Suspected Fraud (Not Confirmed) 8 Synthetic ID 9
	 * Other
	 */

	/**
	 * This method is used to report cases where a confirmed fraud or confirmed
	 * good email is found at the customer site.
	 * 
	 * @param email
	 *            Email to be marked as either Fraud or Good
	 * @param fraudType
	 *            Value indicating the fraud type. Valid values: neutral, good
	 *            and fraud.
	 * @param fraudCodeID
	 *            ID of the fraud code. Only required if you are marking an
	 *            email as Fraud. See list above
	 * @param resultFormat
	 *            Format of the API response call. Valid values: JSON or XML.
	 * @param hashAlgorithm
	 *            Hash Algorithm. Valid values: "HMAC-SHA1", "HMAC-SHA256",
	 *            "HMAC-SHA384","HMAC-SHA512"
	 * @param user_email
	 *            OPTIONAL. If provided, this field will be used to impersonate
	 *            the API call.
	 * @return Result of the API call.
	 */
	public static String MarkEmailAsFraud(String email, Enums.FraudFlag fraudType, int fraudCodeID,
			Enums.Format resultFormat, Enums.SignatureMethod hashAlgorithm, String user_email,
			Enums.Environment environment) throws IOException {

		// Option #1 Email+IP
		String query = "query=" + java.net.URLEncoder.encode(email, "UTF-8")
		// Specify Fraud Code ID.
		// Only applicable if you are marking an email as Fraud.
				+ "&fraudcodeID=" + fraudCodeID
				// Specify Fraud Type: Fraud or Good
				+ "&flag=" + fraudType;
		
		FraudType = fraudType;

		return PostQuery(environment, APIUrl.MarkAsFraud, query, resultFormat, hashAlgorithm, user_email);
	}

	private static String PostQuery(Enums.Environment environment, APIUrl endpoint, String urlParameters,
			Enums.Format format, Enums.SignatureMethod hashAlgorithm, String user_email) throws IOException {

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
		if ( endpoint == APIUrl.MarkAsFraud){
			oriUrl = endpointurl + "?flag="+ FraudType.toString()+"&format=" + resultFormat;

		} else {
			oriUrl = endpointurl + "?format=" + resultFormat;
		}

		if (user_email != null && user_email.trim().length() > 0) {
			oriUrl = oriUrl + "&user_email=" + user_email;
		}

		// Only support POST at the moment, but the oauth function has the
		// capability of supporting get too.
		String requestUrl = OAuth.getUrl("POST", hashAlgorithmString, oriUrl, AccountSID, AuthToken);

		System.out.println("requestUrl: " + requestUrl);

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

	static enum APIUrl {
		Query, MarkAsFraud;

	}

}
