package com.seleniumproject.testcases;

import com.seleniumproject.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {
    @Test
    public void loginAsBankManager() throws InterruptedException{
        log.debug("Login as Bank Manager test started");
        driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        log.debug("Clicked button");
        Thread.sleep(1000);
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))));
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("openAccBtn"))));
        Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("customersBtn"))));
        log.debug("Test ended");
        Assert.fail("lul");
    }
}
