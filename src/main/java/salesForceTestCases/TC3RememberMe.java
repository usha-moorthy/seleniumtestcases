package salesForceTestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC3RememberMe extends ReusableMethods {
	static WebDriver driver;

	public static void tc3RememberMe() throws Exception {
		ChromeOptions co=new ChromeOptions();
	//	co.addArguments("--headless");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.name("username"));
//		username.sendKeys("usham@tekarch.com");
		enterText(username, "usham@tekarch.com");
		WebElement password = driver.findElement(By.id("password"));
//		password.sendKeys("Usha@123");
		enterText(password, "Usha@123");
		WebElement Remember_me = driver.findElement(By.id("rememberUn"));
//		Remember_me.click();
		click(Remember_me);
//		System.out.println("click login");
		WebElement login = driver.findElement(By.id("Login"));
//		login.click();
		click(login);
		System.out.println("logged in");
		Thread.sleep(3000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//span[@class='menuButtonLabel' and @id='userNavLabel']"));
//		use_menu_dd.click();
		click(use_menu_dd);
		Thread.sleep(3000);
		WebElement use_menu_logout = driver.findElement(By.xpath("//a[@href='/secur/logout.jsp']"));
//		use_menu_logout.click();
		click(use_menu_logout);
		Thread.sleep(5000);
//		validation		
		WebElement username1 = driver.findElement(By.id("username"));
		String userTxtValue = username1.getAttribute("value");
         String actualValue="usham@tekarch.com";
//		System.out.println("remembered user name  = " + userTxtValue);
         if(actualValue.equals(userTxtValue)) {
        	
        	 System.out.println("Actual equals  Expected UserName ");
 			System.out.println("TC3 is passed");
 		}
 		else {
 			System.out.println("Fail");
 			
 		}
//		driver.close();
         }

	public static void cookies() {
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Cookie size"+cookies.size());
/*		for(Cookie ck:cookies)
		{
			System.out.println(ck.getName()+" : "+ck.getValue());
		}*/
		System.out.println(driver.manage().getCookieNamed("CookieConsentPolicy"));
		driver.manage().deleteCookieNamed("CookieConsentPolicy");	
		}

	
	public static void main(String[] args) throws Exception {

		tc3RememberMe();
	//	cookies();
	}

}

