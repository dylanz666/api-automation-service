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
    @Autowired
    private FileUtil fileUtil;

    private String env;

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
}