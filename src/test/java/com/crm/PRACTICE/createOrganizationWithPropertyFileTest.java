package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class createOrganizationWithPropertyFileTest {

	@Test
	public void propertyFile() throws Throwable {
		//step1: read the file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		//step2: create object of properties
		Properties pObj=new Properties();
		//step3: load the file
		pObj.load(fis);
		//step4: read the data
		String URL = pObj.getProperty("url");
		//verification teh data
		System.out.println(URL);
		
		
	}
}
