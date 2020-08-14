package com.github.dylanz666.util.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class JSONObjectUtil {
    public static String getValue(String json, String path) {
        try {
            if (null == json) {
                throw new Exception("Null provided json!");
            }
            if (null == path) {
                throw new Exception("Invalid json path!");
            }
            Object value = JSONPath.read(json, "$." + path);
            return (value == null ? null : value.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getValue(Response response, String path) {
        try {
            String json = response.asString();
            if (null == json) {
                throw new Exception("Null provided json!");
            }
            if (null == path) {
                throw new Exception("Invalid json path!");
            }
            if ("*".equals(path)) {
                return JSONPath.read(json, "$").toString();
            }
            Object value = JSONPath.read(json, "$." + path);
            return (value == null ? null : value.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getValueObject(Response response, String path) {
        return getValueObject(response.asString(), path);
    }

    public static JSONObject getValueObject(String json, String path) {
        try {
            if (null == json) {
                throw new Exception("Null provided json!");
            }
            if (null == path) {
                throw new Exception("Invalid json path!");
            }
            if ("*".equals(path)) {
                return (JSONObject) JSONPath.read(json, "$");
            }
            return (JSONObject) JSONPath.read(json, "$." + path);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray getJsonArray(Response response, String path) {
        try {
            String json = response.asString();
            if (null == json) {
                throw new Exception("Null provided json!");
            }
            if (null == path) {
                throw new Exception("Invalid json path!");
            }
            if ("*".equals(path)) {
                return (JSONArray) JSONPath.read(json, "$");
            }
            return (JSONArray) JSONPath.read(json, "$." + path);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray getJsonArray(Response response) {
        return getJsonArray(response, "*");
    }

    public static JSONArray getJsonArray(Object obj, String path) {
        try {
            String json = obj.toString();
            if (null == json) {
                throw new Exception("Null provided json!");
            }
            if (null == path) {
                throw new Exception("Invalid json path!");
            }
            if ("*".equals(path)) {
                return (JSONArray) JSONPath.read(json, "$");
            }
            return (JSONArray) JSONPath.read(json, "$." + path);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray getJsonArray(Object obj) {
        return getJsonArray(obj, "*");
    }
}