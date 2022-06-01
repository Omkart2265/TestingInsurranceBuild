package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccountPage {
	
	@FindBy (xpath = "(//input[@type='text'])[2]")
	private WebElement fristName;
	
	@FindBy (xpath = "(//input[@type='text'])[3]")
	private WebElement surname;
	
	@FindBy (xpath = "(//input[@type='text'])[4]")
	private WebElement email;
	
	@FindBy (xpath = "(//input[@class='inputtext _58mg _5dba _2ph-'])[4]")
	private WebElement reEnterEmail;
	
	@FindBy (xpath = "(//input[@class='inputtext _58mg _5dba _2ph-'])[5]")
	private WebElement password;
	
	@FindBy (xpath = "//select[@id='day']")
	private WebElement day;
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement month;
	
	@FindBy (xpath = "//select[@id='year']")
	private WebElement year;
	
	@FindBy (xpath = "( //input[@type='radio'])[2]")
	private WebElement male;
	
	@FindBy (xpath = "( //input[@type='radio'])[1]")
	private WebElement Female;
	
	@FindBy (xpath = "( //input[@type='radio'])[3]")
	private WebElement custom;
	
	@FindBy (xpath = " //select[@aria-label='Select your pronoun']")
	private WebElement selectYOurPronoun;
	
	@FindBy (xpath = "(//input[@type='text'])[7]")
	private WebElement OptionalGender;
	
	@FindBy (xpath = "(//button[@type='submit'])[2]")
	private WebElement signInButton;
	
	@FindBy (xpath = "//img[@class='_8idr img']")
	private WebElement cancelButton;
	
	 
	
	public CreateNewAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void fristName() throws InterruptedException {
		fristName.sendKeys("omkar");
		//Thread.sleep(2000);
	}
	
	public void surname() throws InterruptedException {
		surname.sendKeys("Thorat");
	//	Thread.sleep(2000);
	}
	
	public void email() {
		email.sendKeys("omkart2265@gmail.com");
	}
	
	public void reEnterEmail() {
		reEnterEmail.sendKeys("omkart2265@gmail.com") ;
	}
	
	public void password() {
		password.sendKeys("Omkart@456") ;
	}
	
	public void day() throws InterruptedException {
		Select s = new Select(day);
		 s.selectByValue("24");
		Thread.sleep(500);
	}
	
	public void month() throws InterruptedException {
		Select s = new Select(month);
		s.selectByVisibleText("Nov");
		Thread.sleep(500);
	}
	
	public void year() {
		Select s = new Select(year);
		s.selectByIndex(24);
	}
	
	public void male() {
		male.click();
	}
	
	public void female() {
		Female.click();
	}
	
	public void custom() {
		custom.click();
	}
	
	public void selectYOurPronoun() {
		selectYOurPronoun.click() ;
	}
	
	public void optionalGender() {
		OptionalGender.click() ;
	}
	
	public void signInButton() {
		signInButton.click();
	}
	
	public void cancelButton() {
		cancelButton.click();
	}
	
	public boolean maleButtonisSelected() {
		 boolean result = male.isSelected();
		return result;
	}
	
	public boolean femaleButtonSelected() {
		boolean result = Female.isSelected();
		return result;
		 
	}
	
	public boolean customButtonSelected() {
		boolean result = custom.isSelected();
		return result;
		 
	}
	
	public boolean optionalGenderIsDisplayed() {
		boolean result = OptionalGender.isDisplayed();
		return result;
		 
	}
	
	public boolean signInButtonIsEnabled() {
		boolean result = signInButton.isEnabled();
		return result;
		 
	}

}
