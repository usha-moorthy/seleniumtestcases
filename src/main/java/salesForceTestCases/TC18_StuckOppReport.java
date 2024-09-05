package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TC18_StuckOppReport extends ReusableMethods{

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

	public static void stuckOppReport() throws Exception {
		Thread.sleep(3000);
		// opportunities
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		click(opportunities);
		WebElement stuck_opp= driver.findElement(By.linkText("Stuck Opportunities"));
		click(stuck_opp);
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Stuck Opportunities ~ Salesforce - Developer Edition")) {
			System.out.println("tc 18 is pass");
		} else {
			System.out.println("fail");
		}

	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		stuckOppReport();
	}
}