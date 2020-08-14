package com.github.dylanz666.util.senior;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class EnvUtil {
    public static String convertAll(String envText) {
        String convertedEnv = envText.toLowerCase();
        convertedEnv = convertedEnv.equals("ts") ? "qp" : convertedEnv;
        convertedEnv = convertedEnv.equals("qa") ? "qp" : convertedEnv;
        convertedEnv = convertedEnv.equals("tr") ? "cm" : convertedEnv;
        return convertedEnv;
    }

    public static String convertTr(String envText) {
        String convertedEnv = envText.toLowerCase();
        return convertedEnv.equals("tr") ? "cm" : convertedEnv;
    }
}