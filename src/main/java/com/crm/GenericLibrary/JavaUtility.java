package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;
/**
 * this class will return all the generic data to the user
 * @author ashna
 *
 */
public class JavaUtility {
/**
 * this method will generate the random number and return it to the user
 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random;
	}
	/**
	 * this method will generate the system date and return it to the user
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	/**
	 * this method will generate the system date in format and return it to the user
	 * @return
	 */
	
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon = date[1];
		String day = date[2];
	    String time = date[3].replace(":", "-");
		String year = date[5];
		
		String dateformat = day+"-"+mon+"-"+year;
		return dateformat;
	}
}
