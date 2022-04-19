package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class createOrganizationWithPropertyFileTest {
@Test
public void createOrgTest() throws Throwable {
	
	ExcelFileUtility eLib=new ExcelFileUtility();
	WebDriverUtility wLib=new WebDriverUtility();
	
	PropertyFileUtility pLib=new PropertyFileUtility();
	String BROWSER = pLib.readPropertyFile("browser");
    String URL = pLib.readPropertyFile("url");
    String USERNAME = pLib.readPropertyFile("username");
    String PASSWORD = pLib.readPropertyFile("password");
    
    
	
	//step2 :launch the browser
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	wLib.MaximizeWindow(driver);
	   wLib.waitForPageLoad(driver); 
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("xylem1");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.quit();
	
}
}
