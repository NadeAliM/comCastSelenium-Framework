package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterTheOrgWithAllTest extends BaseClass{
@Test
public void filterTheOrgWithAll() throws Throwable {
	
	//reading data from excel sheet
	String OrgNameRan = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
	String billingaddress = eLib.readDataFromExcel("Org", 13, 2);
	
	
	
	//navigate to organization link
			HomePage hp=new HomePage(driver);
			hp.clickonOrgLnk();
			WebElement alloption = driver.findElement(By.xpath("//select[@name='viewname']"));
		wLib.select("All", alloption);
			//Select s=new Select(alloption);
			//driver.findElement(By.linkText("Create Filter")).click();
			
			
			
			
}
}
