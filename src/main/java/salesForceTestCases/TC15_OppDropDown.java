package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC15_OppDropDown extends ReusableMethods{
	
	
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
	
	
	static void opportunities() throws Exception {
		// opportunities
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		click(opportunities);

		WebElement opp_dropdowm = driver.findElement(By.xpath("//select[@id='fcf']"));
		click(opp_dropdowm);
		// *[@id="fcf"]/option[7]
		
		String opp_dropdowm_text = opp_dropdowm.getText();
		System.out.println(opp_dropdowm_text);
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		opportunities();

	}

}
