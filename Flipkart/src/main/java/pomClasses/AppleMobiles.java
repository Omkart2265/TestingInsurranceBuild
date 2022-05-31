package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppleMobiles {

	@FindBy (xpath = "//div[text()='APPLE iPhone 11 (Black, 64 GB)']")
	private WebElement AppleIphoneBlack;	

	@FindBy (xpath = "//div[text()='APPLE iPhone 11 (White, 64 GB)']")
	private WebElement AppleIphoneWhite;
	
	@FindBy (xpath = "//div[text()='APPLE iPhone 13 (Midnight, 128 GB)']")
	private WebElement AppleIphoneMidnight;
	
	
	public AppleMobiles(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void AppleIphoneBlack() {
		AppleIphoneBlack.click();
	}
	
	public void AppleIphoneWhite() {
		AppleIphoneWhite.click();
	}
	
	public void AppleIphoneMidnight() {
		AppleIphoneMidnight.click();
	}
	
	 
	
}
