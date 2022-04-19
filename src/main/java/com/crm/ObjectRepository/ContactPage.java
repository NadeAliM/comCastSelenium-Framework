package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createLookUpImage;
	
	//initialization
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	
	//utilization
	public WebElement getCreateLookUpImage() {
		return createLookUpImage;
	}
	
	//bussiness library
	public void ClickOnCreateContactImg()
	{
		createLookUpImage.click();
	}
}
