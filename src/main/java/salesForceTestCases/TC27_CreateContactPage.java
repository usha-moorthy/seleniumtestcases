package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC27_CreateContactPage extends ReusableMethods {
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

	public static void createContactPage() throws Exception {
		Thread.sleep(2000);
		// contacts
		WebElement contacts = driver.findElement(By.xpath("//a[@href='/003/o']"));
		click(contacts);
		
		WebElement recentlyCreated = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		selectByVisibleText(recentlyCreated, "Recently Created");

		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Contact")) {
			System.out.println("  TC27 is passed   ");
		} else {
			System.out.println("fail");
		}

	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		createContactPage();

	}

}
