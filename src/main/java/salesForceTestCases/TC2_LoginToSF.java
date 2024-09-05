package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC2_LoginToSF extends ReusableMethods{
	static WebDriver driver;
	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
	}

	public static void login() throws Exception {
		WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("usham@tekarch.com");
		enterText(username,"usham@tekarch.com" );
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password, "Usha@123");
		
		WebElement login=driver.findElement(By.id("Login"));
		//login.click();
		click(login);
		System.out.println("logged in");
		
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();

	}

}
