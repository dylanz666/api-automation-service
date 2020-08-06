package cn.dylanz.autoservice.util.base;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author : dylanz
 * @since : 08/05/2020
 * @version : copy from com.ehi.ehi-tomcat-extension jar
 **/
public class EncryptUtil {
    private static final String SECURE_KEY = "NzY1NDMyMTA=";
    public static final String CHARSET = "UTF-8";
    public static final String DEFAULT_ALGORITHM = "DES";
    public static final String DEFAULT_ALGORITHM_PARAMS = "CBC/PKCS5Padding";
    public static final byte[] DEFAULT_ALGORITHM_IV = "ehiwings".getBytes();

    public EncryptUtil() {
    }

    public static byte[] encrypt(byte[] insecure) {
        return symmetric(insecure, 1);
    }

    public static byte[] decrypt(byte[] secure) {
        return symmetric(secure, 2);
    }

    public static String encrypt(String insecure) {
        byte[] encrypted = encrypt(insecure.getBytes());

        try {
            return new String(base64Encoder(encrypted).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static String decrypt(String secure) {
        byte[] decrypted = decrypt(base64Decoder(secure));

        try {
            return new String(decrypted, "UTF-8");
        } catch (UnsupportedEncodingException var3) {
            throw new RuntimeException(var3);
        }
    }

    private static byte[] symmetric(byte[] data, int mode) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            SecretKeyFactory e = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = e.generateSecret(new DESKeySpec("NzY1NDMyMTA=".getBytes()));
            cipher.init(mode, secretKey, new IvParameterSpec(DEFAULT_ALGORITHM_IV));
            return cipher.doFinal(data);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public static String base64Encoder(byte[] src) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src);
    }

    public static byte[] base64Decoder(String dest) {
        BASE64Decoder decoder = new BASE64Decoder();

        try {
            return decoder.decodeBuffer(dest);
        } catch (IOException var3) {
            throw new RuntimeException(var3);
        }
    }
}