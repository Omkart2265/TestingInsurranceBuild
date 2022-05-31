package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

public class VerifyFlipkartHeader {
	
	WebDriver driver;
	ApplicationHeader applicationHeader;
//	SoftAssert soft;
	LoginPage loginPage;
	
	
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
	//	soft = new SoftAssert();
		
	}
	
	@BeforeMethod
	public void loginTOBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.flipkart.com/account/login");
		driver.manage().window().maximize();
		
		String data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet("omi", 3, 3);
		loginPage.password(data);
		loginPage.SubmitButton();
			
	}
	
	@Test
	public void testA() throws InterruptedException {
		applicationHeader.mobiles();
		Thread.sleep(1500);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("https://www.flipkart.com/mobile-phones-store?fm=neo%2Fmerchandising&iid=M_acc0c5e1-88b5-454c-9815-1adfd86481ef_2_372UD5BXDFYS_MC.ZRQ4DKH28K8J&otracker=hp_rich_navigation_3_2.navigationCard.RICH_NAVIGATION_Mobiles_ZRQ4DKH28K8J&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_3_L0_view-all&cid=ZRQ4DKH28K8J", url);
		Assert.assertEquals("Mobile Phones Online at Best Prices in India", title);
	//	soft.assertAll();
		
 
	}
	
	@Test
	public void testB() throws InterruptedException {
		
		applicationHeader.Grocery();
		Thread.sleep(1500);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_ba0b9f69-75ba-4fc0-91c6-0ad74033c279_2_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker=hp_rich_navigation_2_2.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=CBUR1Q46W5F1", url);
		Assert.assertEquals("Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com", title);
	//	soft.assertAll();
		
 	
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		
		applicationHeader.Logout(); 
	}
	
	@AfterClass
	public void clearObjects() {
		 
		loginPage = null;
		applicationHeader = null;
	//	soft = null;
	}
	
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver = null;
		System.gc();
	}

}
