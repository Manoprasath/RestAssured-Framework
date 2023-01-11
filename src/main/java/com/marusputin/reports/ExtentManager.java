package com.marusputin.reports;

import com.aventstack.extentreports.ExtentTest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class will maintain the execution thread while executing the tests in parallel
 * Basically this is for thread safe
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentManager {
    private static final ThreadLocal<ExtentTest> DELEGATE = new ThreadLocal<>();

    public static void setExtentTest(ExtentTest extentTest) {
        DELEGATE.set(extentTest);
    }

    public static ExtentTest getExtentTest() {
        return DELEGATE.get();
    }

    public static void unload() {
        DELEGATE.remove();
    }

}
