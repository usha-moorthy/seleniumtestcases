package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC10_CreateAccount extends ReusableMethods {
	static WebDriver driver;
	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

	}

	public static void login() throws Exception {
		WebElement username = driver.findElement(By.name("username"));
		// username.sendKeys("usham@tekarch.com");
		enterText(username, "usham@tekarch.com");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Usha@123");

		WebElement login = driver.findElement(By.id("Login"));
		// login.click();
		click(login);

	}
	public static void createAccount() throws Exception {
		Thread.sleep(2000);
		WebElement accountBtn=driver.findElement(By.xpath("//li[@id='Account_Tab']/a"));
		click(accountBtn);
		WebElement newBtn=driver.findElement(By.xpath("//input[@value=' New ']"));
		click(newBtn);
		
		
		WebElement acc_Name=driver.findElement(By.xpath("//input[@id='acc2']"));
		enterText(acc_Name, "account2");
	
		WebElement save=driver.findElement(By.xpath("//input[@title='Save']"));
		click(save);
// validation
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Account")) {
			System.out.println("Account is created");
		}
		else {
			System.out.println("fail");
		}
		
	}

	public static void main(String[] args) throws Exception {
		TC10_CreateAccount.launchBrowser();
		TC10_CreateAccount.login();
		TC10_CreateAccount.createAccount();

	}

}
