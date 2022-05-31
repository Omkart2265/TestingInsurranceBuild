package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import pomClasses.ApplicationHeader;
import pomClasses.LoginPage;
import utils.Utility;

public class TestClass1
{
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException   
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//TestCase 1
		
		driver.get("https://www.flipkart.com/account/login");
		//driver.manage().window().maximize();
		
		LoginPage loginPage = new LoginPage(driver);
		
		
		String data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet("omi", 3, 3);
		loginPage.password(data);
		
		
		loginPage.SubmitButton();
		
		ApplicationHeader applicationHeader = new ApplicationHeader(driver);
		applicationHeader.mobiles();
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		if(url.equals("https://seller.flipkart.com/sell-online/?utm_source=fkwebsite&utm_medium=websitedirect")&&title.equals("Sell Online on Flipkart | Grow your business with the leader in Indian e-commerce"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
			
		}
		//driver.navigate().back();
		
	//	Actions act = new Actions(driver);
	//	applicationHeader.Omkar();
//		Actions act = new Actions(driver);
//		act.moveToElement(driver);
//		applicationHeader.click();
//		applicationHeader.Logout();
		
		
	//	applicationHeader.Omkar();
	//	applicationHeader.Logout();
			
		//	Test case 2
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/account/login");
		
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		
		 data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.sendUserName(data);
		
		data = Utility.getDataFromExcelsheet("omi", 3, 2);
		loginPage.password(data);
		
		loginPage.SubmitButton();
		
		applicationHeader = new ApplicationHeader(driver);
		applicationHeader.BecomeABestSeller();
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		title = driver.getTitle();
		System.out.println(title);
		
		if(url.equals("https://seller.flipkart.com/sell-online/?utm_source=fkwebsite&utm_medium=websitedirect")&&title.equals("Sell Online on Flipkart | Grow your business with the leader in Indian e-commerce"))
		{
			System.out.println("Passed");
		}
		else
		{
			System.out.println("Failed");
			
		}
		driver.navigate().back();
		 
		
	}

}
