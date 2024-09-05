package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC5UserMenuDropDown extends ReusableMethods{
	static WebDriver driver;
	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		
	}

	public static void login() throws Exception {
		WebElement username=driver.findElement(By.name("username"));
		//username.sendKeys("usham@tekarch.com");
		enterText(username,"usham@tekarch.com" );
		
		WebElement password=driver.findElement(By.id("password"));
		enterText(password, "Usha@123");
		
		WebElement login=driver.findElement(By.id("Login"));
		//login.click();
		click(login);
		
		
	}

	
	
	public static void userMenuDropDown() throws Exception {
		Thread.sleep(3000);
		WebElement use_menu_dd=driver.findElement(By.xpath("//span[@class='menuButtonLabel' and @id='userNavLabel']"));
		click(use_menu_dd);
//		WebElement use_menu_dd=driver.findElement(By.id("userNavLabel"));
//		use_menu_dd.click();
//		validation		
		WebElement profile=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/child::a[1]"));
		String profileText=profile.getText();
		WebElement setting=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/child::a[2]"));
		String settingText=setting.getText();
		WebElement dev=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/child::a[3]"));
		String devText=dev.getText();
		WebElement swit=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/child::a[4]"));
		String switchText=swit.getText();
		WebElement logout=driver.findElement(By.xpath("//div[@id='userNav-menuItems']/child::a[5]"));
		String logoutText=logout.getText();
		if(profileText.equals("My Profile")&& settingText.equals("My Settings")&& devText.equals("Developer Console") 
				&&switchText.equals("Switch to Lightning Experience")&& logoutText.equals("Logout"))
		{
			System.out.println("TC 5 is passed");
			
		}
		else
		{
			System.out.println("fail");
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		TC5UserMenuDropDown.launchBrowser();
		TC5UserMenuDropDown.login();
		TC5UserMenuDropDown.userMenuDropDown();
		close(driver);

	}

}
