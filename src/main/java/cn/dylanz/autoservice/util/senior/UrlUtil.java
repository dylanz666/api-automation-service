package cn.dylanz.autoservice.util.senior;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
public class UrlUtil {
    private static String env = ConfigUtil.getEnv();

    public static String buildBov2Url(String apiPath) {
        String envText = "pr".equals(env) ? "" : env + ".";
        return "https://www." + envText + "teste.com" + apiPath;
    }

    public static String buildBov2Url(String apiPath, String env) {
        String envText = "pr".equals(env) ? "" : env + ".";
        return "https://www." + envText + "test.com" + apiPath;
    }

    public static String build3ScaleUrl(String apiPath) {
        String convertedEnv = EnvUtil.convertTr(env);
        String envText = "pr".equals(convertedEnv) ? "" : "-" + convertedEnv;
        return "https://api" + envText + ".test.com" + apiPath;
    }

    public static String buildBowsUrl(String apiPath) {
        String convertedEnv = EnvUtil.convertTr(env);
        return "https://sj" + convertedEnv + "bowc-app-vip:8443" + apiPath;
    }
}