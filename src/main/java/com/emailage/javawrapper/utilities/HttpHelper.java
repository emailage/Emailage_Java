package com.emailage.javawrapper.utilities;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class HttpHelper {

    public static HttpsURLConnection getHttpsURLConnection(URL url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
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

    public static String PostRequest(byte[] body, HttpsURLConnection conn) throws IOException {

        int bodySize = body.length;
        conn.setRequestProperty("Content-Length", Integer.toString(bodySize));
        conn.setDoOutput(true);

        StringBuilder answer = new StringBuilder();
        try (
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, StandardCharsets.UTF_8.name()))
        ) {
            String value = new String(body, StandardCharsets.UTF_8.name());
            writer.write(value);
        }

        Charset charset = Charset.forName(StandardCharsets.UTF_8.name());
        try (BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset))) {
            String str;
            while (null != (str = input.readLine())) {
                answer.append(str);
            }
        }
        return answer.toString();
    }
}
