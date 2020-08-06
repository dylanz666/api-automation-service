package cn.dylanz.autoservice.util.base;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class Base64Util {
    public static String encode(String text) {
        byte[] textByte = text.getBytes(StandardCharsets.UTF_8);

        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(textByte);
    }

    public static String decode(String text) {
        return new String(Base64.getDecoder().decode(text));
    }
}
