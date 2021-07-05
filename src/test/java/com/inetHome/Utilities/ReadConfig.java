package com.inetHome.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties prop;

	
	public ReadConfig()  
	{	
	File f = new File("./Configurations\\config.properties");
	try 
	{
	FileInputStream fis = new FileInputStream(f);
	prop = new Properties();
	prop.load(fis);
	}catch (Exception e) 
	{
		System.out.println("Exception is " + e.getMessage());
	}
	}
	
	public String getApplicationURL() {
		String URL = prop.getProperty("baseURL");
		return URL;
	}
	
	public String getUserName() {
		String UserName = prop.getProperty("username");
		return UserName;
	}
	
	public String getPassword() {
		String Password = prop.getProperty("password");
		return Password;
	}
	
	public String getBrowserDriver() {
		String BrowserDriver = prop.getProperty("Browserdriver");
		return BrowserDriver;
	}
	
	public String getchromepath() {
		String ChromePath = prop.getProperty("chromepath");
		return ChromePath;
	}
	
	public String getIEpath() {
		String IEPath = prop.getProperty("iepath");
		return IEPath;
	}
	
	public String getFirefoxpath() {
		String FireFoxPath = prop.getProperty("firefoxpath");
		return FireFoxPath;
	}
	
	
	


}
