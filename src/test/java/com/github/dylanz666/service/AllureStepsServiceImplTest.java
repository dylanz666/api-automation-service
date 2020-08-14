package com.github.dylanz666.service;

import com.github.dylanz666.constant.RequestMethodEnum;
import com.github.dylanz666.domain.AllureAttachment;
import com.github.dylanz666.domain.AllureSteps;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

/**
 * @author : dylanz
 * @since : 08/06/2020
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AllureStepsServiceImplTest {
    @Autowired
    private AllureSteps allureSteps;
    @Autowired
    private AllureStepsServiceImpl allureStepsService;

    @Test
    public void testAddSteps_valid() {
        List<AllureAttachment> info = new ArrayList<>();

        AllureAttachment allureAttachment = new AllureAttachment();
        allureAttachment.setName("1");
        allureAttachment.setContent("test 1");
        info.add(allureAttachment);

        allureAttachment = new AllureAttachment();
        allureAttachment.setName("2");
        allureAttachment.setContent("test 2");
        info.add(allureAttachment);

        allureAttachment = new AllureAttachment();
        allureAttachment.setName("3");
        allureAttachment.setContent("test 3");
        info.add(allureAttachment);

        String url = "https://www.baidu.com/";
        RequestMethodEnum method = RequestMethodEnum.GET;
        String requestBody = "{}";
        allureSteps.setInfo(info);
        allureSteps.setUrl(url);
        allureSteps.setMethod(method);
        allureSteps.setRequestBody(requestBody);

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "en-US,en;q=0.9");
        headers.put("Connection", "keep-alive");
        RestAssuredConfig config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()).connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponseAfter(10, TimeUnit.MINUTES));
        Response response = given()
                .config(config)
                .headers(headers)
                .when()
                .body(requestBody)
                .get(url)
                .then()
                .extract()
                .response();
        allureSteps.setResponse(response);

        Boolean result = allureStepsService.addSteps(allureSteps);

        Assert.assertTrue(result);
    }

    @Test
    public void testAddSteps_nullIfo() {
        List<AllureAttachment> info = new ArrayList<>();

        String url = "https://www.baidu.com/";
        RequestMethodEnum method = RequestMethodEnum.GET;
        String requestBody = "{}";
        allureSteps.setInfo(info);
        allureSteps.setUrl(url);
        allureSteps.setMethod(method);
        allureSteps.setRequestBody(requestBody);

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("Accept-Encoding", "gzip, deflate, br");
        headers.put("Accept-Language", "en-US,en;q=0.9");
        headers.put("Connection", "keep-alive");
        RestAssuredConfig config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()).connectionConfig(new ConnectionConfig().closeIdleConnectionsAfterEachResponseAfter(10, TimeUnit.MINUTES));
        Response response = given()
                .config(config)
                .headers(headers)
                .when()
                .body(requestBody)
                .get(url)
                .then()
                .extract()
                .response();
        allureSteps.setResponse(response);

        Boolean result = allureStepsService.addSteps(allureSteps);

        Assert.assertTrue(result);
    }

    @Test
    public void testAddSteps_invalid() {
        Boolean result = allureStepsService.addSteps(null);

        Assert.assertFalse(result);
    }
}
