package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderPractice6And2 {
@Test(dataProvider = "getData")
	
	public void sampleDataProvider(String Name,String model) {
	System.out.println(Name+"------"+model);
	}
	@DataProvider
	public Object[][] getData(){
	
		Object[][] obj=new Object[6][2];
		
		obj[0][0]="Mi";
		obj[0][1]="13 pro max";
	
		
		obj[1][0]="iphone";
		obj[1][1]="11 max";
	
		
		obj[2][0]="vivo";
		obj[2][1]="17 Max";
		
		
		obj[3][0]="samsung";
		obj[3][1]="A80";
	
		
		obj[4][0]="Nokia";
		obj[4][1]="f15";
	
		
		obj[5][0]="Tesla";
		obj[5][1]="z13";

		
		return obj;
		
		
	}
		
		
		
		
	}


