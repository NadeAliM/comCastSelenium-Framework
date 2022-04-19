package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery {
@Test
public void sampleJDBCExecuteQuery() throws Throwable
{
//step 1: register the database
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	//step2
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	 java.sql.Statement state = con.createStatement();
	ResultSet result = state.executeQuery("select * from Student;");
	while(result.next())
	{
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	}
	con.close();
	 
 
	
	
}
}
