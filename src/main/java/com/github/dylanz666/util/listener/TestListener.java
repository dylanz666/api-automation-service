package com.github.dylanz666.util.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class TestListener implements ITestListener {
    public TestListener() {
        System.out.println("Initialize in TestListener...");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart...");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess...");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure...");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped...");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage...");
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart...");
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish...");
    }
}