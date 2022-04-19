package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
@FindBy(xpath = "//img[@alt='Create Product...']")
private WebElement createLookUpPage;

//initialization
public ProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


//utilization
public WebElement getCreateLookUpPage() {
	return createLookUpPage;
}

//bussiness library
public void clickOnCreateProductimg()
{
	createLookUpPage.click();
}



}
