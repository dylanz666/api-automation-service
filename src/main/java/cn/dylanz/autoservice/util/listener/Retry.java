package cn.dylanz.autoservice.util.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class Retry implements IRetryAnalyzer {
    private static int retryCount = 1;
    private static final int maxRetryCount = 3;

    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
            System.out.println("It's the " + retryCount + " time failed!");
            retryCount++;
            return true;
        }
        return false;
    }
}
