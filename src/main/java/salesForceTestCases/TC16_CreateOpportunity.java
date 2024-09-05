package salesForceTestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC16_CreateOpportunity extends ReusableMethods {
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

	static void newOpportunities() throws Exception {
		Thread.sleep(3000);
		// opportunities
		WebElement opportunities = driver.findElement(By.xpath("//a[@href='/006/o']"));
		click(opportunities);

		WebElement New_button = driver.findElement(By.xpath("//input[contains(@title,'New')]"));
		click(New_button);

		WebElement oppname = driver.findElement(By.id("opp3"));
		clear(oppname);
		enterText(oppname, "Opp name");

		// WebElement AccNameOpp = driver.findElement(By.xpath("//input[@id='opp4']"));
		// AccNameOpp.sendKeys("Workday123");

		WebElement lookupWindow = driver.findElement(By.xpath("//img[@title='Account Name Lookup (New Window)']"));
		click(lookupWindow);

		String oldWindow = driver.getWindowHandle();
		// Switching driver control to new window.
		Set<String> getAllWindows = driver.getWindowHandles();
		String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
		System.out.println(getWindow);
		driver.switchTo().window(getWindow[1]);

		Thread.sleep(3000);

		// switch to first frame
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("acc");
		driver.findElement(By.xpath("//input[@name='go']")).click();

		// Switching to Lookup Window
		driver.switchTo().defaultContent();

		// Switching to Insideframe(result)

		driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//table[@border='0']/tbody/tr[2]/th/a")).click();

		driver.switchTo().window(getWindow[0]);

		Thread.sleep(2000);
		// close date
		WebElement date = driver.findElement(By.xpath("//input[@id='opp9']"));
		click(date);
		WebElement today = driver.findElement(By.xpath("//a[@class='calToday']"));
		click(today);

		// Stage
		WebElement stageDD = driver.findElement(By.xpath("//select[@id='opp11']"));
		selectByVisibleText(stageDD, "Qualification");

		// lead source
		WebElement leadSourceDD = driver.findElement(By.xpath("//select[@id='opp6']"));
		selectByVisibleText(leadSourceDD, "Web");

		// primary source
		WebElement primary = driver.findElement(By.xpath("//input[@id='opp17']"));
		enterText(primary, "a");

		// save
		// driver.findElement(By.xpath("//input[@value=' Save ']")).click();
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		newOpportunities();

	}

}
