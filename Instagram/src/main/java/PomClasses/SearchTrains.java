package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchTrains {
	
	@FindBy (xpath = "//input[@id='fromCity']")
	private WebElement clickFomCity;
	
	@FindBy (xpath = "//input[@placeholder='From']")
	private WebElement fromCity;
	
	@FindBy (xpath = "(//span[@class='sr_city blackText'])[1]")
	private WebElement clickCity;
	
	@FindBy (xpath = "//input[@id='toCity']")
	private WebElement ToCity;
	
	@FindBy (xpath = "(//span[@class='sr_city blackText'])[1]")
	private WebElement clickToCity;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement TravelDate;
	
	@FindBy (xpath = "(//div[text()='29'])[1]")
	private WebElement SelectDate;
	
	@FindBy (xpath = "//span[@data-cy='class']")
	private WebElement ClassesClick;
	
	@FindBy (xpath = "//li[text()='First Class']")
	private WebElement SelectClass;
	
	@FindBy (xpath = "//a[text()='Search']")
	private WebElement search;
	
	@FindBy (xpath = "//img[@class='primoCloseIcon']")
	private WebElement cancelTab;
	
	public SearchTrains(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickFormCity() {
		clickFomCity.click();
	}
	
	public void fromCity() throws InterruptedException   {
		Thread.sleep(2000);
		fromCity.sendKeys("Pune");
	}
	
	public void clickCity() throws InterruptedException {
		Thread.sleep(2000);
		clickCity.click();
	}
	public void ToCity() throws InterruptedException {
		Thread.sleep(2000);
		ToCity.sendKeys("Sangamner");
	}
	
	public void clickToCity() throws InterruptedException {
		Thread.sleep(2000);
		clickToCity.click();
	}
	
	public void TravelDate() {
		TravelDate.click() ;
	}
	
	public void search() {
		search.click();
	}
	
	public void cancelTab() {
		cancelTab.click();
	}
	
	public void searchTrains() throws InterruptedException {
		TravelDate.click();
		Thread.sleep(1000);
		SelectDate.click();
		Thread.sleep(1000);
		ClassesClick.click();
		Thread.sleep(1000);
		SelectClass.click();
		Thread.sleep(1000);
		clickFomCity.click();
		Thread.sleep(1000);
		fromCity.sendKeys("Pune");
		Thread.sleep(1000);
	//	ToCity.click();
		clickCity.click();
		Thread.sleep(2000);
		ToCity.sendKeys("New Delhi");
		Thread.sleep(1000);
		clickToCity.click();
		//Date.click() ;
		Thread.sleep(1000);
		search.click();
		//cancelTab.click();
	}

}
