package salesForceTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC13_MergeAccount extends ReusableMethods{
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
	public static void mergeAccount() throws Exception {
		
		Thread.sleep(2000);
		//Opening Accounts page
		WebElement Accounts_Tab = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
		Accounts_Tab.click();
		WebElement Mergeacc = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		click(Mergeacc);
		WebElement findTxt = driver.findElement(By.id("srch"));
		clear(findTxt);
		enterText(findTxt, "united");
		WebElement FindAcc = driver.findElement(By.name("srchbutton"));
		click(FindAcc);
		
	    WebElement Button1 = driver.findElement(By.xpath("//input[@id='cid0']"));
	    radioButton(Button1);
	    WebElement Button2 = driver.findElement(By.xpath("//input[@id='cid1']"));
	    radioButton(Button2);
	    WebElement Button3 = driver.findElement(By.xpath("//input[@id='cid2']"));
	    radioButton(Button3);
	    
	    WebElement Next = driver.findElement(By.xpath("//div[contains(@class,'pbTopButtons')]//input[contains(@title,'Next')]"));
	    Next.click();  
	//    WebElement Merge=driver.findElement(By.xpath("//input[@value=' Merge ']"));
		//	Merge.click();
	    WebElement Merge = driver.findElement(By.xpath("//div[@class='pbTopButtons']//input[@title='Merge']"));
	//    Merge.click();	    
	//    switchtoAlert(driver);	
	    driver.close();
	    System.out.println("TC13_MergeAccounts is completed");
	

		
	}

	
	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		mergeAccount();

	}

}
