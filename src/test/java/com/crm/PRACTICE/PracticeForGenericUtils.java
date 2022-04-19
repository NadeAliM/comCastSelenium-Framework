package com.crm.PRACTICE;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
@Test
public void practice() throws Throwable 
{
	JavaUtility jLib=new JavaUtility();
	int ran = jLib.getRandomNumber();
	String date = jLib.getSystemDate();
	String dat = jLib.getSystemDateInFormat();
	System.out.println(ran+dat);
	System.out.println(date);
	
	PropertyFileUtility pLib=new PropertyFileUtility();
	String BROWSER = pLib.readPropertyFile("browser");
	System.out.println(BROWSER);
	
	ExcelFileUtility eLib=new ExcelFileUtility();
	String OrgName = eLib.readDataFromExcel("Org", 1,2);
	System.out.println(OrgName);
}
}
