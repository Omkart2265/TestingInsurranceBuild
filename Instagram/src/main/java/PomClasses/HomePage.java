package PomClasses;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	
	@FindBy (xpath = "(//span[text()='Flights'])[1]")
	private WebElement Flights;
	
	@FindBy (xpath = "(//span[text()='Hotels'])[1]")
	private WebElement Hotels;
	
	@FindBy (xpath = "(//span[text()='Homestays'])[1]")
	private WebElement Homestays;
	
	@FindBy (xpath = "(//span[text()='Holiday Packages'])[1]")
	private WebElement HolidayPackages;
	
	@FindBy (xpath = "(//span[text()='Trains'])[1]")
	private WebElement Trains;
	
	@FindBy (xpath = "(//span[text()='Buses'])[1]")
	private WebElement Buses;
	
	@FindBy (xpath = "(//span[text()='Cabs'])[1]")
	private WebElement Cabs;
	
	@FindBy (xpath = "//span[text()='Visa']")
	private WebElement Visa;
	
	@FindBy (xpath = "//li[@data-cy='account']")
	private WebElement Omkar;
	
	@FindBy (xpath = "//p[text()='My Profile']")
	private WebElement Profile;
	
	@FindBy (xpath = "// span[@class='myPrfilSprit myPrfilSprit__logout']")
	private WebElement Logout;
	
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void Flights() {
		Flights.click();
	}
	
	public void Hotels() {
		Hotels.click();
	}
	
	public void Homestays() {
		Homestays.click() ;
	}
	public void HolidayPackages() {
		HolidayPackages.click();
	}
	
	public void Trains() {
		Trains.click();
	}
	
	public void Buses() {
		Buses.click() ;
	}
	
	public void Cabs() {
		Cabs.click();
	}
	
	public void Visa() {
		Visa.click() ;
	}
	
	public void omkar() throws InterruptedException {
		Thread.sleep(2000);
		String addr = new String(driver.getWindowHandle());
		driver.switchTo().window(addr);
		
         Actions act = new Actions(driver);
         act.moveToElement(Omkar);
	}
	
	public void profile() {
        Actions act = new Actions(driver);
        act.moveToElement(Profile).perform();
	}
	
//	public void logouts() {
//        Actions act = new Actions(driver);
//        act.moveToElement(Profile).perform();
//	}
	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.visibilityOf((WebElement) Logout));
		 Actions act = new Actions(driver);
		 act.moveToElement(Omkar).perform();
		 act.moveToElement(Logout).click().build().perform();
		 Logout.click();
		 
	}
	
	
	
	 
}
