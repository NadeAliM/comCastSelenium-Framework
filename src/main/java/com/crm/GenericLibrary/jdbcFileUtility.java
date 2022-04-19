package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class jdbcFileUtility {
	
	
	Connection con;
	/**
	 * this method will establish the connection 
	 * @throws Throwable
	 */
	public void jdbcfile() throws Throwable
	{
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		// get connection
		 con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);
	}
	/**
	 * close the database
	 * @throws Throwable
	 */
	
	public void closeDB() throws Throwable {
		con.close();
	}
	/**
	 * this method will executr the query and return the matching data to the user
	 * @throws Throwable 
	 * 
	 */
	public String executeQueryAndGetData(String Query,int index,String expdata) throws Throwable
	{
		String data=null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(Query);
		while(result.next())
		{
			 data = result.getString(index);
			if(data.equalsIgnoreCase(expdata))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(data+ "data is verified");
			return expdata;
			
		}
		else
		{
			System.out.println("data is not verified");
			return "";
		}
	}

}
