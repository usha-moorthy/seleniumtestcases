package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC34_VerifyEditedLastName extends ReusableMethods {
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

	public static void userMenuDropDown() throws Exception {
		Thread.sleep(2000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//div[@id='userNavButton']/span"));
		click(use_menu_dd);
		WebElement myprofile = driver.findElement(By.xpath("//a[@title='My Profile']"));
		click(myprofile);
		Thread.sleep(2000);
//		WebElement editBtn=driver.findElement(By.xpath("//a[@title='Edit Profile']"));
		/*
		 * WebElement EditProfilebtn = driver.findElement(By.
		 * xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
		 * click(EditProfilebtn); actionsClick(driver, EditProfilebtn);
		 */

	}

	static void aboutTab() throws Exception {
		Thread.sleep(2000);
		// click EditProfile
		WebElement editMyProfile = driver.findElement(By.xpath("//img[@alt='Edit Profile']"));
		Actions action = new Actions(driver);
		action.click(editMyProfile).build().perform();
Thread.sleep(2000);
		// iFrame for About Tab
		WebElement iframeAbout = driver.findElement(By.id("contactInfoContentId"));
//		driver.switchTo().frame(iframeAbout);

		switchToFrame(driver, iframeAbout);
		// aboutTab
		WebElement AboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		click(AboutTab);

		// last name
		WebElement lastName = driver.findElement(By.id("lastName"));
		clear(lastName);
		enterText(lastName, "abcd");

		WebElement save = driver.findElement(By.xpath("//input[@value='Save All']"));
		click(save);
		
		switchToDefaultFrame(driver);
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("abcd")) {
			System.out.println("last name is saved TC34 is passed");
			
		}
		else {
			System.out.println("fail");
		}

	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		userMenuDropDown();
		aboutTab();

	}

}
