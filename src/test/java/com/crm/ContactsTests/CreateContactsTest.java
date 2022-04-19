package com.crm.ContactsTests;

import static org.testng.Assert.fail;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateContactsTest extends BaseClass {
	@Test
	public void createContactsTest() throws Throwable {

		//read data from excel sheet
		String lastname = eLib.readDataFromExcel("Org", 7, 2);

		//step4: navigate to contacts
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLnk();

		//click on add new contact
		ContactPage cp=new ContactPage(driver);
		cp.ClickOnCreateContactImg();
	    Assert.fail();

		//create new contact
		createContactPage ccp=new createContactPage(driver);
		ccp.createContactPage(lastname);







	}

}
