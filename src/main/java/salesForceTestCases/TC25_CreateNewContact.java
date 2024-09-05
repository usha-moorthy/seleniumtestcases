package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC25_CreateNewContact extends ReusableMethods {
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

	public static void createNewContact() throws Exception {
		Thread.sleep(2000);
		// contacts
		WebElement contacts = driver.findElement(By.xpath("//a[@href='/003/o']"));
		click(contacts);

		// new button
		WebElement newButton = driver.findElement(By.xpath("//input[@value=' New ']"));
		click(newButton);

		// last name
		// input[@id='name_lastlea2']
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		enterText(lastname, "moorthy");
		// account name
		WebElement accountName = driver.findElement(By.xpath("//input[@id='con4']"));
		enterText(accountName, "account1");

		// save
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		click(save);
		String title=driver.getTitle();
		System.out.println(title);
		if (title.contains("Contact"))
		{
			System.out.println("  TC25 is passed   ");
		}
		else
		{
			System.out.println("fail");	
		}
		

	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		createNewContact();

	}

}
