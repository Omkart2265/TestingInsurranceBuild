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

import Browsers.Base;
import PomClasses.ApplicationHeader;
import PomClasses.LoginPage;

 

public class VerifyFacebookHeader {
	
	
	WebDriver driver;
	ApplicationHeader applicationHeader;
 
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
		
		 
		applicationHeader = new ApplicationHeader(driver);
		loginPage = new LoginPage(driver);
	}
	
	@BeforeMethod
	public void loginTOBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(1500);
		loginPage.sendUserName();
		loginPage.password();
		loginPage.loginButton();
		Thread.sleep(1500);
	}
	
	@Test
	public void testA() throws InterruptedException {
		applicationHeader.friends();
		Thread.sleep(1500);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("https://www.facebook.com/friends", url);
		Assert.assertEquals("(20+) Friends | Facebook", title);
	//	soft.assertAll();
		
 
	}
	
	@Test
	public void testB() throws InterruptedException {
		
		applicationHeader.homepage();
		Thread.sleep(1500);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals("https://www.facebook.com/", url);
		Assert.assertEquals("(20+) Facebook", title);
	//	soft.assertAll();
		
 	
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		
		applicationHeader.logoutFromApplication(); 
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void clearObjects() {
		applicationHeader = null;
		loginPage=null;
	}
	
// 	@AfterTest
// 	public void closedBrowser() {
// 		driver.close();
// 		driver = null;
// 		System.gc();
// 	}
	
	
 
	

}
