package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC24_NewButton extends ReusableMethods {
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

	public static void newButton() throws Exception {
		Thread.sleep(2000);
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		click(leads);
		// new button
		WebElement newButn=driver.findElement(By.xpath("//input[@value=' New ']"));
		click(newButn);
		// input[@id='name_lastlea2']
		WebElement lastName=driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		enterText(lastName, "ABCD");
		WebElement companyNmae=driver.findElement(By.xpath("//input[@id='lea3']"));
		enterText(companyNmae, "ABCD");
		// save
		WebElement save=driver.findElement(By.xpath("//input[@value=' Save ']"));
		click(save);
		String title=driver.getTitle();
		System.out.println(title);
		if (title.contains("Lead: ABCD ~ Salesforce - Developer Edition"))
		{
		System.out.println("tc24 is pass");
		}
		else
		{
			System.out.println("fail");	
		}

	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		newButton();

	}

}
