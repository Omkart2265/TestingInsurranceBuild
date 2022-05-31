package TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClasses.HomePage;

public class TestClass11 
{
	 public static void main(String[] args) throws InterruptedException 
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.makemytrip.com/");
			
			HomePage homepage = new HomePage(driver);
			homepage.Buses();
			
			String url = driver.getCurrentUrl();
			System.out.println(url);
			
			String Title = driver.getTitle();
			System.out.println(Title);
			
			if(url.equals("https://www.makemytrip.com/bus-tickets/")&&Title.equals("Online Bus Ticket Booking, Book Confirmed Reservation Tickets @ MakeMyTrip"))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
			driver.close();
			
			//2nd TestCase
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriver driver2 = new ChromeDriver();
		//	Thread.sleep(5000);
			driver2.get("https://www.makemytrip.com/");
			
			homepage = new HomePage(driver2);
			homepage.Hotels();
			
			url = driver2.getCurrentUrl();
			System.out.println(url);
			
			Title = driver2.getTitle();
			System.out.println(Title);
			
			if(url.equals("https://www.makemytrip.com/hotels/")&&Title.equals("MakeMyTrip.com: Save upto 60% on Hotel Booking 4,442,00+ Hotels Worldwide"))
			{
				System.out.println("Passed");
			}
			else
			{
				System.out.println("Failed");
			}
			
			driver2.close();
			
	 }

}
