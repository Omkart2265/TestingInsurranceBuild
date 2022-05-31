package Test2;

 
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazon {

	@BeforeSuite 
	public void beforeSuite() {
		System.out.println("Before Suite 11");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test 22 ");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class 33");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Class 44");
	}
	
	@Test (priority = 2)
	public void testA() {
		System.out.println("test A");
	}
	
	@Test (priority = 2)
	public void testB() throws InterruptedException {
		System.out.println("test B");
//		Thread.sleep(3000);
//		System.out.println("Omkya");
	}
	
	@Test (priority = 1)
	public void testC() {
		System.out.println("test C");
	}
	
	@Test  
	public void testD() {
		System.out.println("test D");
	 
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Thor Love and Thunder");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Docter  Strange multiverse of madness And WandaVision");
	}
	
//	@AfterTest
//	public void afterTest() {
//		System.out.println("Hulkkkk - The bruce banner");
//	}
//	
//	@AfterSuite 
//	public void afterSuite() {
//		System.out.println("After Suite 11");
//	}
	
	
	
	
	
	


}
