package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//decleration
	@FindBy(name="user_name")
	private WebElement usernametbx;
	
	@FindBy(name="user_password")
	private WebElement passwordtbx;
	
    @FindBy(id="submitButton")
   private WebElement submitbtn;
    
    // initialization
    public  LoginPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }

	
    
    //utilization
	public WebElement getUsernametbx() {
		return usernametbx;
	}

	public WebElement getPasswordtbx() {
		return passwordtbx;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	//bussiness library
	public void LoginToApp(String username,String password) {
		usernametbx.sendKeys(username);
		passwordtbx.sendKeys(password);
		submitbtn.click();
	}
	
    
    
    
}