package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PomClasses.ApplicationHeader;
import PomClasses.CreateNewAccountPage;
import PomClasses.LoginPage;

public class VerifyCreateNewAccountPage {
	
	
	WebDriver driver;
	ApplicationHeader applicationHeader;
 
	LoginPage loginPage;
	CreateNewAccountPage createNewAccountPage;
	
	
 
	
	@BeforeClass
	public void lounchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		createNewAccountPage = new CreateNewAccountPage(driver);
	}
	
	@BeforeMethod
	public void loginTOBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.facebook.com/");
	//	driver.manage().window().maximize();
		Thread.sleep(1000);
		loginPage.createNewAccount();
		Thread.sleep(1500);
		
		createNewAccountPage.fristName();
		createNewAccountPage.surname();
		createNewAccountPage.email();
		createNewAccountPage.reEnterEmail();
		createNewAccountPage.password();
		createNewAccountPage.day();
		createNewAccountPage.month();
		createNewAccountPage.year();
	
	}
	
	@Test
	public void testA() throws InterruptedException {
		
		createNewAccountPage.female();
	 
		 boolean result = createNewAccountPage.femaleButtonSelected();
		 
		 if(result)
		 {
			 System.out.println("Passed");
		 }
		 else
		 {
			 System.out.println("failed");
			 
		 } 
	}
	
	@Test
	public void testB() throws InterruptedException {
		
		createNewAccountPage.male();
		
		boolean result = createNewAccountPage.maleButtonisSelected();
		 
				if(result)
				{
					System.out.println("Passed");
				}
				else
				{
					System.out.println("failed");
			 
				}
	}
	
	@Test
	public void testc() throws InterruptedException {
		
		createNewAccountPage.custom();
		
		boolean result = createNewAccountPage.customButtonSelected();
		 
		if(result)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("failed");
	 
		}
		
	}
	
	@Test
	public void testd() throws InterruptedException {
		createNewAccountPage.custom();
		Thread.sleep(1000);
		createNewAccountPage.optionalGender();
		
		boolean result = createNewAccountPage.optionalGenderIsDisplayed();
		 
		if(result)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("failed");
	 
		}
		
	}
	
	@Test
	public void teste() throws InterruptedException {
		
		createNewAccountPage.signInButton();
		
		boolean result = createNewAccountPage.signInButtonIsEnabled();
		 
		if(result)
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("failed");
	 
		}
		
	}
	
	
	
	@AfterMethod
	public void logout() throws InterruptedException {
		
		createNewAccountPage.cancelButton();
	}
	
	@AfterClass
	public void clearObjects() {
		 
	 driver.close();
	}

}
