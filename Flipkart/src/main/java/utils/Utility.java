package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static void captureScreenshot(WebDriver driver, int testID) throws IOException, InterruptedException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String d1 = new SimpleDateFormat("yyyy_mm_dd__hh_mm_ss").format(new Date());
		File dest = new File("test-output\\screenshot\\Test-"+testID+d1+"jpeg");
		FileHandler.copy(source, dest);
		 
	}
	
	public static String getDataFromExcelsheet(String sheet ,int row,int column) throws EncryptedDocumentException, IOException 
	{
		String data;
		 
		
		String path = "src\\main\\resources\\TestData\\Book2.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Workbook book = WorkbookFactory.create(file);
		 
		
		 try {
				data = book.getSheet(sheet).getRow(row).getCell(column).getStringCellValue(); 
			}
			catch(IllegalStateException e)
			{
			double value = book.getSheet(sheet).getRow(row).getCell(column).getNumericCellValue();  
			data = Double.toString(value);
			}
		 
		 return data;
	 
	}

}
