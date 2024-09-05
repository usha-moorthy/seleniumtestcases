package salesForceTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC6_MyProfile extends ReusableMethods{
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
		 * click(EditProfilebtn); actionsClick(driver,
		 * EditProfilebtn);
		 */

	}
	

	static void aboutTab() throws Exception {
		Thread.sleep(2000);
		// click EditProfile
		WebElement editMyProfile = driver.findElement(By.xpath("//img[@alt='Edit Profile']"));
		Actions action = new Actions(driver);
		action.click(editMyProfile).build().perform();
		
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
		enterText(lastName, "moorthy");

		WebElement save = driver.findElement(By.xpath("//input[@value='Save All']"));
//		click(save);
		switchToDefaultFrame(driver);
	
	}

	public static void postLink() throws Exception {

		Thread.sleep(2000);
		// Post
		WebElement PostLink = driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']/span[1]"));
		click(PostLink);

		WebElement iframeLink = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
//		driver.switchTo().frame(iframeLink);
		switchToFrame(driver, iframeLink);
		
		Thread.sleep(3000);

		// text area
		WebElement TextArea = driver.findElement(By.xpath("/html/body"));
		enterText(TextArea, "Hello All....");
		driver.switchTo().defaultContent();

		WebElement Share = driver.findElement(By.xpath("//input[@class='zen-btn zen-highlightBtn']"));
		Thread.sleep(3000);
//		click(Share);
		driver.switchTo().defaultContent();
//		switchToDefaultContent();
	}

	static void file() throws Exception {
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement fileLink = driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		click(fileLink);

		WebElement upload = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		click(upload);

		WebElement filepath = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		enterText(filepath, "C:\\Users\\moort\\OneDrive\\Desktop\\Selenium Automation.docx");

		WebElement fileShare = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		click(fileShare);
	}

	public static void addPhoto() throws Exception {
		WebElement addphoto = driver.findElement(By.xpath("//div[@id='photoSection']/*[1]"));
		click(addphoto);
		Thread.sleep(2000);

		WebElement photoiframe = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(photoiframe);

		WebElement chooseFile = driver.findElement(By.xpath("//input[@class='fileInput']"));
		enterText(chooseFile, "C:\\Users\\moort\\OneDrive\\Desktop\\flower.jpg");
		Thread.sleep(2000);

	//	WebElement savephoto = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:save']"));
	//	click(savephoto);
		// input[@class='btn saveButton' and @id='j_id0:uploadFileForm:save']
		
		WebElement save = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		click(save);
	}

	public static void main(String[] args) throws Exception {
		TC6_MyProfile.launchBrowser();
		TC6_MyProfile.login();
		TC6_MyProfile.userMenuDropDown();
//		TC6_MyProfile.aboutTab();
//		TC6_MyProfile.postLink();
//		TC6_MyProfile.file();
		TC6_MyProfile.addPhoto();
	}

}
