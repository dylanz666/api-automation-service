package com.github.dylanz666.util.senior;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.github.dylanz666.domain.Runtime;
import com.github.dylanz666.util.base.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
@Service
public class TestDataUtil {
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private Runtime runtime;

    public String getData(String dataName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        Object dataObject = getDataObject(dataName, stackTrace);
        return (dataObject != null) ? dataObject.toString() : null;
    }

    public JSONObject getDataObject(String dataName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        return (JSONObject) getDataObject(dataName, stackTrace);
    }

    public JSONArray getDataArray(String dataName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        return (JSONArray) getDataObject(dataName, stackTrace);
    }

    private Object getDataObject(String dataName, StackTraceElement stackTrace) {
        try {
            if (stackTrace == null) {
                stackTrace = new Exception().getStackTrace()[1];
            }
            String sourceFileName = stackTrace.getFileName();
            String className = stackTrace.getClassName();
            if (className.contains("$")) {//this is used for 1 java class have it's java classes
                className = className.substring(0, className.indexOf("$"));
            }
            String subClassName = className.substring(className.indexOf("testcases") + 10, className.length());
            String filePath = subClassName.replaceAll("\\.", "/");

            if (null == sourceFileName) {
                throw new Exception("Null source file name!");
            }
            if (null == dataName) {
                throw new Exception("Null data name!");
            }

            String bodyString = fileUtil.readTestDataFromFile(runtime.getEnv(), filePath);
            return JSONPath.read(bodyString, "$." + dataName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}