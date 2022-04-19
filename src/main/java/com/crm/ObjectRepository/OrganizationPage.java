package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;


public class OrganizationPage extends WebDriverUtility {
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createLookUpImage;

//step2: initialization


   public OrganizationPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
//step 3:  decleration

public WebElement getCreateLookUpImage() {
	return createLookUpImage;
}
	//step 4: bussiness library
	public void ClickOnCreateOrgImg() 
	{
		createLookUpImage.click();
}

}

