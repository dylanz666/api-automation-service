package com.github.dylanz666.util.senior;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.github.dylanz666.domain.Runtime;
import com.github.dylanz666.util.base.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class ConfigUtil {
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private Runtime runtime;

    public JSONObject getConfig() {
        try {
            String config = fileUtil.readConfigInfoFromFile(runtime.getEnv());
            return JSONObject.parseObject(config);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getConfig(String path) {
        try {
            String config = fileUtil.readConfigInfoFromFile(runtime.getEnv());
            return JSONPath.read(config, "$." + path).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}