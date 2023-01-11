package com.marusputin.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.marusputin.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class contains methods to initialize, log and flush reports
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReports() {
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.EXTENT_REPORT_FOLDER_PATH + "index.html");
        extent.attachReporter(sparkReporter);
    }

    public static void createTest(String methodName) {
        test = extent.createTest(methodName);
        ExtentManager.setExtentTest(test);
    }

    public static void flushReports() {
        extent.flush();
        ExtentManager.unload();
    }
}
