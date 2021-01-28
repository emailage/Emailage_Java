package com.emailage.javawrapper.utilities;

import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HttpHelperTest {

    private HttpHelper target;

    @Before
    public void setup(){
        target = new HttpHelper();
    }

    @Test
    public void SuccessfullyConnect() throws Exception {

        OutputStream outputMock = mock(OutputStream.class);

        HttpsURLConnection connectionMock = mock(HttpsURLConnection.class);
        when(connectionMock.getOutputStream()).thenReturn(outputMock);
        when(connectionMock.getInputStream()).thenReturn(new ByteArrayInputStream("result value".getBytes(StandardCharsets.UTF_8)));

        String result = target.PostRequest("request value".getBytes(StandardCharsets.UTF_8), connectionMock);

        verify(connectionMock, times(1)).getOutputStream();
        verify(connectionMock, times(1)).getInputStream();
        assertEquals("result value", result);
        assertNotNull(result);
    }

    @Test(expected = IOException.class)
    public void IOError() throws Exception {

        OutputStream outputMock = mock(OutputStream.class);

        HttpsURLConnection connectionMock = mock(HttpsURLConnection.class);
        when(connectionMock.getOutputStream()).thenReturn(outputMock);
        when(connectionMock.getInputStream()).thenThrow(new IOException("test error"));

        String result = target.PostRequest("request value".getBytes(StandardCharsets.UTF_8), connectionMock);

        assertTrue(false); // should not get here.
    }
}