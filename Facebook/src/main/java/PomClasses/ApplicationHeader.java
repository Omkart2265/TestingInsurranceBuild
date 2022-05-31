package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeader {
	
	
	@FindBy (xpath = "//a[@aria-current='page']")
	private WebElement homepage;
	
	@FindBy (xpath = "//a[@aria-label='Friends']")
	private WebElement friends;
	
	@FindBy (xpath = "//a[@aria-label='Watch']")
	private WebElement watch;
	
	@FindBy (xpath = "//div[@aria-label='Your profile']")
	private WebElement profile;
	
	@FindBy (xpath = "//span[text()='Log Out']")
	private WebElement logout;
	
	public ApplicationHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void homepage() throws InterruptedException {
		homepage.click();
		Thread.sleep(2000);
	}
	
	public void friends() throws InterruptedException {
		friends.click();
		Thread.sleep(2000);
	}
	
	public void watch() {
		watch.click();
	}
	
	public void profile() {
		profile.click() ;
	}
	
	public void logout() {
		logout.click() ;
	}
	
	public void logoutFromApplication() throws InterruptedException {
		profile.click() ;
		Thread.sleep(2000);
		logout.click() ;
	}
	
	
}
