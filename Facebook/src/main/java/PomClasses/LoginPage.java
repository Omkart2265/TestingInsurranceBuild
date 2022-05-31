package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	@FindBy (xpath = "//input[@class='inputtext _55r1 _6luy']")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@ id='pass']")
	private WebElement password;
	
	@FindBy (xpath = "//button[text() = 'Log In']")
	private WebElement LoginButton;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement ForgotPassword;
	
	@FindBy (xpath = "//a[text()='Create New Account']")
	private WebElement CreateNewAccount;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName()  {
		userName.sendKeys("Omkart2265@gmail.com");
		 
	}
	
	public void password()  {
		password.sendKeys("OmkarThorat@321");
		 
	}
	
	public void loginButton() {
		LoginButton.click() ;
	}
	
	public void forgotPassword() {
		ForgotPassword.click() ;
	}
	
	public void createNewAccount() {
		CreateNewAccount.click() ;
	}
	
}
