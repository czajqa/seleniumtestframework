package com.seleniumproject.testcases;

import com.seleniumproject.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void loginAsBankManager() throws InterruptedException{
        log.debug("Login as Bank Manager test started");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        log.debug("Clicked button");
        Thread.sleep(1000);
        log.debug("Test ended");
    }
}
