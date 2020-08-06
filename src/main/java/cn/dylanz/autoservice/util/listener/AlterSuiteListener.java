package cn.dylanz.autoservice.util.listener;

import cn.dylanz.autoservice.util.base.FileUtil;
import cn.dylanz.autoservice.util.senior.ConfigUtil;
import org.testng.IAlterSuiteListener;
import org.testng.xml.*;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
public class AlterSuiteListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        File file = new File("src/test/java/com/ehi");
        File[] files = file.listFiles();
        String teamName = files == null ? "" : "." + files[0].getName();

        //delete test result files in allure-results folder
        FileUtil.deleteAllFiles("allure-results");

        XmlSuite suite = suites.get(0);
        XmlTest xmlTest = new XmlTest(suite);
        XmlClass xmlClass = new XmlClass();
        xmlTest.setName("Test");

        String groupTag = System.getProperty("tag");
        String suiteName = System.getProperty("suite");

        //We are not using parallel to run test cases on BO PROD
        //If you want to run in parallel on your PROD, please delete below 4 lines of code
        String env = ConfigUtil.getEnv();
        if (env.equals("pr")) {
            xmlTest.setThreadCount(1);
        }

        //run by group
        if (groupTag != null && !groupTag.equals("")) {
            //set groups
            if (!groupTag.toLowerCase().equals("all")) {
                XmlGroups xmlGroups = new XmlGroups();
                XmlRun xmlRun = new XmlRun();
                xmlRun.onInclude(groupTag);
                xmlGroups.setRun(xmlRun);
                xmlTest.setGroups(xmlGroups);
            }

            //run by package, this is for suite is ended with "*"
            if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all") && suiteName.endsWith(".*")) {
                XmlPackage xmlPackage = new XmlPackage("com.ehi" + teamName + ".testcases." + suiteName);
                xmlTest.setPackages(Collections.singletonList(xmlPackage));
                return;
            }

            //set class scope when both tag and suite have value
            if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all")) {
                suiteName = "com.ehi" + teamName + ".testcases." + suiteName;
                xmlClass.setName(suiteName);
                xmlTest.setClasses(Collections.singletonList(xmlClass));
                return;
            }

            //set package scope
            XmlPackage xmlPackage = new XmlPackage("com.ehi.*");
            xmlTest.setPackages(Collections.singletonList(xmlPackage));
            return;
        }

        //run by package, this is for suite is ended with "*"
        if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all") && suiteName.endsWith(".*")) {
            XmlPackage xmlPackage = new XmlPackage("com.ehi" + teamName + ".testcases." + suiteName);
            xmlTest.setPackages(Collections.singletonList(xmlPackage));
            return;
        }

        //run by classes, this is for groupTag is null or ""
        if (suiteName != null && !suiteName.equals("") && !suiteName.toLowerCase().equals("all")) {
            suiteName = "com.ehi" + teamName + ".testcases." + suiteName;
            xmlClass.setName(suiteName);
            xmlTest.setClasses(Collections.singletonList(xmlClass));
            return;
        }

        //default run by package
        XmlPackage xmlPackage = new XmlPackage("com.ehi" + teamName + ".testcases.*");
        xmlTest.setPackages(Collections.singletonList(xmlPackage));
    }
}