package com.seleniumproject.utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReader {

    public String path;
    public FileInputStream fis;
    public FileOutputStream fileOut;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public ExcelReader(String path){
        this.path = path;
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getRowCount(String sheetName){
        return workbook.getSheet(sheetName).getLastRowNum()+1;
    }

    public int getColumnCount(String sheetName){
        return workbook.getSheet(sheetName).getRow(1).getLastCellNum();
    }

    public String getCellData (String sheetName, int column, int row){
        return workbook.getSheet(sheetName).getRow(row-1).getCell(column).toString();
    }
}
