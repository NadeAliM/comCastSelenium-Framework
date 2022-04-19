package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMPracticeforLogin {

	@Test
	public void pomPractice() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888");
		
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp("admin", "admin");
		
		
		HomePage hp=new HomePage(driver);
		hp.clickonOrgLnk();
		hp.signoutOfApp(driver);
		}
}
