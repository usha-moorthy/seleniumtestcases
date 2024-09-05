package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC21_LeadsSelectVeiw extends ReusableMethods{
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

	public static void leadsSelect() throws Exception {
		Thread.sleep(2000);
		WebElement leads = driver.findElement(By.xpath("//a[@title='Leads Tab']"));
		click(leads);
		
		//leads drop down
		WebElement leads_DropDown=driver.findElement(By.xpath("//select[@id='fcf']"));
		click(leads_DropDown);
		
		String Leads_DropDownText=leads_DropDown.getText();
		if(leads_DropDown.isDisplayed())
				{
		System.out.println("The dropdown menu items are"+"\n\n"+Leads_DropDownText);
		System.out.println("TC 21 is passed");
		
	}
		else {
			System.out.println(" test case is failed");
		}
		
	
	}

	public static void main(String[] args) throws Exception {
		launchBrowser();
		login();
		leadsSelect();

	}

}
