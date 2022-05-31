package TestClasses;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClasses.HomePage;
import PomClasses.LoginProcess;

public class TestClassLogin31 
{
			public static void main(String[] args) throws InterruptedException 
			{
				 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
					
					WebDriver driver = new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.get("https://www.makemytrip.com/");
					
					LoginProcess loginProcess = new LoginProcess(driver);
					loginProcess.account();
					loginProcess.googleLogin();
					
					ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
					driver.switchTo().window(addr.get(1));
					
					loginProcess.loginProcess();
					
					String url = driver.getCurrentUrl();
					System.out.println(url);
					
					String title = driver.getTitle();
					System.out.println(title);
					
//					HomePage homePage = new HomePage(driver);
//					homePage.Omkar();
					
					if(url.equals("https://accounts.google.com/signin/v2/challenge/pwd?redirect_uri=storagerelay%3A%2F%2Fhttps%2Fwww.makemytrip.com%3Fid%3Dauth854776&response_type=permission%20id_token&scope=email%20profile%20openid&openid.realm&include_granted_scopes=true&client_id=365487944636-q943oq1rje9ugcbscagg2vre5om9maj0.apps.googleusercontent.com&ss_domain=https%3A%2F%2Fwww.makemytrip.com&prompt&fetch_basic_profile=true&gsiwebsdk=2&flowName=GeneralOAuthFlow&cid=1&navigationDirection=forward&TL=AM3QAYZLVNma4CVd0Bp7EXpBDCDCzUu5vQzZRnD5e3EDVRuRNSSjuCmOa9SXf2q9") || title.equals("Sign in – Google accounts"))
					{
						System.out.println("Passed");
					}
					else
					{
						System.out.println("Failed");
					}
					Thread.sleep(3000);
					driver.quit();
					
					
					
			}

}
