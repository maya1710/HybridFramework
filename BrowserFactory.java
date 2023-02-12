package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BrowserFactory {
	
	 public static WebDriver startBrowser(String browserName,String applicationURL)
	  {
		WebDriver driver=null;
		
		if(browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome"))
		{
			//ChromeOptions opt=new ChromeOptions();
			
			//opt.setHeadless(false);
			
			driver=new ChromeDriver();
			System.out.println("==================0###########################=============================");
			System.out.println("thedriver"+driver);
			
			System.out.println("==================0###########################=============================");
		}
		else if(browserName.contains("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if (browserName.contains("Safari"))
		{
			driver=new SafariDriver();
		}
		else if(browserName.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		
		driver.get(applicationURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		return driver;
	

}
	 }
