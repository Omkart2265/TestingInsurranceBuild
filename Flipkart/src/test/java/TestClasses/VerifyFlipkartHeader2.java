package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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
import pomClasses.ApplicationHeader;
import pomClasses.LoginPage;
import utils.Utility;

public class VerifyFlipkartHeader2 
{

	WebDriver driver;
	ApplicationHeader applicationHeader;
	LoginPage loginPage;
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
		loginPage = new LoginPage(driver);
		applicationHeader = new ApplicationHeader(driver);
		
		
	}
	
	@BeforeMethod
	public void loginTOBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.flipkart.com/account/login");
		driver.manage().window().maximize();
		soft = new SoftAssert();
		
		String data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet("omi", 3, 3);
		loginPage.password(data);
		 
		
		loginPage.SubmitButton();
		
	}
	
	@Test (priority = 1)
	public void testA() throws InterruptedException {
		applicationHeader.TopOffer();
		Thread.sleep(1500);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals("https://www.flipkart.com/offers-store?otracker=nmenu_offer-zone&fm=neo%2Fmerchandising&iid=M_e2765d08-6e8e-411c-afe8-ee954bdf5d82_2_372UD5BXDFYS_MC.G6ZC4RAJ9OHU&otracker=hp_rich_navigation_1_2.navigationCard.RICH_NAVIGATION_Top%2BOffers_G6ZC4RAJ9OHU&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_1_L0_view-all&cid=G6ZC4RAJ9OHU", url);
		soft.assertEquals("Flipkart Offers & Deals of the Day - Get Best Discounts on Mobiles, Electronics, Fashion & Home etc.\r\n", title);
		soft.assertAll();
	 
	}
	
	@Test (priority = 2)
	public void testB() throws InterruptedException {
		
		applicationHeader.BecomeABestSeller();
		Thread.sleep(1500);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		soft.assertEquals("https://seller.flipkart.com/sell-online/?utm_source=fkwebsite&utm_medium=websitedirect", url);
		soft.assertEquals("Sell Online on Flipkart | Grow your business with the leader in Indian e-commerce", title);
		soft.assertAll();
		 
		driver.navigate().back();
		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(2000);
		applicationHeader.Logout();
	}
	
	@AfterClass
	public void clearObjects() {
		  
		loginPage = null;
		applicationHeader = null;
		soft = null;
	}
	
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver = null;
		System.gc();
	}
}
