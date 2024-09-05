package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {
static WebDriver driver;
	public static void enterText(WebElement ele, String textvalue) throws Exception {
		if (ele.isDisplayed()) {
			Thread.sleep(2000);
			ele.sendKeys(textvalue);
			System.out.println("value is entered");
		} else {
			System.out.println("value is not entered");
		}
	}
	

	public static void click(WebElement ele) throws Exception {
		if (ele.isDisplayed()) {
			Thread.sleep(2000);
			ele.click();
			System.out.println("Element is clicked");
		} else {
			System.out.println("Element is not clicked");
		}
	}
	

	public static void close(WebDriver driver) throws Exception {
		driver.close();
	}
	
	public static void clear(WebElement ele) throws Exception {
		ele.clear();
	}
	

	public static void actionsClick(WebDriver driver, WebElement ele) {
		if (ele.isDisplayed()) {
			Actions action = new Actions(driver);
			action.click(ele).build().perform();
		} else {
			System.out.println("Element is not clicked");
		}
	}
	
	public static void selectDropdown(WebElement ele) {
		
		if(ele.isDisplayed()) {
			System.out.println("Pass");
			ele.click();
		}else
		{
		
			System.out.println("Fail");	
	
	    }}
	public static void switchToFrame( WebDriver driver,WebElement ele) {
		 
	    if(ele.isDisplayed()) {
	     driver.switchTo().frame(ele);
	    
	     
	    }else {
	     System.out.println("Fail");

	    }
	}
	public static void switchToDefaultFrame( WebDriver driver) {
		driver.switchTo().defaultContent();	
	}
	
	public static void SelectByValue(WebElement ele, String val) {
		  
		if(ele.isDisplayed()) {
		   Select select=new Select(ele);
		    
		   select.selectByValue(val);
		 
		 
		  }else {
		   System.out.println("Fail");
		  }
		 }	
public static void validation(String actual, String revmsg) {
		
		if(actual.equals(revmsg))
		{
			System.out.println("TestCase is passed");
		}else
	    {
		System.out.println("TestCase is failed");

	    }
	}
	public static void selectByIndex(WebElement ele, int index) {
		  if(ele.isDisplayed()) {
		   Select select=new Select(ele);
		  select.selectByIndex(index);
		  
		  System.out.println("pass ");
		  }else {
		   System.out.println("Fail:"+index+"is not selected");

		  }
		 }	
	public static void selectByVisibleText(WebElement ele, String Name) {
		if(ele.isDisplayed()) {
			 Select select = new Select(ele);
			 select.selectByVisibleText(Name);
		 System.out.println("Pass");
		 }else {
		 System.out.println("Fail");
		 }
		 }
	
	public static void radioButton(WebElement ele) {
		
		if(ele.isDisplayed() ){
			ele.click();
			System.out.println("pass");
		}else {
			System.out.println("Fail");			
		}
	}
	
	
	
	
}
