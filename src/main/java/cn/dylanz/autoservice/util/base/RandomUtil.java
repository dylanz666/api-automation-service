package cn.dylanz.autoservice.util.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class RandomUtil {
    public static String getRandomString(int len) {
        return RandomStringUtils.randomAlphabetic(len);
    }

    public static String getRandomString() {
        return getRandomString(5);
    }

    public static String getRandomDigit(int len) {
        String number = RandomStringUtils.randomNumeric(len);
        if (len == 1) {
            return number;
        }
        if (number.startsWith("0") && number.length() > 1) {
            number = getRandomDigitInRange(1, 9) + number.substring(1, number.length());
            return number;
        }
        if (number.startsWith("0")) {
            return getRandomDigitInRange(1, 9) + "";
        }
        return number;
    }

    public static String getRandomDigit() {
        return getRandomDigit(5);
    }

    public static int getRandomDigitInRange(int start, int end) {
        try {
            if (start > end) {
                throw new Exception("Invalid range!");
            }
            return (int) (Math.random() * (end - start) + start);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getRandomMixString() {
        return getRandomMixString(5);
    }

    public static String getRandomMixString(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }

    public static String getRandomPhone() {
        return getRandomDigit(10);
    }

    public static JSONObject getRandomPhoneObject() {
        String area_code = getRandomDigit(3);
        String number = getRandomDigit(3) + "-" + getRandomDigit(4);
        String phone_number = area_code + " " + number;
        String phone = area_code + "" + number.replace("-", "");

        JSONObject phoneObject = new JSONObject();
        phoneObject.put("area_code", area_code);
        phoneObject.put("number", number);
        phoneObject.put("phone_number", phone_number);
        phoneObject.put("phone", phone);
        return phoneObject;
    }

    public static String getRandomEmailAddress() {
        return getRandomString() + getRandomPhone() + "@testqa.com";
    }

    public static JSONArray getRandomItem(ArrayList list, int count) {
        int listSize = list.size();
        if (listSize == 0) {
            System.out.println("Please input valid list!");
            return new JSONArray();
        }
        if (listSize < count) {
            System.out.println("Count is too huge!");
            return new JSONArray();
        }

        Random rand = new Random();
        Collections.shuffle(list, rand);
        return JSONArrayUtil.convertList(list.subList(0, count));
    }

    public static Object getRandomItem(ArrayList list) {
        List items = getRandomItem(list, 1);
        if (items != null && items.size() > 0) {
            return items.get(0);
        }
        return new JSONObject();
    }

    public static JSONArray getRandomItem(List list, int count) {
        int listSize = list.size();
        if (listSize == 0) {
            System.out.println("Please input valid list!");
            return new JSONArray();
        }
        if (listSize < count) {
            System.out.println("Count is too huge!");
            return new JSONArray();
        }

        Random rand = new Random();
        Collections.shuffle(list, rand);
        return JSONArrayUtil.convertList(list.subList(0, count));
    }

    public static Object getRandomItem(List list) {
        List items = getRandomItem(list, 1);
        if (items != null && items.size() > 0) {
            return items.get(0);
        }
        return new JSONObject();
    }
}