package com.crm.OrganizationTests;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryTypeTest extends BaseClass{
@Test
public void createOrgWithIndustryTypeTest() throws Throwable {
	//navigate to organization link
    
    String Orgname = eLib.readDataFromExcel("Org", 7, 2)+"_"+jLib.getRandomNumber();
	String indType = eLib.readDataFromExcel("Org", 4, 3);
    
    HomePage hp=new HomePage(driver);
    hp.clickonOrgLnk();
	
	//click on org button
    OrganizationPage op=new OrganizationPage(driver);
    op.ClickOnCreateOrgImg();
    	
    
	//enter mandatory fields and save
    
    CreateOrganizationPage cop=new CreateOrganizationPage(driver);
    cop.crecreateNewOrg(Orgname, indType);
	

	
	
		
		
}
}
