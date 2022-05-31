package TestClasses;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
 
import PomClasses.LoginProcess;

public class ValidationOfLoginProcess 
{
	WebDriver driver;
	SoftAssert soft;
	LoginProcess loginProcess;
	
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
		loginProcess = new LoginProcess(driver);
		soft = new SoftAssert();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void loginProcess() throws InterruptedException {
				
		loginProcess.loginProcess();
		 
	}
	
	@Test
	public void VerifyPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		String title = driver.getTitle();
		System.out.println(title);
		
 
		soft.assertEquals("https://accounts.google.com/signin/v2/challenge/pwd?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fwww.makemytrip.com%3Fid%3Dauth949033&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&include_granted_scopes=true&client_id=365487944636-q943oq1rje9ugcbscagg2vre5om9maj0.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fwww.makemytrip.com&prompt&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow&cid=1&navigationDirection=forward&TL=AM3QAYaHwMUp4zPyvDiM4qbdId1Lpk9hh7IFegIg2h9e9pQAvgkGiWdERIZud_gc\r\n"
				+ "", url);
		soft.assertEquals("Sign in – Google accounts", title);
		soft.assertAll();
		
	}
	
//	@Test
//	public void testB() {
//		System.out.println("test B");
//	}
//	
//	@AfterMethod
//	public void logout() throws InterruptedException {
//		 
//		HomePage homepage = new HomePage(driver);
//	//	homepage.omkar();
//		 
//		homepage.profile();
//	//	homepage.logout();
//	//	homepage.logouts();
////		WebDriverWait wait = new WebDriverWait(driver,4);
////		wait.until(ExpectedConditions.visibilityOf((WebElement) homepage));
////		homepage.logout();
//	}
	
	@AfterClass
	public void clearObjects() {
		 
		loginProcess = null;
		soft = null;
	}
	
	
	@AfterTest
	public void closedBrowser() {
		driver.quit();
		driver = null;
		System.gc();
	}
}
