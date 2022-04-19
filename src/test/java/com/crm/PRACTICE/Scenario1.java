package com.crm.PRACTICE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class Scenario1 extends BaseClass

{

	@Test
	public void scenario1() {
		HomePage hp=new HomePage(driver);
		hp.clickonContactsLnk();
				
			List<WebElement> allcheckbox =driver.findElements(By.xpath("//teble/tbody/tr[*]/td[1]/input[@name='selected_id']"));
			for(WebElement checkbox:allcheckbox) {
				checkbox.click();
			}
				
				
	}
}
