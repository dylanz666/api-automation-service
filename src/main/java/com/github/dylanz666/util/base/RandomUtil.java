package com.github.dylanz666.util.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Random;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class RandomUtil {
    public String getRandomString(int len) {
        return RandomStringUtils.randomAlphabetic(len);
    }

    public String getRandomString() {
        return getRandomString(5);
    }

    public String getRandomDigit(int len) {
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

    public String getRandomDigit() {
        return getRandomDigit(5);
    }

    public int getRandomDigitInRange(int start, int end) {
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

    public String getRandomMixString() {
        return getRandomMixString(5);
    }

    public String getRandomMixString(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }

    public String getRandomPhone() {
        return getRandomDigit(10);
    }

    public JSONObject getRandomPhoneObject() {
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

    public String getRandomEmailAddress() {
        return getRandomString() + getRandomPhone() + "@testqa.com";
    }

    public JSONArray getRandomItem(JSONArray jsonArray, int count) {
        int arraySize = jsonArray.size();
        if (arraySize == 0) {
            System.out.println("Please input valid JSONArray!");
            return new JSONArray();
        }
        if (arraySize < count) {
            System.out.println("Count is too huge!");
            return new JSONArray();
        }

        Random rand = new Random();
        Collections.shuffle(jsonArray, rand);
        return JSONArrayUtil.convertList(jsonArray.subList(0, count));
    }

    public Object getRandomItem(JSONArray jsonArray) {
        JSONArray items = getRandomItem(jsonArray, 1);
        if (items != null && items.size() > 0) {
            return items.get(0);
        }
        return new JSONObject();
    }
}