package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
@FindBy(name="accountname")
private WebElement OrgNameEdt;

@FindBy(name = "industry")
private WebElement industryDropDown;

@FindBy(name="accounttype")
private WebElement typeDropDown;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;

@FindBy(name = "bill_street")
private WebElement billlingaddEdt;

//step2: initialization

public WebElement getBilllingaddEdt() {
	return billlingaddEdt;
}



public CreateOrganizationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



//step3:utilization
public WebElement getOrgNameEdt() {
	return OrgNameEdt;
}

public WebElement getIndustryDropDown() {
	return industryDropDown;
}

public WebElement getTypeDropDown() {
	return typeDropDown;
}

public WebElement getSavebtn() {
	return savebtn;
}

// step4: bussiness library
public void createNewOrg(String OrgName)

{
	OrgNameEdt.sendKeys(OrgName);
	savebtn.click();
}
public void crecreateNewOrg(String OrgName, String indType)
{
	OrgNameEdt.sendKeys(OrgName);
	select(indType, industryDropDown);
	savebtn.click();
}
public void createOrgWithBillingAdd(String address)
{
	billlingaddEdt.sendKeys(address);
	savebtn.click();
}

}
