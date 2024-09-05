package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
  public LoginPage(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);//this keyword refers the class instance itself
  }
	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='Login']")
	public WebElement login;

	@FindBy(xpath = "//div[@id='error']")
	public WebElement errormsg;

	@FindBy(xpath = "//input[@id='rememberUn']")
	public WebElement rememberme;

	@FindBy(xpath = "//span[@id='userNavLabel']")
	public WebElement usernameddbtn;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	public WebElement logout;

	@FindBy(xpath = "//a[@id='forgot_password_link']")
	public WebElement forgotpasswordlink;

	@FindBy(xpath = "//div[@id='error']")
	WebElement errorMsg;

	public void username() {

		
	}
	
	
	 

}
