package com.inetHome.TestCases1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetHome.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException, Exception
	{
		
		logger.info("URL is Opened");
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.ClickSubmit();
		logger.info("login Successful");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
				Assert.assertTrue(true);	
				logger.info("Login test Passed");
		}else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

	

}
