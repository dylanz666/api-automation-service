package cn.dylanz.autoservice.util.senior;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class HeaderUtil {
    public static Map<String, String> build3ScaleHeaders() {
        String apiKey = ConfigUtil.getConfig("apiKey");
        String password = ConfigUtil.getConfig("authPassword");
        Map<String, String> headers = new HashMap<>();
        headers.put("apiKey", apiKey);

        //String authorization = TokenService.getToken(apiKey, password);
        //headers.put("Authorization", "Bearer " + authorization);
        return headers;
    }

    public static Map<String, String> buildIFP3ScaleHeaders() {
        String apiKey = ConfigUtil.getConfig("ifpApiKey");
        Map<String, String> headers = new HashMap<>();
        headers.put("apiKey", apiKey);
        return headers;
    }
}
