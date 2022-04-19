package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage  extends WebDriverUtility{
@FindBy(linkText = "Organizations")
private WebElement Orglnk;

@FindBy(linkText = "Contacts")
private WebElement contactlnk;

@FindBy(linkText = "Opportunities")
private WebElement opportunitylnk;

@FindBy(linkText = "Products")
private WebElement productslnk;

@FindBy(linkText = "More")
private WebElement morelnk;

@FindBy(linkText = "Campaigns")
private WebElement campaignslnk;


@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorlnk;

@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
private WebElement logoutlnk;


//initialization

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



//getters methods
public WebElement getOrglnk() {
	return Orglnk;
}


public WebElement getContactlnk() {
	return contactlnk;
}


public WebElement getOpportunitylnk() {
	return opportunitylnk;
}


public WebElement getProductslnk() {
	return productslnk;
}


public WebElement getMorelnk() {
	return morelnk;
}


public WebElement getCampaignslnk() {
	return campaignslnk;
}


public WebElement getAdministratorlnk() {
	return administratorlnk;
}


public WebElement getLogoutlnk() {
	return logoutlnk;
}


//bussiness library

public void clickonOrgLnk()
{
	Orglnk.click();
}
public void clickonContactsLnk()
{
	contactlnk.click();
}
public void ClickOnopportunityLnk()
{
	opportunitylnk.click();
}
public void signoutOfApp(WebDriver driver)
{
	mouseHover(driver, administratorlnk);
	logoutlnk.click();
	
}
public void clickOnProductLnk() {
	productslnk.click();
}






	
}

