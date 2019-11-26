package com.seleniumproject.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.seleniumproject.base.TestBase;
import com.seleniumproject.utilities.TestUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class CustomListeners extends TestBase implements ITestListener {

    public void onTestStart(ITestResult result) {
        test = reports.startTest(result.getName().toUpperCase());
    }

    public void onTestSuccess(ITestResult result) {
        test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASSED");
        reports.endTest(test);
        reports.flush();
    }

    public void onTestFailure(ITestResult result) {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(LogStatus.FAIL, result.getName().toUpperCase() + " FAILED WITH EXCEPTION"+ result.getThrowable());
        test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
        Reporter.log("Click to see screenshot");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br/>");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img width=\"200\" height=\"100\" src="+TestUtil.screenshotName);
        reports.endTest(test);
        reports.flush();
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
