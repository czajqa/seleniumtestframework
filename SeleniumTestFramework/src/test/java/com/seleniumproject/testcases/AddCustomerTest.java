package com.seleniumproject.testcases;

import com.seleniumproject.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest extends TestBase {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode){
        //driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
        driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
        driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
        driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
    }

    @DataProvider
    public Object[] getData(){
/*        String sheetName = "AddCustomerTest";
        int rows = excelReader.getRowCount(sheetName);
        int cols = excelReader.getColumnCount(sheetName);

        Object[][] data = new Object[rows-1][cols];
        for(int rowNum = 2; rowNum <= rows; rowNum++){
            for(int colNum = 0; colNum < colNum; colNum++){
                data[rowNum-2][colNum] = excelReader.getCellData(sheetName,colNum,rowNum);
            }
        }
        return data;*/
        return new Object[][] { { "testuser_1", "Test@123","kupsko" }};
    }
}
