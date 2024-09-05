package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC20_LeadTab extends ReusableMethods{
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

	public static void leadsTab() throws Exception {
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		click(leads);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Leads: Home ~ Salesforce - Developer Edition")) {
			System.out.println("tc 20 is pass");
		} else {
			System.out.println("fail");
		}
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		leadsTab();

	}

}
