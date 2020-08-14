package com.github.dylanz666.util.senior;

import com.github.dylanz666.util.base.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class ConfigUtil {
    private static String env = "";

    @Autowired
    private FileUtil fileUtil;

    public void setEnv() {
        env = (null != System.getProperty("env")) ? System.getProperty("env").toLowerCase() : "cm";
    }

    public String getEnv() {
        setEnv();
        return env;
    }

    public JSONObject getConfig() {
        try {
            String config = fileUtil.readConfigInfoFromFile(getEnv());
            return JSONObject.parseObject(config);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getConfig(String path) {
        try {
            String config = fileUtil.readConfigInfoFromFile(getEnv());
            return JSONPath.read(config, "$." + path).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public class Constant {
        public final String getDbConnectionUrl = "https://10.9.77.61:14444/api/connections";
        public final String queryDbUrl = "https://10.9.77.61:14444/api/query-result";
        public final String getSecurityCodeUrl = "http://sjtsmozilla01:8084/api/getSecurityCode";
        public final String awsIvrOrigin = "http://10.9.76.178:8080/ivr-aws-lambda-connect";
        public final int boseOverrideCode = "pr".equals(getEnv()) ? 953157 : 24571;
        public final int ehiOrganizationId = 45;
        public final int boseDefaultZipCode = 90001;
        public final String boseDefaultAlliancePhone = "8882960117";
        public final String boseDefaultInboundNumber = "888-296-0117";
    }
}