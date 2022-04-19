package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
@FindBy(xpath = "//img[@alt='Create Opportunity...']")
private WebElement clickOnLookUpImg;

public OpportunityPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getClickOnLookUpImg() {
	return clickOnLookUpImg;
}

// bussiness Library
public void OpportunityPage() {
	clickOnLookUpImg.click();
}

}
