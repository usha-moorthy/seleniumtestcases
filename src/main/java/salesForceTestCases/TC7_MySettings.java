package salesForceTestCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC7_MySettings extends ReusableMethods{
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		userMenuclickMySetting();
		// personalAndLoginHistory();
		// displayAndLayout();
		// userMenuclickMySetting();
		// myEmailSetting();
		calendarAndReminders();

		System.out.println("TC7 is passed");

	}

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

	static void userMenuclickMySetting() throws Exception {
		// Click User Menu
		Thread.sleep(2000);
		WebElement use_menu_dd = driver.findElement(By.xpath("//div[@id='userNavButton']/span"));
		click(use_menu_dd);

		WebElement my_settings = driver.findElement(By.xpath("//a[@title='My Settings']"));
		click(my_settings);

	}

	static void personalAndLoginHistory() throws Exception {
		// driver.findElement(By.className("accordionIcon expand_icon")).click();
		WebElement personal = driver.findElement(By.id("PersonalInfo_font"));
		click(personal);
		WebElement loginHistory = driver.findElement(By.id("LoginHistory_font"));
		click(loginHistory);

		// download link
		// driver.findElement(By.xpath("//a[@href='/servlet/servlet.LoginHistory?id=005ak000002GwDO']")).click();
	}

	static void displayAndLayout() throws Exception {
		WebElement Display_Layout = driver.findElement(By.id("DisplayAndLayout_font"));
		click(Display_Layout);
		WebElement CustomizeTab = driver.findElement(By.id("CustomizeTabs_font"));
		click(CustomizeTab);

		WebElement customApp = driver.findElement(By.id("p4"));
		Select custom = new Select(customApp);
		custom.selectByVisibleText("Salesforce Chatter");
		Thread.sleep(4000);

		WebElement report = driver.findElement(By.xpath("//option[@value='report']"));
		click(report);

		WebElement addButton = driver.findElement(By.xpath("//img[@alt='Add']"));
		click(addButton);

		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		click(save);
		Thread.sleep(2000);

		WebElement contentBtnArrow = driver.findElement(By.xpath("//div[@id='tsidButton']"));
		click(contentBtnArrow);
		Thread.sleep(2000);

		WebElement salesForceChatter = driver.findElement(By.xpath("//a[contains(text(),'Salesforce Chatter')]"));
		click(salesForceChatter);
		Thread.sleep(2000);

		WebElement contentBtnArrow1 = driver.findElement(By.xpath("//div[@id='tsidButton']"));
		click(contentBtnArrow1);
		Thread.sleep(2000);

		WebElement content = driver.findElement(By.xpath("//div[@id='tsid-menuItems']/a[7]"));// a[contains(text(),'Content]
		click(content);
	}

	static void myEmailSetting() throws Exception {

		WebElement emailSetup = driver.findElement(By.id("EmailSetup"));
		click(emailSetup);

		// driver.findElement(By.linkText("My Email Settings"));
		WebElement myemailSett = driver.findElement(By.xpath("//span[(text()='My Email Settings')]"));
		click(myemailSett);

		WebElement emailName = driver.findElement(By.id("sender_name"));
		clear(emailName);
		enterText(emailName, "usha pandian");

		WebElement emailAdd = driver.findElement(By.id("sender_email"));
		clear(emailAdd);
		enterText(emailAdd, "ushamoorthy18@gmail.com");
		WebElement radioBtn = driver.findElement(By.xpath("//input[@value='1']"));
		click(radioBtn);
		WebElement save = driver.findElement(By.xpath("//input[@class='btn primary']"));
		click(save);
	}

	static void calendarAndReminders() throws Exception {
		WebElement calendarAndReminders = driver.findElement(By.xpath("//span[@id='CalendarAndReminders_font']"));
		click(calendarAndReminders);

		WebElement activity = driver.findElement(By.xpath("//span[text()='Activity Reminders']"));
		click(activity);

		WebElement testReminder = driver.findElement(By.id("testbtn"));
		click(testReminder);

		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		click(save);
		// WebElement Dissmiss_All=driver.findElement(By.xpath("//input
		// [@id='dismiss_all']"));
		// Dissmiss_All.click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			driver.switchTo().window(handle);
		}
		String pageheading = driver.getTitle();
		if (pageheading.contains("Reminder")) {
			driver.switchTo().defaultContent();
			// driver.quit();
			System.out.println("poped up page title = " + pageheading);

		}
	}

}
