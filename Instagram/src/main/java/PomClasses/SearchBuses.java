package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBuses 
{
	@FindBy (xpath = "//input[@id='fromCity']")
	private WebElement clickFomCity;
	
	@FindBy (xpath = "//input[@placeholder='From']")
	private WebElement fromCity;
	
	@FindBy (xpath = "(//span[@class='sr_city blackText'])[1]")
	private WebElement clickCity;
	
	@FindBy (xpath = "//input[@aria-autocomplete='list']")
	private WebElement ToCity;
	
	@FindBy (xpath = "(//span[@class='sr_city blackText'])[1]")
	private WebElement clickToCity;
	
	@FindBy (xpath = "//div[@aria-selected='true']")
	private WebElement Date;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement search;
	
	@FindBy (xpath = "//img[@class='primoCloseIcon']")
	private WebElement cancelTab;
	
	public SearchBuses(WebDriver driver)
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
	
	public void Date() {
		Date.click() ;
	}
	
	public void search() {
		search.click();
	}
	
	public void cancelTab() {
		cancelTab.click();
	}
	
	public void searchBus() throws InterruptedException {
		clickFomCity.click();
		Thread.sleep(1000);
		fromCity.sendKeys("Pune");
		Thread.sleep(1000);
		clickCity.click();
		Thread.sleep(1000);
		ToCity.sendKeys("Sangamner");
		Thread.sleep(1000);
		clickToCity.click();
		Date.click() ;
		search.click();
		cancelTab.click();
	}
}
