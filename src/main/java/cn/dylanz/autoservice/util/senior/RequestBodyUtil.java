package cn.dylanz.autoservice.util.senior;

import cn.dylanz.autoservice.util.base.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

/**
 * @author : dylanz
 * @since : 06/12/2020
 **/
public class RequestBodyUtil {
    private static String env = ConfigUtil.getEnv();

    public static String getBody(String bodyName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        Object bodyObject = getBodyObject(bodyName, stackTrace);
        return (bodyObject != null) ? bodyObject.toString() : null;
    }

    public static JSONObject getBodyObject(String bodyName) {
        StackTraceElement stackTrace = new Exception().getStackTrace()[1];
        return (JSONObject) getBodyObject(bodyName, stackTrace);
    }

    private static Object getBodyObject(String bodyName, StackTraceElement stackTrace) {
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
            String bodyString = FileUtil.readRequestBodyFromFile(env, filePath);
            return JSONPath.read(bodyString, "$." + bodyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getBodyWithFilePath(String filePath, String bodyName) {
        Object bodyObject = getBodyObjectWithPath(filePath, bodyName);
        return (bodyObject != null) ? bodyObject.toString() : null;
    }

    public static JSONObject getBodyObjectWithFilePath(String filePath, String bodyName) {
        return (JSONObject) getBodyObjectWithPath(filePath, bodyName);
    }

    private static Object getBodyObjectWithPath(String filePath, String bodyName) {
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
            String bodyString = FileUtil.readRequestBodyFromFile(env, filePath);
            return JSONPath.read(bodyString, "$." + bodyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getXmlBody(String fileName) {
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
            return FileUtil.readXmlBodyFromFile(env, filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}