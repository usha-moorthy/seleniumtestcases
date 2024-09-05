package salesForceTestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginSalesForce {
	static WebDriver driver;

	public static void login() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("usham@tekarch.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Usha@123");
	}

	public static void rememberMe() {
		WebElement Remember_me = driver.findElement(By.id("rememberUn"));
		Remember_me.click();
	}

	public static void clickLogin() {
		System.out.println("click login");
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
	}

	public static void logout() throws Exception {
		WebElement use_menu_dd=driver.findElement(By.xpath("//span[@class='menuButtonLabel' and @id='userNavLabel']"));
		use_menu_dd.click();
		
		Thread.sleep(3000);
		WebElement use_menu_logout=driver.findElement(By.xpath("//a[@href='/secur/logout.jsp']"));
		use_menu_logout.click();
		Thread.sleep(5000);
		}
	public static void cookies() {
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie ck:cookies)
		{
			System.out.println(ck.getName()+" : "+ck.getValue());
		}
	}

}
