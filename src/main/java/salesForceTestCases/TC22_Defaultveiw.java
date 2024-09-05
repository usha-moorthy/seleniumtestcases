package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC22_Defaultveiw extends ReusableMethods {
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

	public static void defaultVeiw() throws Exception {
		Thread.sleep(2000);
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		click(leads);
		WebElement leadSelect = driver.findElement(By.xpath("//select[@id='fcf']"));
		click(leadSelect);
		Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		selectByIndex(leadSelect, 2);

	}

	public static void defaultVeiw1() throws Exception {
		Thread.sleep(2000);
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		click(leads);

	}

	public static void logout() throws Exception {
		Thread.sleep(2000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//div[@id='userNavButton']/span"));
		click(use_menu_dd);

		WebElement use_menu_logout = driver.findElement(By.xpath("//a[@href='/secur/logout.jsp']"));
		click(use_menu_logout);
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		defaultVeiw();
		logout();
		Thread.sleep(2000);
		login();
		Thread.sleep(2000);
		defaultVeiw1();
	}

}
