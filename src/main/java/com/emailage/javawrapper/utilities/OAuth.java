package com.emailage.javawrapper.utilities;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.Key;
import java.util.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


public class OAuth {
    private static final Random _Random = new Random();
    private static final String _UnreservedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.~";
    public final static String HMACSHA1 = "HMAC-SHA1";
    private final static String HMACSHA256 = "HMAC-SHA256";
    private final static String HMACSHA384 = "HMAC-SHA384";
    private final static String HMACSHA512 = "HMAC-SHA512";

    public static String getUrl(
            String method, 
            String hashAlgorithm,
            String url, 
            String consumerKey, 
            String consumerSecret) 
    {
        if (method == null)
            method = "GET";

        if (hashAlgorithm == null)
            hashAlgorithm = HMACSHA1;

        double nowDates = (new Date()).getTime(); // from 1970.1.1

        String timestamp = String.valueOf(Math.floor(nowDates));
        String nonce = GetRandomString(10);

		// for example: 
		// GET https://api.emailage.com/EmailAgeValidator/?format=jsonxxx...
		// we just need the part after the ?, we do not need the part before
		// that for generating the oauth sig

        
        int index = url.indexOf('?');
        String querystring;

        if (index == -1) {
            querystring = "";
        } else {
            querystring = url.substring(index + 1);
            url = url.substring(0, index);
        }

		// now we need to take the query strings out and then apply the oauth related strings inside.
		// once we have it, we break the parameters out and then generate the entire query string. 
		// Oauth will take the entire query string and generate the sig  out of that. 
		// after the sig is generated, we need to append them to the query string the customer will eventually send out.
        // ToDO: this is the oauth standard, and we also need to sort it.
        
        String[] splString = querystring.split("&");
        Map<String, String> query = new HashMap<>();
            
        for (String splString1 : splString) {
            int in = splString1.indexOf("=");
            if (in == -1) {
                query.put(splString1, null);
            } else {
                String key = splString1.substring(0, in);
                String value = splString1.substring(in + 1);
                query.put(key, value);
            }
        }

        StringBuilder sb = new StringBuilder();
        
		for (String key : query.keySet()) {
			sb.append(((String) key).concat(query.get(key) == null ? "" : "="
		           + query.get(key))).append("&");
		}

        sb.append("oauth_consumer_key=").append(consumerKey).append("&");
        sb.append("oauth_nonce=").append(nonce).append("&");
        sb.append("oauth_signature_method=").append(hashAlgorithm).append("&");
        sb.append("oauth_timestamp=").append(timestamp).append("&");
        sb.append("oauth_version=").append(1.0);
        
        querystring = sb.toString();

        String data = "";
        try {
            data = method.toUpperCase().concat("&")
                .concat(URLEncoder.encode(url, "utf-8")).concat("&")
                .concat(URLEncoder.encode(querystring, "utf-8"));
        } catch (UnsupportedEncodingException e1) {

        	e1.printStackTrace();
        }

        
        String sig = "";
        
        try {
            sig = URLEncoder.encode(
            new String(toBase64(HmacEncrypt(data,
                consumerSecret + "&", hashAlgorithm))), "utf-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return url.concat("?").concat(querystring).concat("&oauth_signature=").concat(sig);
    }

    private static String GetRandomString(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++)
                result.append(_UnreservedChars.charAt(_Random.nextInt(25)));
        return result.toString();
    }

    public static byte[] HmacEncrypt(String encryptText, String encryptKey, String algorithm)
                    throws Exception {
        byte[] keybytes = encryptKey.getBytes("UTF-8");
        Mac mac;
        Key key;
        switch(algorithm) {
            case HMACSHA1:
                mac = Mac.getInstance("HMACSHA1");
                key = new SecretKeySpec(keybytes, "HMACSHA1");
                mac.init(key);
                break;
            case HMACSHA256:
                mac = Mac.getInstance("HMACSHA256");
                key = new SecretKeySpec(keybytes, "HMACSHA256");
                mac.init(key);
                break;
            case HMACSHA384:
                mac = Mac.getInstance("HMACSHA384");
                key = new SecretKeySpec(keybytes, "HMACSHA384");
                mac.init(key);
                break;
            case HMACSHA512:
                mac = Mac.getInstance("HMACSHA512");
                key = new SecretKeySpec(keybytes, "HMACSHA512");
                mac.init(key);
                break;
            default:
                mac = Mac.getInstance("HMACSHA1");
                key = new SecretKeySpec(keybytes, "HMACSHA1");
                mac.init(key);
                break;                
        }
        
        byte[] text = encryptText.getBytes("UTF-8");
        return mac.doFinal(text);
    }
    
	/*
	 * for generating the base64
	 */
	public static String toBase64(byte[] bs) {
        return Base64.encodeBase64String(bs);
	}
}
