package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC14_CreateReport extends ReusableMethods{
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
public static void createReports() throws Exception {
	Thread.sleep(2000);
	WebElement account = driver.findElement(By.xpath("//a[@href='/001/o']"));
	click(account);
	WebElement last_activity = driver.findElement(By.xpath("//a[text()='Accounts with last activity > 30 days']"));
	click(last_activity);

	
	// from button caleender
	WebElement calenderIcon = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
	click(calenderIcon);

	Thread.sleep(3000);
	// button[@id='ext-gen281']
	WebElement todayBtn = driver.findElement(By.xpath("//button[@id='ext-gen276']"));
	click(todayBtn);
	// to date
	driver.findElement(By.xpath("//input[@id='ext-comp-1045']")).clear();


	// Calender
	WebElement toCalenderdriverIcon = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
	click(toCalenderdriverIcon);
	;
	// today Button
	WebElement toTodayBtn = driver.findElement(By.xpath("//button[@id='ext-gen292']"));
	click(toTodayBtn);

	Thread.sleep(2000);
	// driver.findElement(By.xpath("//a[@title='Next Month
	// (Control+Right)']")).click();

	// to Save
	WebElement save = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
	click(save);

	// report unique name
	WebElement uniqueName = driver.findElement(By.xpath("//input[@name='reportDevName']"));
	clear(uniqueName);
	enterText(uniqueName, "Repot4Unique");
	
	Thread.sleep(4000);
	// Report Name
	WebElement reportName = driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
	reportName.sendKeys("Repot2");
	enterText(reportName,"Repot2");

	// save and run report
	WebElement runAndReport = driver.findElement(By.xpath("//button[@id='ext-gen312']"));
//	click(runAndReport);
	
}

	public static void main(String[] args) throws Exception {
	launchBrowser();
	login();
	createReports();

	}

}
