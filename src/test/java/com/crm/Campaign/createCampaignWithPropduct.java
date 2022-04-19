package com.crm.Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createCampaignWithPropduct extends BaseClass{
	@Test
	public void createCampaignWithProduct() throws Throwable
	{
		
		String campaignName = eLib.readDataFromExcel("Campaign", 1, 1)+"_"+jLib.getRandomNumber();
		String prodName = eLib.readDataFromExcel("Campaign", 1, 2);
		String catType = eLib.readDataFromExcel("Campaign", 1, 3);
	
		
		
		
		
				
		HomePage hp=new HomePage(driver);
		hp.clickOnProductLnk();
		
		ProductPage pp=new ProductPage(driver);
		pp.clickOnCreateProductimg();
		
		
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(prodName);
		
		WebElement pCategory = driver.findElement(By.name("productcategory"));
		wLib.select(pCategory, catType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		wLib.switchToWindow(driver, "Products");
		
		driver.findElement(By.name("search_text")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(prodName)).click();
		
		wLib.switchToWindow(driver, "Campaigns");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}
}
