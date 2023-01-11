/*
package com.marusputin.tests;

import com.marusputin.reports.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        ExtentReport.initReports();
    }

    @BeforeMethod
    public void beforeTest(Method method) {
        ExtentReport.createTest(method.getName());
    }

    @AfterMethod
    public void afterTest() {

    }

    @AfterSuite
    public void tearDown() {
        ExtentReport.flushReports();
    }
}
*/
