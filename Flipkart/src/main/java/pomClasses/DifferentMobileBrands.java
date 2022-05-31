package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentMobileBrands {
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[1]")
	private WebElement Realmi;	

	@FindBy (xpath = "(//img[@alt='Shop Now'])[2]")
	private WebElement Poco;
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[3]")
	private WebElement Narzo;
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[4]")
	private WebElement Oppo;
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[5]")
	private WebElement Infinix;
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[6]")
	private WebElement Xiomi;
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[7]")
	private WebElement Iphone;
	
	@FindBy (xpath = "(//img[@alt='Shop Now'])[8]")
	private WebElement Samsung;
	
	public DifferentMobileBrands(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Realmi() {
		Realmi.click();
	}
	
	public void Poco() {
		Poco.click();
	}
	
	public void Narzo() {
		Narzo.click();
	}
	
	public void Oppo() {
		Oppo.click();
	}
	
	public void Infinix() {
		Infinix.click();
	}
	
	public void Xiomi() {
		Xiomi.click();
	}
	
	public void Iphone() {
		Iphone.click();
	}
	
	public void Samsung() {
		Samsung.click();
	}

}
