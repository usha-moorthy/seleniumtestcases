package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4b_ValidateErrorMsg extends ReusableMethods{
	static WebDriver driver;
	public static void ValidateErrorMsg() throws Exception  {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.name("username"));
//		username.sendKeys("afd");
		enterText(username,"asdf" );
		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("123");
		enterText(password,"1234" );
	
		WebElement login = driver.findElement(By.id("Login"));
//		login.click();
		click(login);
		
		
		WebElement errorform = driver.findElement(By.xpath("//div[@class='loginError' and @id='error']"));
		String msg=errorform.getText();
		//System.out.println(msg);
		String expectedMsg="Please check your username and password."
				+ " If you still can't log in, contact your Salesforce administrator.";
		if(msg.equals(expectedMsg)) {
			System.out.println(msg);
			System.out.println("TC 4b Passed : Expected  msg");
		}
		else {
			System.out.println("Fail");
			
		}
	}
	public static void main(String[] args) throws Exception {
		ValidateErrorMsg();

	}

}
