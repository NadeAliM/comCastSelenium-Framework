package com.crm.GenericLibrary;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Robot;
/**
 * this class consists of all generic methods related to webdriver actions
 * @author ashna
 *
 */
public class WebDriverUtility {
	
	

	
	public void MaximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *this method will wait for 20 seconds until the page gets loaded
	 * @param driver
	 */
	
	
	public void waitForPageLoad(WebDriver driver)
	
	{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	/**
	 * this method will wait for the element to be clickable
	 * @param driver
	 */
	
	
	public void waitForElementToBeClickable(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	
	
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	/**
	 * this method will select data from dropdown using value
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	
	
	/**
	 * this method will select data from dropdown using visible text
	 * @param visibleText
	 * @param element
	 * @param value
	 */
	public void select(String visibleText,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	
	/**
	 * this method will perform muse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * this method will perform dragAndDrop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	
	/**
	 * this method will double click on webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element);	
	}
	
	
	/**
	 * this method will double click on webelement
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	
	/**
	 * this method will right click on webelement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * this method will press the enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
	}
	
	
	/**
	 * this method will release the enter key
	 * @throws AWTException
	 */
	public void enterRelease() throws AWTException {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	/**
	 * this method will switch the frame based on the index of the webelement
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * this method will switch the frame based on the nameOrId of the webelement
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
		
	}
	
	
	/**
	 * this method will switch the frame based on the address of the webelement
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address) {
		driver.switchTo().frame(address);
	}
	/**
	 * his method will perform accept operation 
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will perform cancel operation 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will switch to the other window as per user requirement
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String winId = it.next();
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			if(currentWinTitle.contains(partialWinTitle))
					{
				break;
					}
		}
	}
	/**
	 * this method will take takescreenshot on the webpage
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable {
		String path = "./Screenshot/"+screenShotName+".png";
		TakesScreenshot ts =(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	 File dest = new File("./Screenshot/"+screenShotName+".png");
	 Files.copy(src, dest);
	 
	 return dest.getAbsolutePath();
		
	}
	/**
	 *  this method will scroll to particular loaction as specfied by the user
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * this method will scroll to particular loaction as specfied by the user
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+",)", element);
	}
}
