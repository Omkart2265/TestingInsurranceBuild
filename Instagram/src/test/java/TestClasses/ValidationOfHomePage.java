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
 

public class ValidationOfHomePage 
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
	
	@Test (priority = 1)
	public void testA() {
		
		homePage.HolidayPackages();
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals("https://www.makemytrip.com/holidays-india/", url);
		soft.assertEquals("Holiday Packages, Indian Holidays, Honeymoon Packages, India Tourism, Holidays India, Vacation Package : MakeMyTrip", title);
		soft.assertAll();
		 	
	}
	
	@Test (priority = 2, timeOut =5000)
	public void testB() {
		
		homePage.Cabs();
		 
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals("https://www.makemytrip.com/cabs/", url);
		soft.assertEquals("Online Cab Booking - Book Outstation Cabs at Lowest Fare @ MakeMyTrip", title);
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
