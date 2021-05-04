package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver; // local driver = remote driver
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify Elements
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement CreateNewCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement CustomeName;
	
	@FindBy(xpath="//input[@type='radio'][1]")
	WebElement maleGender;
	
	@FindBy(xpath="//input[@type='radio'][2]")
	WebElement femaleGender;
	
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement PIN;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement PhoneNum;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement Email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement ClickSubmit;
	
	@FindBy(xpath="//input[@name='reset']")
	WebElement ClcikReset;
	
	
	
	
	
	//Action
	public void clickCreateNewCustomer()
	{
		CreateNewCustomer.click();
	}
	
	public void setCustomeName(String cname)
	{
		CustomeName.sendKeys(cname);
	}
	
	public void clickMaleGender()
	{
		maleGender.click();
	}
	
	public void setDateOfBirth(String mm, String dd, String yy)
	{
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yy);
	}
	
	public void setAdress(String cAdress)
	{
		address.sendKeys(cAdress);
	}
	
	public void setCity(String ccity)
	{
		city.sendKeys(ccity);
	}
	
	public void setState(String cState)
	{
		state.sendKeys(cState);
	}
	
	public void setPIN(int cPIN)
	{
		PIN.sendKeys(String.valueOf(cPIN));
	}
	
	public void setPhoneNum(String cPhoneNum)
	{
		PhoneNum.sendKeys(cPhoneNum);
	}
	
	public void setEmailid(String cEmailid)
	{
		Email.sendKeys(cEmailid);
	}
	
	public void setPassword(String cPassword)
	{
		password.sendKeys(cPassword);
	}
	
	public void SubmitClick()
	{
		ClickSubmit.click();
	}
	
}
