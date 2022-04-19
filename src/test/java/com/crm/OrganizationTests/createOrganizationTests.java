package com.crm.OrganizationTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class createOrganizationTests  extends BaseClass{
@Test
public void createOrganizationRest() throws Throwable {
	
     
     String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
	
	HomePage hp=new HomePage(driver);
	hp.clickonOrgLnk();
	
	OrganizationPage Org=new OrganizationPage(driver);
	Org.ClickOnCreateOrgImg();
	
	CreateOrganizationPage Cop=new CreateOrganizationPage(driver);
	Cop.createNewOrg(OrgName);
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actOrgName = oip.OrgNameInfo();
	if(actOrgName.contains(OrgName))
	{
		System.out.println(OrgName+"---------> data verified");
	}
	else {
		System.out.println("data not verified");
	}
	
	
	
	
	
	
}
}
