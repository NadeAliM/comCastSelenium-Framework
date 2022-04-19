package com.crm.GenericLibrary;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation  implements IRetryAnalyzer{
	int count=0;
	int retyrcount=3;
	public boolean retry(ITestResult result) {
		
		while(count<retyrcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
