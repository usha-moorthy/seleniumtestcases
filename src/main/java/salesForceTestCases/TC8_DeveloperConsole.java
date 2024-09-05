package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC8_DeveloperConsole extends ReusableMethods {
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
	static void developerConsole() throws Exception
	{
		Thread.sleep(2000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//div[@id='userNavButton']/span"));
		click(use_menu_dd);
		Thread.sleep(2000);
		
		String parentWindow=driver.getWindowHandle();
		
		WebElement developerConsole=driver.findElement(By.xpath("//a[@class='debugLogLink menuButtonMenuLink']"));
		click(developerConsole);
		
		Thread.sleep(2000);
	
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
			String title=driver.getTitle();
			System.out.println(title);
			if (title.contains("Developer Console"))
			{
			System.out.println("Developer console window is displayed");	
			driver.close();
		}
		driver.switchTo().window(parentWindow);
	}
	//	System.out.println(parentWindow);
		Thread.sleep(2000);
		driver.close();
	
	}


	public static void main(String[] args) throws Exception {
		TC8_DeveloperConsole.launchBrowser();
		TC8_DeveloperConsole.login();
		TC8_DeveloperConsole.developerConsole();
		

	}

}
