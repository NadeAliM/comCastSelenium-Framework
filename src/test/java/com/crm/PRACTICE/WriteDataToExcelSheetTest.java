package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataToExcelSheetTest {
@Test
public void WriteDataToExcelSheetTest() throws Throwable {
	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row ro = sh.getRow(0);
	Cell ce = ro.createCell(9);
	
ce.setCellValue("tc_1000");
FileOutputStream fos =new FileOutputStream(".\\src\\test\\resources\\data.xlsx");
wb.write(fos);
}
}
