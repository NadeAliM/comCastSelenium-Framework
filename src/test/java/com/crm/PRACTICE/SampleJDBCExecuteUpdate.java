package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
@Test
public void sampleDBCExecuteUpdate() throws Throwable {
	Connection con= null;
	

	try {
	//step 1: register the database
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	//step 2:get connection database
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	 System.out.println("connection established");
	//step3: issue create statement
	Statement state = con.createStatement();
	//step4: execute a query
	int result = state.executeUpdate("INSERT INTO Student1 values(12,'shamshu','male')");
	if(result==1) {
		System.out.println("data added successfully");
	}
	else {
		System.out.println("data not added");
	}
	}
	catch(Exception e) {
		
	}
		
	finally {
	
	//step5: close the database
	con.close();
	System.out.println("connection closed");
	
	}
}
}
