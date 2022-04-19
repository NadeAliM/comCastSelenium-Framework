package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * this class will read data from property file for the key given by user
 * @author ashna
 *
 */
public class PropertyFileUtility {
/**
 * this method will read data from Property file for the key given by user
 * @throws IOException 
 */
	
	public String readPropertyFile (String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pLib=new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
		
	}
}
