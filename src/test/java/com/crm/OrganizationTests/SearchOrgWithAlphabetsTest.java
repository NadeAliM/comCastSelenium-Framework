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
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchOrgWithAlphabetsTest  extends BaseClass{
@Test
public void searchOrgWithAlphabetsTest() throws Throwable {
	
	//reading data from excel sheet
	String OrgNameRan = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
	String billingaddress = eLib.readDataFromExcel("Org", 13, 2);
	

	
	//navigate to organization link
	HomePage hp=new HomePage(driver);
	hp.clickonOrgLnk();
		
			
	//click on org button
	OrganizationPage op=new OrganizationPage(driver);
	op.ClickOnCreateOrgImg();
			
	//create a new organization
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.createNewOrg(OrgNameRan);
			driver.findElement(By.name("accountname")).sendKeys(OrgNameRan);
	//save the new organization
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
	//verify that organization created without billing address
			String billingaddress1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if(billingaddress1.contains(OrgNameRan)) {
				 System.out.println(OrgNameRan+"searched successfully");
			 }
			 else
			 {
				 System.out.println("search  not successful");
			 }
			 
	//navigate to organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(OrgNameRan);
				driver.findElement(By.xpath("//input[@name='submit']")).click();
				
				
				
}
}
