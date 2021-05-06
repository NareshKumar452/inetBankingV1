package com.inetBanking.testCase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("pwd name provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();   //close login fail alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.info("login failed");
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("logged out");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();  //close logout alert
			driver.switchTo().defaultContent();
		}
		
		
		
		
		
		
		
	}
	
	//verify alerts present or not - user defined method
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j] = XLUtils.getCellData(path,"sheet1", i, j);  //1 0
			}
		}
		
		return logindata;
		
		
	
	
	}
	
	

}
