package com.inetBanking.testCase;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Entering all Customer details");
		
		//AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickCreateNewCustomer();
		addcust.setCustomeName("pavan");
		addcust.setDateOfBirth("01", "01", "98");
		addcust.setAdress("adsfasdfads");
		addcust.setCity("wertyuio");
		addcust.setState("wertyuio");
		addcust.setPIN(234566);
		addcust.setPhoneNum("567890890");
		addcust.setPassword("asdfytree");
		
		String email = randomstring()+"@gmail.com";
		addcust.setEmailid(email);
		
		addcust.SubmitClick();
		
		Thread.sleep(3000);
		
		boolean resultPage = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(resultPage==true)
		{
			Assert.assertTrue(true);
			logger.info("New Customer Registration done");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Registration failed");
		}
		
	}
	
	
}
