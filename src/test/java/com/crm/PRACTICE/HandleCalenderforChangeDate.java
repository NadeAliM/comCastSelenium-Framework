package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleCalenderforChangeDate {
	@Test
	public void handlingCalenderTest() {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");

		String monthname = "September 2022";
		String date = "12";

		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		String arrowxpath = "//span[@aria-label='Next Month']";
		String datexpath = "//div[text()='"+monthname+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='"+date+"']";



		for(;;) {

		
		try {

			driver.findElement(By.xpath(datexpath)).click();
			break;

		} 
		catch (Exception e) {
			driver.findElement(By.xpath(arrowxpath)).click();
		}

	}	
}
}


