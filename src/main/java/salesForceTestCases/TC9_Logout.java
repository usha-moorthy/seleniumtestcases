package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC9_Logout extends ReusableMethods {
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
	public static void logout() throws Exception {
		Thread.sleep(2000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//div[@id='userNavButton']/span"));
		click(use_menu_dd);
		
		WebElement use_menu_logout = driver.findElement(By.xpath("//a[@href='/secur/logout.jsp']"));
		click(use_menu_logout);
		
// validation		
		String url= driver.getCurrentUrl();
		System.out.println(url);
		if (url.contains("logout"))
		{
		System.out.println("logged out successfully");	
		driver.close();
	}
		else {
			System.out.println("failed");	
		}
		
	}

	public static void main(String[] args) throws Throwable {
		TC9_Logout.launchBrowser();
		TC9_Logout.login();
		TC9_Logout.logout();
		

	}

}
