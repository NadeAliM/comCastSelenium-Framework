package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.stat.descriptive.summary.Product;
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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductWithCampaign extends BaseClass {
@Test
public void createProductWithCampaign() throws Throwable {
	//read data from excel sheet
		String ProNameRan = eLib.readDataFromExcel("product", 1, 1)+"_"+jLib.getRandomNumber();
		String CampNameRan = eLib.readDataFromExcel("product", 4, 1)+"_"+jLib.getRandomNumber();
	HomePage hp=new HomePage(driver);
	hp.clickOnProductLnk();
	/*Step 5: click on create product  btn*/
	
	ProductPage pp=new ProductPage(driver);
	pp.clickOnCreateProductimg();

	
	/*Step 6: enter mandatory fields and save*/
	driver.findElement(By.name("productname")).sendKeys(ProNameRan);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*Step 7:verify for orgaqnization*/
	String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(header.contains(ProNameRan))
	{
		System.out.println(header);
		System.out.println("org created");
	}
	else
	{
		System.out.println(header);
		System.out.println("Org not created");
	}
	
	/*step 8: navigate to contacts link*/
	driver.findElement(By.xpath("//a[text()='More']")).click();
	driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CampNameRan);
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	wLib.switchToWindow(driver, "Products");
	
	
	driver.findElement(By.name("search_text")).sendKeys(ProNameRan);
	driver.findElement(By.name("search")).click();
	
	driver.findElement(By.xpath("//a[text()='"+ProNameRan+"']")).click();
	wLib.switchToWindow(driver, "Campaigns");

	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*Step 10: verfify for contact*/
	 String campheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 if(campheader.contains(CampNameRan)) {
		 System.out.println(campheader+"campaign created");
	 }
	 else
	 {
		 System.out.println("campaign not created");
	 }
	
}
}
