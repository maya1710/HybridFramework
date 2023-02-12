package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Utility
{

 public static void clickElement(WebDriver driver, By locator )
	{
	 try{
		driver.findElement(locator).click();
		} catch (Exception e)
		{
			try {
				
				System.out.println("Trying with actions class click");
				Actions act=new Actions(driver);
				act.moveToElement(driver.findElement(locator)).click().build().perform();
			  
		
			} catch (Exception e1) 
			{
				System.out.println("Trying with JS click");
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click()", driver.findElement(locator));
			}
		}
		
	}
	public static WebElement highlightElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')",element);
		
		
		waitForSeconds(1);
		
		js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')",element);
		
		
		return element;
	}
	
	public static WebElement highlightElement(WebDriver driver,By locator)
	
	{
		
        WebElement element=driver.findElement(locator);
        
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')",element);
		
		try 
		{
			Thread.sleep(300);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid white;')",element);
		
		
		return element;
	}
	
     public static Alert waitForAlert(WebDriver driver)  
			{
				Alert alt=null;
				
				for(int i =0;i<15;i++)
				{
				   try{
					     alt=driver.switchTo().alert();
					      
					     break;
				      }
				   
				   catch(NoAlertPresentException e)
				    {
					   System.out.println("No Alert Found-Waiting for Alert");
					  
					   waitForSeconds(1);
					 }
				   
				}
				
				return alt;
			 }

   //method overloading which means method name is same signature is different
     public static Alert waitForAlert(WebDriver driver,int time)  
{
	Alert alt=null;
	
	for(int i =0;i<=time;i++)
	{
	   try{
		     alt=driver.switchTo().alert();
		      
		     break;
	      }
	   
	   catch(NoAlertPresentException e)
	    {
		   System.out.println("No Alert Found-Waiting for Alert");
		  
		   waitForSeconds(1);
		 }
	   
	}
	
	return alt;
 }

	 public static void waitForSeconds(int seconds)
            {
				try {
					Thread.sleep(seconds*1000);
				    }catch (InterruptedException e) 
				
				    {
					
				    }
				
			 }

	 
	 public static void multipleScreenshot(int timeInterval,int totalDuration)
	 {
		 
		 for(int i=0;i<totalDuration;i++)
		 {
			 try {
				 Thread.sleep(timeInterval);
				 }catch (InterruptedException e) {
					// TODO: handle exception
				}
		 }
	 }
	 public static void captureScreenshot(WebDriver driver)

	 {
		 try 
         {
   	 
		  FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
		      new File("./MyScreenshot1"+getCurrentTime()+".png"));
		  
	      } 
         catch (IOException e)
         {
		   System.out.println("Something went wrong "+e.getMessage());
		   
	      }
	 }
	 
	 public static String getCurrentTime()
	 {
		 String date=new SimpleDateFormat("HH:mm:ss_dd_MM_yyyy").format(new Date());
		return date;
			
	  }
    

public static void captureScreenshotOfwebElement(WebDriver driver, WebElement element)

//implement this for screenshot of a webElement
{
	 try 
    {
	 
	  FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
	      new File("./MyScreenshot1"+getCurrentTime()+".png"));
	  
     } 
    catch (IOException e)
    {
	   System.out.println("Something went wrong "+e.getMessage());
	   
     }
}
}
