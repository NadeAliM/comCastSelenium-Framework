package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility {
@FindBy(name = "potentialname")
private WebElement usernameEdt;

@FindBy(xpath = "//select[@name='opportunity_type']")
private WebElement typedropdown;

@FindBy(xpath = "//select[@name='leadsource']")
private WebElement leadsoursedropdown;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement savebtn;

public CreateOpportunityPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getUsernameEdt() {
	return usernameEdt;
}

public WebElement getTypedropdown() {
	return typedropdown;
}

public WebElement getLeadsoursedropdown() {
	return leadsoursedropdown;
}

public WebElement getSavebtn() {
	return savebtn;
}



//bussiness library
public void CreateOpportunityPage(String OppName,String indType) {
	usernameEdt.sendKeys(OppName);
	select(indType, leadsoursedropdown);
		savebtn.click();
}
public void CreateOpportunityPage(String OppName)
{
	usernameEdt.sendKeys(OppName);
	savebtn.click();
}
}
