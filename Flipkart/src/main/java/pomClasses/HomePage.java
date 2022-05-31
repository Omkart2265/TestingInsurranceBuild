package pomClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	@FindBy (xpath = "//input[@class='_3704LK']")
	private WebElement Search;
	
	@FindBy (xpath = "//button[@class='L0Z3Pu']")
	private WebElement SearchButton;
	
	@FindBy (xpath = "//span[text()='Cart']")
	private WebElement Cart;
	
	
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void sendSearch() {
		Search.sendKeys("mobile");
	}
	
	public void Button() {
		SearchButton.click();
	}
	
	public void AddToCart() {
		Cart.click() ;
	}
	
	public void screenshot() throws IOException {
		 TakesScreenshot t1 = (TakesScreenshot)driver;
		 File Sourse = t1.getScreenshotAs(OutputType.FILE);
		 String d1 = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss").format(new Date());
		 File dest = new File("C:\\Users\\DELL\\Desktop\\Automation\\test"+ d1 +".jpeg");
		 FileHandler.copy(Sourse, dest);
		}
	
	 

	public void TopOffer() {
	//	TopOffer.click() ;
	}
	
	//or
	
	public void homePage() {
		Search.sendKeys("mobile");
		SearchButton.click();
		Cart.click() ;
		//TopOffer.click() ;
	}
}
