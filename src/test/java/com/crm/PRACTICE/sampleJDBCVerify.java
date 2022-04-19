package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class sampleJDBCVerify {
@Test
public void samplejdbcverify() throws Throwable {
	String expdata = "rafeek";
	Driver driverref=new Driver();
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	Statement state = con.createStatement();
	ResultSet result = state.executeQuery("select * from Student");
	while(result.next()) {
		String actdata = result.getString(1);
		if(expdata.equalsIgnoreCase(actdata))
		{
			System.out.println(actdata+"    data is verified");
			break;
		}
	}
	con.close();
}
}
