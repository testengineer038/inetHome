package com.inetHome.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name ="uid")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(name ="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(name ="btnLogin")
	@CacheLookup
	WebElement LoginButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement LogoutBtn;
	
	//action methods
	public void setUserName(String uname) {
		UserName.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		Password.sendKeys(pswd);
	}
	
	public void ClickSubmit() {
		LoginButton.click();
	}
	
	public void clickLogout() {
		LogoutBtn.click();
	}
	
}
