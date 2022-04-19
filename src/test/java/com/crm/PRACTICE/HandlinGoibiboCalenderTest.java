package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlinGoibiboCalenderTest {
	@Test
	
	public void handlingCalenderTest() throws Throwable {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(10000);
		Actions action=new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("(//p[text()='Enter city or airport'])[1]")).sendKeys("Bengaluru");
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Delhi");
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
	driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Months']/descendant::p[text()='12']")).click();
		//driver.quit();
	}
	
}
