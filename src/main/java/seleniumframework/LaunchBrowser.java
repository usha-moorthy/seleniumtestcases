package seleniumframework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LaunchBrowser {
	static WebDriver driver;

	public static void rightClick() {

		WebElement search = driver.findElement(By.name("search_query"));//APjFqb
		//search.sendKeys("india");
		Actions action = new Actions(driver);
		action.contextClick(search)
		.sendKeys(Keys.ARROW_DOWN)
		//.sendKeys(Keys.ARROW_DOWN)
		.sendKeys(Keys.ENTER)
		.build().perform();

	}

	public static void main(String[] args) {
		driver = new ChromeDriver();
	
		// driver.get("https://www.google.com/");
		driver.get(" https://www.youtube.com/");
		driver.manage().window().maximize();
		// WebElement search=driver.findElement(By.id("APjFqb"));
		// search.sendKeys("india");
		// search.submit();
		rightClick();

	}

}
