package com.seleniumproject.rough;
import com.seleniumproject.utilities.ExcelReader;

import java.io.IOException;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testdata.xlsx");
        String sheetName = "AddCustomerTest";
        int rows = excelReader.getRowCount(sheetName);
        int cols = excelReader.getColumnCount(sheetName);

        Object[][] data = new Object[rows-1][cols];
        for(int rowNum = 2; rowNum <= rows; rowNum++){
            for(int colNum = 0; colNum < colNum; colNum++){
                data[rowNum-2][colNum] = excelReader.getCellData(sheetName,colNum,rowNum);
            }
        }
    }
}
