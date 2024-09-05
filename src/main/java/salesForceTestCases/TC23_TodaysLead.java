package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC23_TodaysLead extends ReusableMethods{
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

	public static void todaysLead() throws Exception {
		Thread.sleep(2000);
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		click(leads);
		WebElement leadSelect = driver.findElement(By.xpath("//select[@id='fcf']"));
		click(leadSelect);
		Select view = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		selectByIndex(leadSelect, 3);
		
		WebElement gobutton = driver.findElement(By.xpath("//span[@class='fBody']//input[@name='go']"));
        click(gobutton);
		
	
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		todaysLead();

	}

}
