package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingCalenderTest {
	@Test
	public void handlingCalenderTest() {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		String datexPath="//div[text()='April 2022']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='12']";
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath(datexPath)).click();
		
		driver.quit();
		
		
	}

}
