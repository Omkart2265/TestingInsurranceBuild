package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browsers.Base;
import PomClasses.HomePage;

public class ValidationOfHomaPage2 
{
	
	WebDriver driver;
	HomePage homePage;
	SoftAssert soft;


	@Parameters ("browserName")
	@BeforeTest
	public void lounchBrowser(String browser) {
		
		System.out.println(browser);
		
		if(browser.equals("Chrome"))
		{
			driver = Base.openChromeBrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver =Base.openFirefoxBrowser();
		}
		if(browser.equals("Edge"))
		{
			driver =Base.openOperaeBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@BeforeClass
	public void createPomObjects() {
		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		soft = new SoftAssert();
	
		
	}
	
	@BeforeMethod
	public void loginprocess() throws InterruptedException {
		 
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyHotelsPageUrl() {
		
		homePage.Hotels();
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();   
		System.out.println(title);
		
		soft.assertEquals("https://www.makemytrip.com/hotels/", url);
		soft.assertEquals("MakeMyTrip.com: Save upto 60% on Hotel Booking 4,442,00+ Hotels Worldwide", title);
		soft.assertAll();
		
		
	}
	
	@Test
	public void verifyFlightsPageUrl() {
		
		homePage.Flights();
		 
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals("https://www.makemytrip.com/flights/", url);
		soft.assertEquals("Flight Booking, Flight Tickets Booking at Lowest Airfare | MakeMyTrip", title);
		soft.assertAll();
		
		 
	}
	
	@AfterMethod
	public void logout() {
		 driver.navigate().back();
	}
	
	@AfterClass
	public void clearObjects() {
		 
		homePage = null;
		soft = null;
	}
	
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver = null;
		System.gc();
	}
	
}
