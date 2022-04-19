package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author ashna
 *
 */
public class ExcelFileUtility {
	

		/**
		 * this method read the data from excel file by using the parameter if user is specified
		 * @param sheetname
		 * @param rownum
		 * @param cellnum
		 * @return
		 * @throws Throwable
		 * @throws IOException
		 */
	public String readDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable {
	FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	return value;
		}
	/**
	 * this method write the data into excel file by using the parameter if user is specified
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetname,int rownum,int cellnum,String value) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row ro = sh.getRow(rownum);
		Cell cel = ro.createCell(cellnum);
		cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IPathConstants.excelPath);
		wb.write(fos);
		
	}
	/**
	 * this method will read the last count no.of the row by using the parameter if user is specified
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		return count;
	}
	
	
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}


}
