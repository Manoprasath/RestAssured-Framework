package com.marusputin.listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.marusputin.annotations.TestDetails;
import com.marusputin.reports.ExtentLoggers;
import com.marusputin.reports.ExtentReport;
import org.testng.*;
import org.testng.internal.annotations.TestAnnotation;

import java.util.Arrays;

public class TestListeners implements ITestListener, ISuiteListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
        ExtentLoggers.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(TestDetails.class).author());
        ExtentLoggers.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(TestDetails.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLoggers.pass(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLoggers.fail(result.getMethod().getMethodName());
        ExtentLoggers.fail(result.getThrowable().getMessage());
        ExtentLoggers.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLoggers.skip(result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }
}
