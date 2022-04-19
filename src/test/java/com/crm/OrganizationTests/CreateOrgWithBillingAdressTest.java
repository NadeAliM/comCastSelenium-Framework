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
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithBillingAdressTest  extends BaseClass{
@Test(groups = "regressionSuite")
public void createOrgWithBillingAdressTest() throws IOException, Throwable {
	
	String OrgNameRan = eLib.readDataFromExcel("Org", 13, 1)+"_"+jLib.getRandomNumber();
	String billingaddress = eLib.readDataFromExcel("Org", 13, 2);
	String indType = eLib.readDataFromExcel("Org", 13, 3);
	
	
	
	
	
	
	//navigate to organization link
	HomePage hp=new HomePage(driver);
	hp.clickonOrgLnk();
	
	
	//click on org button
	OrganizationPage op=new OrganizationPage(driver);
	op.ClickOnCreateOrgImg();
	
	
		
	CreateOrganizationPage cop=new CreateOrganizationPage(driver);
	cop.crecreateNewOrg(OrgNameRan, indType);
	
	cop.getBilllingaddEdt().sendKeys(billingaddress);
		
	
		//verify
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actOrgNmae = oip.OrgNameInfo();
		 String billingaddress1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(actOrgNmae.contains(OrgNameRan)) {
			 System.out.println(billingaddress+"campaign created");
		 }
		 else
		 {
			 System.out.println("campaign not created");
		 }
		
		//logout from application
		 
		 //hp.getLogoutlnk();
		 
		
		
	
		



	
}

}
