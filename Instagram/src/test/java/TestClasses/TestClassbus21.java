package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClasses.HomePage;
import PomClasses.SearchBuses;

public class TestClassbus21 
{
		public static void main(String[] args) throws InterruptedException 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			
			driver.manage().window().maximize();
			
			HomePage homepage = new HomePage(driver);
			homepage.Buses();
			
			SearchBuses searchBuses = new SearchBuses(driver);
			searchBuses.clickFormCity();		
			searchBuses.fromCity();
			searchBuses.clickCity();
			searchBuses.ToCity();
			searchBuses.clickToCity();
			searchBuses.Date();
			searchBuses.search();
			searchBuses.cancelTab(); 
			
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			String Title = driver.getTitle();
			System.out.println(Title);
			
			if(url.equals("https://www.makemytrip.com/bus/search/Pune/Sangamner/20-05-2022?from_code=MMTCC1744&to_code=MMTCC1797")&&Title.equals("MakeMyTrip Bus"))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
			driver.close();
		}
}
