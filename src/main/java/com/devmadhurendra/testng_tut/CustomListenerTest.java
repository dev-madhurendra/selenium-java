package com.devmadhurendra.testng_tut;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListenerTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println(">> Start test execution " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(">> Finish test execution " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">> Test Start test execution " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(">> Test Skipped test execution " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">> Test Success test execution " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure test execution " + result.getName());
    }
}
