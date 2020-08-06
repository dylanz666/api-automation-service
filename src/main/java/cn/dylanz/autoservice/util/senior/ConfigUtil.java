package cn.dylanz.autoservice.util.senior;

import cn.dylanz.autoservice.util.base.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class ConfigUtil {
    private static String env = "";

    public static void setEnv() {
        env = (null != System.getProperty("env")) ? System.getProperty("env").toLowerCase() : "cm";
    }

    public static String getEnv() {
        setEnv();
        return env;
    }

    public static JSONObject getConfig() {
        try {
            String config = FileUtil.readConfigInfoFromFile(getEnv());
            return JSONObject.parseObject(config);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getConfig(String path) {
        try {
            String config = FileUtil.readConfigInfoFromFile(getEnv());
            return JSONPath.read(config, "$." + path).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class Constant {
        public static final String getDbConnectionUrl = "https://10.9.77.61:14444/api/connections";
        public static final String queryDbUrl = "https://10.9.77.61:14444/api/query-result";
        public static final String getSecurityCodeUrl = "http://sjtsmozilla01:8084/api/getSecurityCode";
        public static final String awsIvrOrigin = "http://10.9.76.178:8080/ivr-aws-lambda-connect";
        public static final int boseOverrideCode = "pr".equals(getEnv()) ? 953157 : 24571;
        public static final int ehiOrganizationId = 45;
        public static final int boseDefaultZipCode = 90001;
        public static final String boseDefaultAlliancePhone = "8882960117";
        public static final String boseDefaultInboundNumber = "888-296-0117";
    }
}