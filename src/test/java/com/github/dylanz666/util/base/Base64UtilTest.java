package com.github.dylanz666.util.base;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : dylanz
 * @since : 08/06/2020
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Base64UtilTest {
    @Autowired
    private Base64Util base64Util;

    private String realText = "base 64 test";
    private String base64Text = "YmFzZSA2NCB0ZXN0";

    @Test
    public void testEncodeText_valid() {
        String encoded = base64Util.encode(realText);

        Assert.assertEquals(base64Text, encoded);
    }

    @Test
    public void testEncodeText_nullInput() {
        String encoded = base64Util.encode("");

        Assert.assertTrue(encoded.isEmpty());
    }

    @Test
    public void testDecodeText_valid() {
        String decoded = base64Util.decode(base64Text);

        Assert.assertEquals(realText, decoded);
    }

    @Test
    public void testDecodeText_nullInput() {
        String decoded = base64Util.decode("");

        Assert.assertTrue(decoded.isEmpty());
    }
}
