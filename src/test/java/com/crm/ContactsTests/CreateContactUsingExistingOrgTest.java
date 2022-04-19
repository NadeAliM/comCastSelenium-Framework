package com.crm.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.createContactPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactUsingExistingOrgTest extends BaseClass {
	@Test
	public void createContactUsingExistingOrgTest() throws Throwable {
		
	    //read data from excel sheet
	   String lastName = eLib.readDataFromExcel("Org", 7, 2);
	   String OrgName = eLib.readDataFromExcel("Org", 7, 3);
	  
	   
	  
	   
	  
		//step4: navigate to contacts
	   HomePage hp=new HomePage(driver);
	   hp.clickonContactsLnk();
	   
	   ContactPage cp=new ContactPage(driver);
	   cp.ClickOnCreateContactImg();
	   
	   createContactPage ccp=new createContactPage(driver);
	   ccp.createContactPage(lastName, OrgName, driver);
		
	
		
		
	}

}
