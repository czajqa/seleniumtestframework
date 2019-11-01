package com.seleniumproject.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReader {

    public String path;
    public FileInputStream fis = null;
    public FileOutputStream fileOut = null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;

    public ExcelReader(String path){
        this.path = path;
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        }catch (Exception e){

        }
    }

    public int getRowCount(String sheetName){
        return workbook.getSheet(sheetName).getLastRowNum();
    }

    public int getColumnCount(String sheetName){
        return workbook.getSheet(sheetName).getRow(1).getLastCellNum();
    }

    public String getCellData (String sheetName, int column, int row){
        return workbook.getSheet(sheetName).getRow(row).getCell(column).toString();
    }
}
