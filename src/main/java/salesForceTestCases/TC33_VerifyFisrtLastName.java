package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC33_VerifyFisrtLastName  extends ReusableMethods{
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
	public static void verify() throws Exception {
		//home
		 driver.findElement(By.xpath("//a[@href='/home/home.jsp']")).click();
			
	     //name link 
//	     driver.findElement(By.xpath("//div[@id='mru005ak000002GwDO']")).click();
	      		//<a href="/home/home.jsp" title="Home Tab">Home</a>
	     WebElement nameLink = driver.findElement(By.xpath("//h1/a"));
			click(nameLink);
			String title1=driver.getTitle();
			System.out.println(title1);
		
	
	
		Thread.sleep(2000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//div[@id='userNavButton']/span"));
		click(use_menu_dd);
		WebElement myprofile = driver.findElement(By.xpath("//a[@title='My Profile']"));
		click(myprofile);
		String title2=driver.getTitle();
		System.out.println(title2);
		//validation
		if(title1.equals(title2))
		{
			System.out.println("profile and name link are same");
			System.out.println("Tc 33 is passed");
		}
		else
		{
			System.out.println("fail");
		}

	}
	
	public static void main(String[] args) throws Throwable {
		launchBrowser();
		login();
		Thread.sleep(2000);
		verify();
	//	userMenuDropDown();
	}
}
