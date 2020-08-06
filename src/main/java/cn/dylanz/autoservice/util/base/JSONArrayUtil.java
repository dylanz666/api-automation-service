package cn.dylanz.autoservice.util.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class JSONArrayUtil {
    public static String join(String charSequence, JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (Object item : jsonArray) {
            list.add(item.toString());
        }
        return String.join(charSequence, list);
    }

    public static JSONArray unique(JSONArray jsonArray) {
        JSONArray newArray = new JSONArray();
        List<String> list = new ArrayList<>();
        for (Object jsonItem : jsonArray) {
            list.add(jsonItem.toString());
        }
        list.stream().distinct().forEach((item) -> newArray.add(JSONObject.parse(item)));
        return newArray;
    }

    public static JSONArray sort(JSONArray jsonArray) {
        List list = jsonArray.subList(0, jsonArray.size());
        Collections.sort(list);
        return convertList(list);
    }

    public static JSONArray filterKey(String arrayString, String keyPath) {
        JSONArray jsonArray = JSONArray.parseArray(arrayString);
        return filterKey(jsonArray, keyPath, false);
    }

    public static JSONArray filterKey(String arrayString, String keyPath, Boolean onlyOutputValue) {
        JSONArray jsonArray = JSONArray.parseArray(arrayString);
        return filterKey(jsonArray, keyPath, onlyOutputValue);
    }

    public static JSONArray filterKey(JSONArray jsonArray, String keyPath) {
        return filterKey(jsonArray, keyPath, false);
    }

    public static JSONArray filterKey(JSONArray jsonArray, String keyPath, Boolean onlyOutputValue) {
        try {
            if (jsonArray.size() == 0) {
                throw new Exception("Invalid JSONArray!");
            }
            if (keyPath.equals("")) {
                throw new Exception("Key path cannot be null!");
            }
            JSONArray newArray = new JSONArray();
            for (Object itemObject : jsonArray) {
                JSONObject item = (JSONObject) itemObject;
                Object valueObj = JSONPath.read(item.toString(), "$." + keyPath);
                if (valueObj != null && onlyOutputValue) {
                    newArray.add(valueObj.toString());
                    continue;
                }
                if (valueObj != null) {
                    newArray.add(item);
                }
            }
            return newArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray filterKeyValue(String arrayString, String keyPath, String value) {
        JSONArray jsonArray = JSONArray.parseArray(arrayString);
        return filterKeyValue(jsonArray, keyPath, value);
    }

    public static JSONArray filterKeyValue(JSONArray jsonArray, String keyPath, String value) {
        try {
            if (jsonArray.size() == 0) {
                throw new Exception("Invalid JSONArray!");
            }
            if (keyPath.equals("")) {
                throw new Exception("Key path cannot be null!");
            }
            JSONArray newArray = new JSONArray();
            for (Object itemObject : jsonArray) {
                JSONObject item = (JSONObject) itemObject;
                Object valueObj = JSONPath.read(item.toString(), "$." + keyPath);
                if (valueObj != null && valueObj.toString().equals(value)) {
                    newArray.add(item);
                }
            }
            return newArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray removeKey(JSONArray jsonArray, String key) {
        try {
            if (jsonArray.size() == 0) {
                throw new Exception("Invalid JSONArray!");
            }
            if (key.equals("")) {
                throw new Exception("Key cannot be null!");
            }
            JSONArray newJsonArray = new JSONArray();
            for (Object itemObj : jsonArray) {
                JSONObject item = (JSONObject) itemObj;
                if (item.containsKey(key)) {
                    item.remove(key);
                }
                newJsonArray.add(item);
            }
            return newJsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray convertList(List list) {
        try {
            if (list.size() == 0) {
                return new JSONArray();
            }
            JSONArray jsonArray = new JSONArray();
            for (Object item : list) {
                jsonArray.add(item);
            }
            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public static JSONArray mapToKeyValues(JSONArray jsonArray, String... keys) {
        if (jsonArray == null || jsonArray.size() == 0) {
            return jsonArray;
        }
        JSONArray newJsonArray = new JSONArray();
        for (Object itemObject : jsonArray) {
            try {
                JSONObject item = (JSONObject) itemObject;
                JSONObject newItem = new JSONObject();
                if (item.entrySet().size() > 1) {
                    continue;
                }
                for (Map.Entry<String, Object> entry : item.entrySet()) {
                    for (String key : keys) {
                        newItem.put(key, entry.getValue().toString());
                    }
                }
                newJsonArray.add(newItem);
            } catch (Exception e) {
                String item = itemObject.toString();
                JSONObject newItem = new JSONObject();
                for (String key : keys) {
                    newItem.put(key, item);
                }
                newJsonArray.add(newItem);
            }
        }
        return newJsonArray;
    }
}