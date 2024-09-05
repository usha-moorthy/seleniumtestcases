package tests;

import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
public static void main(String[] args) {
	
	WebDriver driver=new ChromeDriver();
	LoginPage lp=new LoginPage(driver);
	driver.navigate().to("https://login.salesforce.com");
	lp.username.sendKeys("usham@tekarch.com");
	lp.password.sendKeys("Usha@123");
	lp.login.click();
	
}
}
