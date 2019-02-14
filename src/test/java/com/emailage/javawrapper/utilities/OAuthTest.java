package com.emailage.javawrapper.utilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.crypto.Mac;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Mac.class)
public class OAuthTest {

    @Test
    public void hmacEncrypt() {
    }
}