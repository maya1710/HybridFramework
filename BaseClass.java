package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setupBrowser()
	{
		//System.out.println("===============&&&&&&&&&&&&&&==============================");
		//System.out.println("inside  base class--calling configproperty");
		System.out.println("LOG:INFO - Setting up Browser");
		
		//Config - does not suite for cross browser
		
		String browserName = ConfigReader.getProperty("browser");
		String appUrl = ConfigReader.getProperty("url");
		
		System.out.println("browser0000000000000####"+browserName);
		System.out.println("url 000000000000000####"+appUrl);
		
		driver=BrowserFactory.startBrowser(browserName,appUrl);
		
		System.out.println("driver is ##################"+driver);
		
		System.out.println("===============&&&&&&&&&&&&&&==============================");
		
		System.out.println("LOG:INFO - Application is up and running");
		
	}
	@AfterClass
    public void closeBrowser()
    {
    	driver.quit();
    	
    	System.out.println("LOG:INFO - Closing the Browser and application");
    }
}
