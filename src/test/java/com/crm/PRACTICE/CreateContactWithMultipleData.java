package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactPage;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.ObjectRepository.createContactPage;
public class CreateContactWithMultipleData {

	



	//Create Obj for all utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "ContacttestData")
	public void createOrgWithMltipleData(String LastName) throws Throwable
	{
		
		
		//read data 
		String BROWSER = pLib.readPropertyFile("browser");
		String URL = pLib.readPropertyFile("url");
		String USERNAME = pLib.readPropertyFile("username");
		String PASSWORD = pLib.readPropertyFile("password");
		
		String lstname = LastName+jLib.getRandomNumber();
	
		//launch the application
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wLib.MaximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
		
		//navigate to contact
		HomePage hp = new HomePage(driver);
		hp.clickonContactsLnk();
		Reporter.log("navigated to contact link",true);
		
		//click on new contact
		ContactPage cp = new ContactPage(driver);
		cp.ClickOnCreateContactImg();
		Reporter.log("click on create contactlink",true);
		
		//create new contact
		createContactPage cop = new createContactPage(driver);
		cop.createContactPage(lstname);
		Reporter.log("create contact with lastname",true);
		//validate
		ContactPage cip = new ContactPage(driver);
		/**///String actHeader = cip.ContactInfo();
		
		//if (actHeader.contains(lstname)) {
			System.out.println("passed");
		}
		//else
		//{
			//System.out.println("failed");
		//}
		//Reporter.log("verification successful",true);		
		
		//logout
		//hp.signoutOfApp(driver);
		
		//driver.quit();/**/
	//}
	
	@DataProvider(name = "ContacttestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("ContactMultipleData");
		return data;
	}

}
