package com.crm.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public jdbcFileUtility dbLib=new jdbcFileUtility();
	 public JavaUtility jLib = new JavaUtility();
     public ExcelFileUtility eLib = new ExcelFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver;
	 
	
	@BeforeSuite(groups= {"smokeSuite","regressionSuite"})
	public void ConnectDatabase() {
	//	dbLib.jdbcfile();
		
		Reporter.log("====db connection successful",true);
	}
	
	@BeforeClass(groups= {"smokeSuite","regressionSuite"})
	@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable
	{
		// read data from property
		String BROWSER = pLib.readPropertyFile("browser");
		String URL = pLib.readPropertyFile("url");
		
		//CREATE RUNTIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		 sDriver = driver;
		wLib.MaximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("==== browser launchd successfully=====",true);
	}
	@BeforeMethod(groups= {"smokeSuite","regressionSuite"})
	public void Login() throws Throwable
	{
		String USERNAME = pLib.readPropertyFile("username");
		String PASSWORD = pLib.readPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		Reporter.log("==== Login Successful ====",true);
		
	}
	@AfterMethod(groups= {"smokeSuite","regressionSuite"})
	public void logout()
	{
		HomePage hp=new HomePage(driver);
		hp.signoutOfApp(driver);
		Reporter.log("==== logout successful =====",true);
				
	}
	
	@AfterClass(groups= {"smokeSuite","regressionSuite"})
	public void closebrowser()
	{
		driver.quit();
		Reporter.log("===== browser closed ",true);
	}
	
	@AfterSuite(groups= {"smokeSuite","regressionSuite"})
	public void Closedb()
	{
		//dbLib.closeDB();
		Reporter.log("=== database closed successful =====",true);
	}
	
}
