package cn.dylanz.autoservice.util.listener;

import cn.dylanz.autoservice.util.annotation.Skip;
import cn.dylanz.autoservice.util.base.DateUtil;
import cn.dylanz.autoservice.util.senior.ConfigUtil;
import org.joda.time.DateTime;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class SkipAnnotationListener implements IAnnotationTransformer {
    private static String env = ConfigUtil.getEnv();
    private static ITestAnnotation testAnnotation;

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class testClass, Constructor testConstructor,
                          Method testMethod) {
        testAnnotation = iTestAnnotation;
        if (!iTestAnnotation.getEnabled()) {
            return;
        }
        Skip annotation = testMethod.getAnnotation(Skip.class);
        if (annotation == null) {
            setRetryListener();
            return;
        }
        String beforeDate = annotation.before();
        String whenDate = annotation.when();
        String afterDate = annotation.after();
        DateTime today = new DateTime();
        DateTime todayStartDateTime = new DateTime(today.getYear(), today.getMonthOfYear(), today.getDayOfMonth(), 0, 0, 0);
        //skip when no conditions
        if (annotation.env().length == 0 && beforeDate.equals("") && whenDate.equals("") && afterDate.equals("")) {
            iTestAnnotation.setEnabled(false);
            return;
        }
        //skip for date
        if (annotation.env().length == 0) {
            if (!beforeDate.equals("")) {
                DateTime beforeDateTime = new DateTime(beforeDate);
                int days = DateUtil.getDaysBetween(todayStartDateTime, beforeDateTime);
                iTestAnnotation.setEnabled(days < 0);
            }
            if (!whenDate.equals("")) {
                DateTime whenDateTime = new DateTime(whenDate);
                int days = DateUtil.getDaysBetween(todayStartDateTime, whenDateTime);
                iTestAnnotation.setEnabled(days != 0);
            }
            if (!afterDate.equals("")) {
                DateTime afterDateTime = new DateTime(afterDate);
                int days = DateUtil.getDaysBetween(todayStartDateTime, afterDateTime);
                iTestAnnotation.setEnabled(days > 0);
            }

            setRetryListener();
            return;
        }

        //skip for env and date
        for (String skipEnv : annotation.env()) {
            if (skipEnv != null && !env.equals(skipEnv)) {
                iTestAnnotation.setEnabled(true);

                setRetryListener();
                continue;
            }

            if (env.equals(skipEnv)) {
                if (!beforeDate.equals("")) {
                    DateTime beforeDateTime = new DateTime(beforeDate);
                    int days = DateUtil.getDaysBetween(todayStartDateTime, beforeDateTime);
                    iTestAnnotation.setEnabled(days < 0);

                    setRetryListener();
                    break;
                }
                if (!whenDate.equals("")) {
                    DateTime whenDateTime = new DateTime(whenDate);
                    int days = DateUtil.getDaysBetween(todayStartDateTime, whenDateTime);
                    iTestAnnotation.setEnabled(days != 0);

                    setRetryListener();
                    break;
                }
                if (!afterDate.equals("")) {
                    DateTime afterDateTime = new DateTime(afterDate);
                    int days = DateUtil.getDaysBetween(todayStartDateTime, afterDateTime);
                    iTestAnnotation.setEnabled(days > 0);

                    setRetryListener();
                    break;
                }
                iTestAnnotation.setEnabled(false);
                break;
            }
        }
    }

    private static void setRetryListener() {
        if (testAnnotation.getEnabled()) {
            IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
            if (retry == null) {
                testAnnotation.setRetryAnalyzer(Retry.class);
            }
        }
    }
}