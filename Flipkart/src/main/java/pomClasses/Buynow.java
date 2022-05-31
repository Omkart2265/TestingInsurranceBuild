package pomClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buynow {
	
	WebDriver driver;
	
	@FindBy (xpath = "//button[@type='button']")
	private WebElement BUYNOW;
	
	@FindBy (xpath = "//button[text()='ADD TO CART']")
	private WebElement ADDTOCART;
	
	public Buynow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void buynow() {
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		BUYNOW.click();
	}
	
	public void Addtocart() {
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		ADDTOCART.click();
	}
	
	public void productbuyPage() {
		BUYNOW.click();
		ADDTOCART.click();
	}

}
