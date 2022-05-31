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
import pomClasses.AppleMobiles;
import pomClasses.ApplicationHeader;
import pomClasses.Buynow;
import pomClasses.DifferentMobileBrands;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import utils.Utility;

public class ValidationOfMobileBook {
	
	WebDriver driver;
	ApplicationHeader applicationHeader;
	DifferentMobileBrands differentMobileBrands;
	AppleMobiles appleMobiles;
	Buynow buynow;
	HomePage homePage;
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
		differentMobileBrands = new DifferentMobileBrands(driver);
		appleMobiles = new AppleMobiles(driver);
		buynow = new Buynow(driver);
		homePage =new HomePage(driver);
		
		
	}
	
	@BeforeMethod
	public void loginTOBrowser() throws InterruptedException, EncryptedDocumentException, IOException {
		soft = new SoftAssert();
		driver.get("https://www.flipkart.com/account/login");
		driver.manage().window().maximize(); 
		
		
		String data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.password(data);
		
		
		loginPage.SubmitButton();
			
	}
	
	@Test
	public void testA() throws InterruptedException, IOException {
		applicationHeader.mobiles();
		Thread.sleep(1500);
		differentMobileBrands.Iphone();
		Thread.sleep(1500);
		appleMobiles.AppleIphoneWhite();
		Thread.sleep(3000);
		buynow.buynow();
		Thread.sleep(1500);
		homePage.screenshot();
		driver.navigate().back();
		Thread.sleep(1500);
		 
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(3000);
		
		soft.assertEquals("https://www.flipkart.com/apple-iphone-11-white-64-gb/p/itmfc6a7091eb20b?pid=MOBFWQ6BVWVEH3XE&lid=LSTMOBFWQ6BVWVEH3XEB1SFMZ&marketplace=FLIPKART&store=tyy%2F4io&srno=b_1_6&otracker=clp_metro_expandable_7_3.metroExpandable.METRO_EXPANDABLE_Shop%2BNow_mobile-phones-store_92RED14GXPXF_wp2&fm=neo%2Fmerchandising&iid=fbe53a59-4bca-4612-906a-6e83665e4996.MOBFWQ6BVWVEH3XE.SEARCH&ppt=clp&ppn=mobile-phones-store&ssid=b98mbdhja80000001653240836878", url);
		soft.assertEquals("Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order", title);
		soft.assertAll();
		
 
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		
		applicationHeader.Logout(); 
	}
	
	@AfterClass
	public void clearObjects() {
		
		loginPage = null;
		applicationHeader = null;
		appleMobiles = null;
		differentMobileBrands = null;
		buynow =null;
		homePage =null;
		soft = null;
	}
	
	
	@AfterTest
	public void closedBrowser() {
		driver.close();
		driver = null;
		System.gc();
	}

}

