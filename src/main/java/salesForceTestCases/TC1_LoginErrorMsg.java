package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TC1_LoginErrorMsg extends ReusableMethods {
	
static WebDriver driver;
	
	public static void tc1ErrorMsg() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("usham@tekarch.com");
		enterText(username,"usham@tekarch.com" );
		
		WebElement password=driver.findElement(By.id("password"));
		password.clear();
		
		WebElement login=driver.findElement(By.id("Login"));
		//login.click();
		click(login);
//		validation
		WebElement error=driver.findElement(By.id("error"));
		String errormsg=error.getText();
		String expectedErrorMsg="Please enter your password.";
//		driver.close();
		close(driver);
		if(errormsg.equals(expectedErrorMsg)) {
			System.out.println(errormsg);
			System.out.println("Actual equals  Expected error msg ");
			System.out.println("TC1 is passed");
		}
		else {
			System.out.println("Fail");
			
		}
		
	}

	public static void main(String[] args) throws Exception {
		tc1ErrorMsg();

	}

}
