package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mobiles {
	
	@FindBy (xpath = "//div[contains(text(),'Sky Blue, 64 GB')]")
	private WebElement mobile1;
	
	@FindBy (xpath = "(//div[text()='vivo T1 5G (Starlight Black, 128 GB)'])[1]")
	private WebElement mobile2;
	
	@FindBy (xpath = "//div[text()='SAMSUNG Galaxy F22 (Denim Blue, 64 GB)']")
	private WebElement mobile3;
	
	@FindBy (xpath = "(//div[text()='vivo T1 5G (Starlight Black, 128 GB)'])[2]")
	private WebElement mobile4;
	
	
	public Mobiles(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void skyblue() {
		mobile1.click();
	}
	
	public void vivoT15GBlack() {
		mobile2.click();
	}
	
	public void SAMSUNGGalaxyF22() {
		mobile3.click() ;
	}
	
	public void vivoT15G() {
		mobile4.click() ;
	}
	
	//or
	
	public void mobiles() {
		mobile1.click();
		mobile2.click();
		mobile3.click();
		mobile4.click();
	}
	
	

}
