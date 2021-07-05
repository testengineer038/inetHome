package com.inetHome.TestCases1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetHome.PageObjects.AddCustomerPage;
import com.inetHome.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws Exception 
	{
		Thread.sleep(3000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.ClickSubmit();	
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();
		logger.info("providing customer details.....");
		addcust.custName("Pavan");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("500010");
		addcust.custtelephone("8886455598");
		String email = randomeString(7)+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(5000);	
		//logger.info("Validation Started....");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		if(res==true) {
			System.out.println("Test Case Passed");
			captureScreen(driver,"addNewCustomerPass");
			Assert.assertTrue(true);
			//logger.info("Test case passed");
		}else {
			//logger.info("Test Case Failed");
			System.out.println("Test Case Failed");
			captureScreen(driver,"addNewCustomerFail");
			Assert.assertTrue(false);	
		}
		
	}


}
