package PomClasses;

import java.util.ArrayList;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginProcess 
{
	WebDriver driver;
	
	@FindBy (xpath = "//li[@data-cy='account']")
	private WebElement account;
	
	@FindBy (xpath = "//div[@data-cy='googleLogin']")
	private WebElement googleLogin;
	
	@FindBy (xpath = "//input[@type='email']")
	private WebElement userName;
	
	@FindBy (xpath = "//span[text()='Next']")
	private WebElement next;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	private WebElement tick;
	
	@FindBy (xpath = "//span[text()='Next']")
	private WebElement next2;
	
	public LoginProcess(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void account() {
		account.click();
	}
	
	public void googleLogin() throws InterruptedException {
		Thread.sleep(1500);
		googleLogin.click();
	}
	
	public void userName() {
		 
		userName.sendKeys("omkarthorat204@gmail.com");
	}
	public void next() {
		next.click();
	}
	
	public void password() {
		password.sendKeys("Omkart@456");
	}
	
	public void tick() {
		tick.click() ;
	}
	
	public void next2() {
		next2.click();
	}
	
	//or
	
	public void loginProcess() throws InterruptedException {
		 
		
		account.click();
		Thread.sleep(1000);
		googleLogin.click();
		
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		
		userName.sendKeys("omkarthorat204@gmail.com");
		Thread.sleep(1000);
		next.click();
		Thread.sleep(1500);
		password.sendKeys("Omkart@456");
		Thread.sleep(1000);
		tick.click();
		Thread.sleep(1000);
		next2.click();
	}
}
