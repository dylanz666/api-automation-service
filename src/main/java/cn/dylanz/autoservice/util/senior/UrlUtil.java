package cn.dylanz.autoservice.util.senior;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
public class UrlUtil {
    @Autowired
    private ConfigUtil configUtil;

    public String buildBov2Url(String apiPath) {
        String env = configUtil.getEnv();
        String envText = "pr".equals(env) ? "" : env + ".";
        return "https://www." + envText + "teste.com" + apiPath;
    }

    public static String buildBov2Url(String apiPath, String env) {
        String envText = "pr".equals(env) ? "" : env + ".";
        return "https://www." + envText + "test.com" + apiPath;
    }

    public String build3ScaleUrl(String apiPath) {
        String env = configUtil.getEnv();
        String convertedEnv = EnvUtil.convertTr(env);
        String envText = "pr".equals(convertedEnv) ? "" : "-" + convertedEnv;
        return "https://api" + envText + ".test.com" + apiPath;
    }

    public String buildBowsUrl(String apiPath) {
        String env = configUtil.getEnv();
        String convertedEnv = EnvUtil.convertTr(env);
        return "https://sj" + convertedEnv + "bowc-app-vip:8443" + apiPath;
    }
}