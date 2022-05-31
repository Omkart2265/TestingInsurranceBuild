package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement userName;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "(//button[@type = 'submit'])[2]")
	private WebElement SubmitButton;
	
	@FindBy (xpath = "//button[text()='Request OTP']")
	private WebElement RequestOTP;
	
	@FindBy (xpath = "//a[text()='New to Flipkart? Create an account']")
	private WebElement CreateNewAccount;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String user) throws InterruptedException {
		userName.sendKeys(user);
		Thread.sleep(2000);
	}
	
	public void password(String pass) throws InterruptedException {
		password.sendKeys(pass);
		Thread.sleep(2000);
	}
	
	public void SubmitButton() {
		SubmitButton.click() ;
	}
	
	public void RequestOTP() {
		RequestOTP.click() ;
	}
	
	public void CreateNewAccount() {
		CreateNewAccount.click() ;
	}
	
	//or
	public void loginTOApplivation() {
		userName.sendKeys("7507094826");
		password.sendKeys("Omkart@123");
		SubmitButton.click();
		RequestOTP.click();
		CreateNewAccount.click();
	}
	
	
	
	
	
}
