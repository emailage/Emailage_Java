package com.emailage.javawrapper.utilities;

import javax.net.ssl.HttpsURLConnection;

/**
 * Simple wrapper for a connection to disconnect the connection when the resource block is exited.
 */
public class AutoCloseableHttpsUrlConnection implements AutoCloseable {
    private final HttpsURLConnection connection;
    public AutoCloseableHttpsUrlConnection(HttpsURLConnection connection)
    {
        this.connection = connection;
    }
    @Override
    public void close() {
        this.connection.disconnect();
    }
}
