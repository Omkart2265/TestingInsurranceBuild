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
import PomClasses.SearchBuses;
import PomClasses.SearchTrains;

public class ValidationOfBUses 
{
	 
	WebDriver driver;
	SoftAssert soft;
	HomePage homePage;
	SearchBuses searchBuses;

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
		searchBuses = new SearchBuses(driver);
		soft = new SoftAssert();
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		homePage.Buses(); 
		searchBuses.searchBus();	
		 
	}
	
	@Test
	public void VerifyPageUrlAndTitle() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals("https://www.makemytrip.com/bus/search/Pune/Sangamner/26-05-2022?from_code=MMTCC1744&to_code=MMTCC1797", url);
		soft.assertEquals("MakeMyTrip Bus", title);
		soft.assertAll();
		
	}
	
//	@Test
//	public void testB() {
//		System.out.println("test B");
//	}
//	
	@AfterMethod
	public void logout() {
		 driver.navigate().back();
	}
	
	@AfterClass
	public void clearObjects() {
		 
		homePage = null;
		soft = null;
		searchBuses =null;
	}
	
	
	@AfterTest
	public void closedBrowser() {
		driver.quit();
		driver = null;
		System.gc();
	}
}
