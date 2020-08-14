package com.github.dylanz666.util.senior;

import com.github.dylanz666.util.base.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
public class RequestBodyUtil {
    @Autowired
    private ConfigUtil configUtil;
    @Autowired
    private FileUtil fileUtil;

    public String getBody(String bodyName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        Object bodyObject = getBodyObject(bodyName, stackTrace);
        return (bodyObject != null) ? bodyObject.toString() : null;
    }

    public JSONObject getBodyObject(String bodyName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        return (JSONObject) getBodyObject(bodyName, stackTrace);
    }

    private Object getBodyObject(String bodyName, StackTraceElement stackTrace) {
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
            if (null == bodyName) {
                throw new Exception("Null body name!");
            }
            String bodyString = fileUtil.readRequestBodyFromFile(configUtil.getEnv(), filePath);
            return JSONPath.read(bodyString, "$." + bodyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getBodyWithFilePath(String filePath, String bodyName) {
        Object bodyObject = getBodyObjectWithPath(filePath, bodyName);
        return (bodyObject != null) ? bodyObject.toString() : null;
    }

    public JSONObject getBodyObjectWithFilePath(String filePath, String bodyName) {
        return (JSONObject) getBodyObjectWithPath(filePath, bodyName);
    }

    private Object getBodyObjectWithPath(String filePath, String bodyName) {
        try {
            if (null == filePath) {
                throw new Exception("Null file path!");
            }
            if (null == bodyName) {
                throw new Exception("Null body name!");
            }
            if (filePath.endsWith(".json")) {
                filePath = filePath.substring(0, filePath.length() - 5);
            }

            filePath = filePath.replaceAll("\\.", "/");
            String bodyString = fileUtil.readRequestBodyFromFile(configUtil.getEnv(), filePath);
            return JSONPath.read(bodyString, "$." + bodyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getXmlBody(String fileName) {
        try {
            StackTraceElement stackTrace = new Exception().getStackTrace()[1];
            String sourceFileName = stackTrace.getFileName();
            String className = stackTrace.getClassName();
            String subClassName = className.substring(className.indexOf("testcases") + 10, className.length());
            String filePath = subClassName.replaceAll("\\.", "/");

            if (null == sourceFileName) {
                throw new Exception("Null source file name!");
            }
            if (null == fileName) {
                throw new Exception("Null file name!");
            }
            if (fileName.endsWith(".xml")) {
                fileName = fileName.substring(0, fileName.length() - 4);
            }

            filePath += "/" + fileName;
            return fileUtil.readXmlBodyFromFile(configUtil.getEnv(), filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}