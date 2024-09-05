package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC11_CreateNewVeiw extends ReusableMethods{
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
	public static void createNewVeiw() throws Exception {
		Thread.sleep(2000);
		WebElement accountBtn=driver.findElement(By.xpath("//li[@id='Account_Tab']/a"));
		click(accountBtn);
		
		WebElement createNewVeiw=  driver.findElement(By.xpath("//a[contains(text(),'Create New View')]"));
		click(createNewVeiw);
		
		WebElement uniqeName=driver.findElement(By.xpath("//input[@id='devname']"));
		clear(uniqeName);
		enterText(uniqeName,"Uni_Name1");

        WebElement veiwName = driver.findElement(By.xpath("//input[@id='fname']"));
        enterText(veiwName,"Accoun_name1");
		
		WebElement save= driver.findElement(By.xpath("//input[@data-uidsfdc='3']"));
	//	click(save);
		
	
/*validation
		String title=driver.getTitle();
		System.out.println(title);
		if(title.contains("Create New Veiw")) {
			System.out.println("Account is created");
		}
		else {
			System.out.println("fail");
		}*/
	}

	public static void main(String[] args) throws Exception {
		TC11_CreateNewVeiw.launchBrowser();
		TC11_CreateNewVeiw.login();
		TC11_CreateNewVeiw.createNewVeiw();

	}

}
