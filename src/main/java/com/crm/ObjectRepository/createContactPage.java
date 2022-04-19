package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class createContactPage  extends WebDriverUtility{
@FindBy (name = "lastname")
private WebElement lastNameEdt;


@FindBy (xpath = "//img[@alt='Select']")
private WebElement orgNameLookUpImg;



@FindBy (xpath = "//select[@name='leadsource']")
private WebElement leadSourceDropDown;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name = "search_text")
private WebElement searchEdt;

@FindBy (name = "search")
private WebElement searchBtn;

//initialization

public createContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



// utilization

public WebElement getLastNmaeEdt() {
	return lastNameEdt;
}

public WebElement getOrgNameLookUpImg() {
	return orgNameLookUpImg;
}

public WebElement getLeadSourceDropDown() {
	return leadSourceDropDown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getSearchBtn() {
	return searchBtn;
}
public WebElement getSearchEdt() {
	return searchEdt;
}
//bussiness library
public void createContactPage(String lastname)
{
	lastNameEdt.sendKeys(lastname);
	saveBtn.click();
}

public void createContactPage(String lastname,String leadSource)
{
	lastNameEdt.sendKeys(lastname);
	select(leadSource, leadSourceDropDown);
	saveBtn.click();
}

public void createContactPage(String lastname,String OrgName,WebDriver driver) 
{
	lastNameEdt.sendKeys(lastname);
	orgNameLookUpImg.click();
	switchToWindow(driver, "Accounts");
	searchEdt.sendKeys(OrgName);
	searchBtn.click();
	
	
	switchToWindow(driver, "Contacts");
	saveBtn.click();
}






}
