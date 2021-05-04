package com.inetBanking.testCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL =readconfig.getApplicatioURL() ;
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger = Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(baseURL);
		
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File Target = new File(".//Screenshots//"+ tname + ".png");
	FileUtils.copyFile(src, Target);
	System.out.println("Screenshot of" +tname +"is taken");
	
	}
	
	public String randomstring()
	{
		String genertedstring = RandomStringUtils.randomAlphabetic(8);
		return genertedstring;
		
	}
	

	public String randomnumber()
	{
		String genertednumber = RandomStringUtils.randomNumeric(5);
		return genertednumber;
		
	}

	

}
