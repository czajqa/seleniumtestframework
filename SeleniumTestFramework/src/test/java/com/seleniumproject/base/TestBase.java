package com.seleniumproject.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");

    protected boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

    @BeforeSuite
    public void setUp(){
        if(driver==null){
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                config.load(fis);
                log.debug("Config file loaded");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                OR.load(fis);
                log.debug("OR file loaded");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(config.getProperty("browser").equals("firefox")){
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
                driver = new FirefoxDriver();
                log.debug("Firefox launched");
            }
            else if(config.getProperty("browser").equals("chrome")){
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
                System.setProperty("webdriver.chrome.silentOutput","true");
                driver = new ChromeDriver();
                log.debug("Chrome launched");
            }
            else if(config.getProperty("browser").equals("opera")){
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\operadriver.exe");
                driver = new OperaDriver();
                log.debug("Opera launched");
            }
            else if(config.getProperty("browser").equals("ie")){
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                log.debug("IE launched");
            }
            driver.get(config.getProperty("testsiteurl"));
            log.debug("Went to "+ config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            log.debug("Maximized window");
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        }
    }
    @AfterSuite
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            log.debug("Driver teardown");
        }
    }
}
