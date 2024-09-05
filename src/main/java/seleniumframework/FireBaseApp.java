package seleniumframework;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FireBaseApp {
	static WebDriver driver;

	public static void homePage() throws InterruptedException {
		Thread.sleep(2000);
		WebElement home = driver.findElement(By.linkText("Home"));
		home.click();

		WebElement name = driver.findElement(By.xpath("//input[@id='name' and @name='name']"));
		name.sendKeys("usha");

		WebElement fname = driver.findElement(By.id("lname"));
		fname.sendKeys("Pandian");

		WebElement postalAdd = driver.findElement(By.id("postaladdress"));
		postalAdd.sendKeys("texas");

		WebElement personalAdd = driver.findElement(By.id("personaladdress"));
		personalAdd.sendKeys("plano,texas");

		driver.findElement(By.xpath("//input[@value='female']"));
		List<WebElement> stateDropDown = driver.findElements(By.id("state"));
for(WebElement state:stateDropDown) {
		Select select = new Select(state);
		List<WebElement> options=select.getOptions();
		

		for(WebElement o:options) {
			
		
		System.out.println(o.getText());
		}
//		state
}
//.selectByValue("mca");

//		WebElement pincode = driver.findElement(By.id("pincode"));
//		pincode.sendKeys("75025");
	}

	public static void switchTo() throws InterruptedException {
		Thread.sleep(2000);
		WebElement switchTo = driver.findElement(By.className("dropbtn"));
		switchTo.click();
	}

	public static void alert() throws InterruptedException {
		WebElement btnalert = driver.findElement(By.linkText("Alert"));
		btnalert.click();
		Thread.sleep(2000);
		WebElement walert = driver.findElement(By.className("bootbutton"));
		walert.click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		Thread.sleep(2000);
		alert.accept();
	}

	public static void openNewTab() throws InterruptedException {
		WebElement btnwindow = driver.findElement(By.linkText("Windows"));
		btnwindow.click();
		driver.findElement(By.partialLinkText("Click To Open New Tab")).click();
		System.out.println(driver.getCurrentUrl());

	}

	public static void openNewWindow() throws InterruptedException {
		WebElement btnwindow = driver.findElement(By.linkText("Windows"));
		btnwindow.click();
		driver.findElement(By.partialLinkText("Click To Open New Window")).click();
		System.out.println(driver.getCurrentUrl());

	}

	public static void interactions() throws InterruptedException {
		Thread.sleep(2000);
		WebElement btninteractions = driver.findElement(By.xpath("//button[contains (text(),'Intractions')]"));
		btninteractions.click();

	}

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(" https://selenium-prd.firebaseapp.com");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("email_field"));
		WebElement password = driver.findElement(By.id("password_field"));
		username.sendKeys("admin123@gmail.com");
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//button[text()=\"Login to Account\"]"));
		login.click();

      homePage();
//		switchTo();
//		alert();
//		openNewTab();
//		openNewWindow();
//		interactions();
		Thread.sleep(4000);
//		driver.close();

	}

}
