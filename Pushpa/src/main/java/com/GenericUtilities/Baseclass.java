package com.GenericUtilities;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public WebdriverUtilties wb = new WebdriverUtilties();
	public FileUtilies fu = new FileUtilies();

	@BeforeSuite
	public void dbConnect() {
		System.out.println("database connected");
	}

	@BeforeClass
	public void browserLaunch() throws Throwable
	{
		String BROWSER = fu.getPropertyKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			sdriver = driver;
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			sdriver = driver;
		}
	}

	@BeforeMethod
	public void loginToApp() 
	{
		System.out.println("enter to website");  
	}

	@AfterMethod
	public void logoutToApp()
	{
		System.out.println("logout to website");
	}

	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

	@AfterSuite
	public void dbDisconnect() throws SQLException
	{

		System.out.println("database connection closed");
	}
}


