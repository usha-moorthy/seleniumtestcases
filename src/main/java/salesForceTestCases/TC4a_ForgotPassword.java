package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC4a_ForgotPassword extends ReusableMethods {
	static WebDriver driver;
	public static void forgetPassword() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.name("username"));
//		username.sendKeys("usham@tekarch.com");
		enterText(username,"usham@tekarch.com" );
		WebElement forgotPassword=driver.findElement(By.id("forgot_password_link"));
//		forgotPassword.click();
		click(forgotPassword);
//		validation
		String window=driver.getTitle();
		System.out.println(window);
		
	}

	public static void main(String[] args) throws Exception {
		forgetPassword();	
		

	}

}
