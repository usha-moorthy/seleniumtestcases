package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC12_EditVeiw extends ReusableMethods {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		TC12_EditVeiw.launchBrowser();
		TC12_EditVeiw.login();
		TC12_EditVeiw.createNewVeiw();

	}

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

	

	public static void createNewVeiw() throws Exception {
		Thread.sleep(2000);
		WebElement accountBtn = driver.findElement(By.xpath("//li[@id='Account_Tab']/a"));
		click(accountBtn);
		WebElement select = driver.findElement(By.xpath("//select[@id='fcf']"));
		selectByIndex(select, 1);
		// click edit
		WebElement edit = driver.findElement(By.xpath("//a[text()='Edit']"));
		click(edit);

		WebElement filter = driver.findElement(By.xpath("//select[@title='Search By 1']"));
		
		selectByVisibleText(filter, "Account Name");

		Thread.sleep(2000);
		WebElement opration = driver.findElement(By.xpath("//select[@data-uidsfdc='7']"));
		selectByVisibleText(opration, "contains");

		WebElement valuBtn = driver.findElement(By.xpath("//input[@title='Value 1']"));
		clear(valuBtn);
		enterText(valuBtn, "a");

		WebElement lastActivity = driver.findElement(By.xpath("//*[@id='colselector_select_0']/option[31]"));
		click(lastActivity);

		WebElement addButton = driver.findElement(By.xpath("//img[@alt='Add']"));
		click(addButton);

		WebElement save = driver.findElement(By.xpath("//input[@data-uidsfdc='5']"));
	}

}
