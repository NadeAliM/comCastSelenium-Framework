package com.crm.opportunityTests;

import java.io.IOException;

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
import com.crm.ObjectRepository.CreateOpportunityPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OpportunityPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Opportunity  extends BaseClass{

	
	@Test
	public void opportunity() throws Throwable
	{
		
		
		
		String OppNameRan = eLib.readDataFromExcel("opportunity", 1, 1)+"_"+jLib.getRandomNumber();
		String CampNameRan = eLib.readDataFromExcel("opportunity", 4, 1)+"_"+jLib.getRandomNumber();
		//String billingaddress = eLib.readDataFromExcel("Org", 13, 2);
		
	
		
		//step4: navigate to opportunity link
		HomePage hp=new HomePage(driver);
		hp.ClickOnopportunityLnk();
		
		OpportunityPage op=new  OpportunityPage(driver);
		op.OpportunityPage();
		
		CreateOpportunityPage cop=new CreateOpportunityPage(driver);
		cop.CreateOpportunityPage(OppNameRan);
		
		
		
		String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(header.contains(OppNameRan))
		{
			System.out.println(header);
			System.out.println("org created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org not created");
		}
		
		
	WebElement ele = driver.findElement(By.xpath("//select[@id='related_to_type']"));
		wLib.select("Contacts", ele);
		
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
		
		//wLib.switchToWindow(driver, "")
		
		WebElement source = driver.findElement(By.xpath("//select[@name='leadsource']"));
		wLib.select("Employee", source);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*step 8: navigate to contacts link*/
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(CampNameRan);
		
		
		
		
		driver.findElement(By.xpath("(//img[@align='absmiddle'])[4]")).click();
		
		wLib.switchToWindow(driver, "Campaigns");
		
	}
}
