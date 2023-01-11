package com.marusputin.reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentLoggers {

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.TEAL));
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(MarkupHelper.createLabel(message, ExtentColor.ORANGE));
    }

    public static void info(String message) {
        ExtentManager.getExtentTest().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
    }

    public static void log(String message) {
        ExtentManager.getExtentTest().log(Status.PASS, MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }

    public static void logRequest(RequestSpecification requestSpecification) {
        QueryableRequestSpecification specification = SpecificationQuerier.query(requestSpecification);
        info("Request details below");
        ExtentManager.getExtentTest().log(Status.PASS, MarkupHelper.createCodeBlock(specification.getBody(), CodeLanguage.JSON));
    }

    public static void assignAuthor(String... author) {
        ExtentManager.getExtentTest().assignAuthor(author);
    }

    public static void assignCategory(String... category) {
        ExtentManager.getExtentTest().assignCategory(category);
    }
}
