package cn.dylanz.autoservice.util.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : dylanz
 * @since : 08/10/2020
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomUtilTest {
    @Autowired
    private RandomUtil randomUtil;

    @Test
    public void testGetRandomString_defaultLength() {
        String randomString = randomUtil.getRandomString();

        Assert.assertEquals(5, randomString.length());
    }

    @Test
    public void testGetRandomString_notDefaultLength() {
        int length = 10;
        String randomString = randomUtil.getRandomString(length);

        Assert.assertEquals(length, randomString.length());
    }

    @Test
    public void testGetRandomDigit_defaultLength() {
        String randomDigit = randomUtil.getRandomDigit();

        Assert.assertEquals(5, randomDigit.length());
    }

    @Test
    public void testGetRandomDigit_notDefaultLength() {
        int length = 10;
        String randomDigit = randomUtil.getRandomDigit(length);

        Assert.assertEquals(length, randomDigit.length());
    }

    @Test
    public void testGetRandomDigitInRange() {
        int start = 5;
        int end = 20;
        int randomDigit = randomUtil.getRandomDigitInRange(5, 20);

        Assert.assertTrue(randomDigit >= start);
        Assert.assertTrue(randomDigit <= end);
    }

    @Test
    public void testGetRandomMixString_defaultLength() {
        String randomString = randomUtil.getRandomMixString();

        Assert.assertEquals(5, randomString.length());
    }

    @Test
    public void testGetRandomMixString_notDefaultLength() {
        int length = 10;
        String randomString = randomUtil.getRandomMixString(length);

        Assert.assertEquals(length, randomString.length());
    }

    @Test
    public void testGetRandomPhone() {
        String phone = randomUtil.getRandomPhone();

        Assert.assertEquals(10, phone.length());
    }

    @Test
    public void testGetRandomPhoneObject() {
        JSONObject phoneObject = randomUtil.getRandomPhoneObject();
        String areaCode = phoneObject.getString("area_code");
        String number = phoneObject.getString("number");
        String phoneNumber = phoneObject.getString("phone_number");
        String phone = phoneObject.getString("phone");

        Assert.assertEquals(3, areaCode.length());
        Assert.assertEquals(8, number.length());
        Assert.assertTrue(number.contains("-"));
        Assert.assertEquals(12, phoneNumber.length());
        Assert.assertTrue(phoneNumber.contains(" "));
        Assert.assertTrue(phoneNumber.contains("-"));
        Assert.assertEquals(10, phone.length());
    }

    @Test
    public void testGetRandomEmailAddress() {
        String emailEnding = "@testqa.com";
        String emailAddress = randomUtil.getRandomEmailAddress();

        Assert.assertTrue(emailAddress.endsWith(emailEnding));
        Assert.assertEquals(15 + emailEnding.length(), emailAddress.length());
    }

    @Test
    public void testGetRandomItem_singleString() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("test1");
        jsonArray.add("test2");
        jsonArray.add("test3");
        jsonArray.add("test4");
        jsonArray.add("test5");

        String item = randomUtil.getRandomItem(jsonArray).toString();

        Assert.assertTrue(jsonArray.contains(item));
    }

    @Test
    public void testGetRandomItem_nullJSONArray() {
        JSONArray jsonArray = new JSONArray();

        JSONObject item = (JSONObject) randomUtil.getRandomItem(jsonArray);

        Assert.assertTrue(item.isEmpty());
    }

    @Test
    public void testGetRandomItem_multipleStrings() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("test1");
        jsonArray.add("test2");
        jsonArray.add("test3");
        jsonArray.add("test4");
        jsonArray.add("test5");

        JSONArray items = randomUtil.getRandomItem(jsonArray, 3);

        Assert.assertTrue(jsonArray.containsAll(items));
    }

    @Test
    public void testGetRandomItem_singleObject() {
        JSONArray jsonArray = new JSONArray();
        JSONObject item1 = new JSONObject();
        item1.put("name", "1");
        item1.put("value", "test1");
        jsonArray.add(item1);
        JSONObject item2 = new JSONObject();
        item2.put("name", "2");
        item2.put("value", "test2");
        jsonArray.add(item2);
        JSONObject item3 = new JSONObject();
        item3.put("name", "3");
        item3.put("value", "test3");
        jsonArray.add(item3);
        JSONObject item4 = new JSONObject();
        item4.put("name", "4");
        item4.put("value", "test4");
        jsonArray.add(item4);
        JSONObject item5 = new JSONObject();
        item5.put("name", "5");
        item5.put("value", "test5");
        jsonArray.add(item5);

        JSONObject item = (JSONObject) randomUtil.getRandomItem(jsonArray);

        Assert.assertTrue(jsonArray.contains(item));
    }

    @Test
    public void testGetRandomItem_multipleObjects() {
        JSONArray jsonArray = new JSONArray();
        JSONObject item1 = new JSONObject();
        item1.put("name", "1");
        item1.put("value", "test1");
        jsonArray.add(item1);
        JSONObject item2 = new JSONObject();
        item2.put("name", "2");
        item2.put("value", "test2");
        jsonArray.add(item2);
        JSONObject item3 = new JSONObject();
        item3.put("name", "3");
        item3.put("value", "test3");
        jsonArray.add(item3);
        JSONObject item4 = new JSONObject();
        item4.put("name", "4");
        item4.put("value", "test4");
        jsonArray.add(item4);
        JSONObject item5 = new JSONObject();
        item5.put("name", "5");
        item5.put("value", "test5");
        jsonArray.add(item5);

        JSONArray item = randomUtil.getRandomItem(jsonArray, 3);

        Assert.assertTrue(jsonArray.containsAll(item));
    }

    @Test
    public void testGetRandomItem_nullObjects() {
        JSONArray jsonArray = new JSONArray();

        JSONArray item = randomUtil.getRandomItem(jsonArray, 3);

        Assert.assertTrue(item.isEmpty());
    }

    @Test
    public void testGetRandomItem_tooHugeCount() {
        JSONArray jsonArray = new JSONArray();
        JSONObject item1 = new JSONObject();
        item1.put("name", "1");
        item1.put("value", "test1");
        jsonArray.add(item1);
        JSONObject item2 = new JSONObject();
        item2.put("name", "2");
        item2.put("value", "test2");
        jsonArray.add(item2);
        JSONObject item3 = new JSONObject();
        item3.put("name", "3");
        item3.put("value", "test3");
        jsonArray.add(item3);
        JSONObject item4 = new JSONObject();
        item4.put("name", "4");
        item4.put("value", "test4");
        jsonArray.add(item4);
        JSONObject item5 = new JSONObject();
        item5.put("name", "5");
        item5.put("value", "test5");
        jsonArray.add(item5);

        JSONArray item = randomUtil.getRandomItem(jsonArray, jsonArray.size() + 1);

        Assert.assertTrue(item.isEmpty());
    }
}
