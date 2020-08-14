package com.github.dylanz666.util.senior;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class HeaderUtil {
    @Autowired
    private ConfigUtil configUtil;

    public Map<String, String> build3ScaleHeaders() {
        String apiKey = configUtil.getConfig("apiKey");
        String password = configUtil.getConfig("authPassword");
        Map<String, String> headers = new HashMap<>();
        headers.put("apiKey", apiKey);

        //String authorization = TokenService.getToken(apiKey, password);
        //headers.put("Authorization", "Bearer " + authorization);
        return headers;
    }

    public Map<String, String> buildIFP3ScaleHeaders() {
        String apiKey = configUtil.getConfig("ifpApiKey");
        Map<String, String> headers = new HashMap<>();
        headers.put("apiKey", apiKey);
        return headers;
    }
}
