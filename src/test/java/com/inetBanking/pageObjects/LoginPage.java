package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver; //local driver
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver; // local driver = remote driver
		PageFactory.initElements(rdriver, this);
	}
	
	//identify the elements
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement btnLogout;
	
	
	
	//Action Methods
	
	public void setUserName(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	

}
