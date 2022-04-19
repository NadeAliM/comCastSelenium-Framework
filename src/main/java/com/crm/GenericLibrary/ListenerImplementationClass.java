package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass  implements ITestListener{
	
	
	
    ExtentReports report;
    ExtentTest test;
    
	public void onTestStart(ITestResult result) {
		   String methodName = result.getMethod().getMethodName();
		 test=report.createTest(methodName);
		 
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
	test=report.createTest(MethodName);
	
	}

	public void onTestFailure(ITestResult result) {
		
		String path=null;
		String MethodName = result.getMethod().getMethodName()+"-";
		Reporter.log(MethodName + "--- TestScript Failed",true);
		JavaUtility jLib=new JavaUtility();
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+jLib.getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
		try {
			
			new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			
	
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			test.log(Status.FAIL, MethodName+"------->failed");
			
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(path);
		}
		
		
	
	}

	public void onTestSkipped(ITestResult result) {
	
		String MethodName = result.getMethod().getMethodName();
	
		test.log(Status.SKIP, MethodName+"------->skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
		//execution will start from here
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/Report"+ new JavaUtility().getSystemDateInFormat()+".html");
	htmlreport.config().setDocumentTitle("SDET-30 Execution Report");
	htmlreport.config().setTheme(Theme.DARK);
	htmlreport.config().setReportName("Selenium execution report");
	
	ExtentReports report = new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("base-Browser", "chrome");
	report.setSystemInfo("os", "Windows");
	report.setSystemInfo("base-url", "http://localhost:8888");
	report.setSystemInfo("reporter-name", "Nade Ali M");
	
			
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}

}
