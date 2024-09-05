package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC31_ContactCancelButton extends ReusableMethods {
	static WebDriver driver;

	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");

	}

	public static void login() throws Exception {
		WebElement username = driver.findElement(By.name("username"));

		enterText(username, "usham@tekarch.com");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Usha@123");

		WebElement login = driver.findElement(By.id("Login"));
		// login.click();
		click(login);

	}

	public static void contactCancelButton() throws Exception {
		Thread.sleep(2000);
		// contacts
		WebElement contacts = driver.findElement(By.xpath("//a[@href='/003/o']"));
		click(contacts);
		WebElement newVeiw = driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		click(newVeiw);

		// driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("ABCD");
		WebElement uniname = driver.findElement(By.xpath("//input[@id='devname']"));
		clear(uniname);
		enterText(uniname, "EFGH");
		
		WebElement name = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(name, "ABCD");

		
		WebElement cancel = driver.findElement(By.xpath("//input[@value='Cancel']"));

		click(cancel);

	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		contactCancelButton();

	}

}
