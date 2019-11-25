package com.seleniumproject.utilities;

import com.seleniumproject.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtil extends TestBase {
    public static String screenshotPath;
    public static String screenshotName;
    public static void captureScreenshot() throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        screenshotName = d.toString().replace(":","_").replace(" ","_")+".jpg";
        FileUtils.copyFile(screenshotFile,new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenshotName));
    }
}
