package com.emailage.javawrapper.utilities;

import javax.net.ssl.HttpsURLConnection;

public class AutoCloseableHttpsUrlConnection implements AutoCloseable {
    private HttpsURLConnection connection;
    public AutoCloseableHttpsUrlConnection(HttpsURLConnection connection)
    {
        this.connection = connection;
    }
    @Override
    public void close() throws Exception {
        this.connection.disconnect();
    }
}
