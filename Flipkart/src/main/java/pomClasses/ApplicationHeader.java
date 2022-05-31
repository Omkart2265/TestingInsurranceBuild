package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeader 
{
	WebDriver driver;
	
	@FindBy (xpath = "//div[text()='Top Offers']")
	private WebElement TopOffer;	

	@FindBy (xpath = "//div[text()='Grocery']")
	private WebElement Grocery;
	
	@FindBy (xpath = "(//div[text()='Mobiles'])[1]")
	private WebElement mobiles;
	
	@FindBy (xpath = "(//span[text()='Become a Seller'])[1]")
	private WebElement BecomeABestSeller;
	
	@FindBy (xpath = "//div[text()='Omkar ']")
	private WebElement Omkar;
	
	@FindBy (xpath = "//div[text()='Logout']")
	private WebElement Logout;
	
	
	
	public ApplicationHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver ;
	}
	
	public void TopOffer() throws InterruptedException {
		Thread.sleep(2000);
		TopOffer.click() ;
	}
	
	public void Grocery() throws InterruptedException
	{    Thread.sleep(2000);
		Grocery.click();
	}
	
	public void mobiles() throws InterruptedException {
		Thread.sleep(2000);
		mobiles.click();
 
	}
	
	public void BecomeABestSeller() throws InterruptedException {
		Thread.sleep(2000);
		BecomeABestSeller.click();
	}
	
	 
	
	public void Logout() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(Omkar).perform();
	//	act.click().perform();
		Logout.click();
		Thread.sleep(2000);
		 
	}
	
	
	
}
