package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.SearchPage;

public class AbstractClass {
	
	public static WebDriver driver = null;
	public String baseURL = "https://www.supplyhouse.com/Boiler-Parts-Finder-Tool";
	
	
	@BeforeClass
	public void setUp() {
		
		//For windows 
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		
		//For Mac
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public static WebElement getElement(By locator) {
		
		WebElement element = null;
		try {
			
			element = driver.findElement(locator);
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("No Such Element" + locator);
		}
		return element;
	}
	
	public static List<WebElement> getElements(By locator) {
		
		List<WebElement> element = null;
		try {
			
			element =  driver.findElements(locator);
			
		}catch(NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("No Such Element" + locator);
		}
		return element;
	}
	

	public void navigateToSearchPage() {
		driver.get(baseURL);

	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown(){
		driver.quit();
	}
	
	public SearchPage searchPage() {
		return new SearchPage();
	}
	
	public String[][] getDataFromExcelSheet() {

		String[][] excelData = null;
		Workbook workbook;
		String fileName = System.getProperty("user.dir") + "/testdata/model.xlsx";

		try {

			FileInputStream file = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("ModelNumbers");

			int noOfRows = sheet.getLastRowNum();
			int noOfCols = sheet.getRow(noOfRows).getLastCellNum();
		
			excelData = new String[noOfRows][noOfCols];

			for (int i = 1; i <= noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					excelData[i - 1][j] = sheet.getRow(i).getCell(j)
							.getStringCellValue();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("IO Exception");
		}

		return excelData;
	}


}
