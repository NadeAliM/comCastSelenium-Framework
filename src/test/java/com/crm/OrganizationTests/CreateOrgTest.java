package com.crm.OrganizationTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateOrgTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public void createOrgTest() throws Throwable {
		
		
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+" "+jLib.getRandomNumber();
	   //click on org button
		HomePage hp=new HomePage(driver);
		hp.clickonOrgLnk();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.ClickOnCreateOrgImg();
		
	   CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);	   
	
	
	
	
   
    

	}

}
