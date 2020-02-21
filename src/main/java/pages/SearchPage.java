package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import utilities.BasePage;

public class SearchPage extends BasePage{

	public String searchTextBox = "//input[@id='model-number']";
	public String searchButton = "//button[contains(@class,'search-btn')]";
	public String searchProduct = "//a[@class='product-name']";
	public String searchProductSku = "//div[@class='desc-sku']";
	
	public void enterModelNumberIntoSearchBox(String modelNumber) {
		
		enterDataIntoTextField(By.xpath(searchTextBox), modelNumber);
	}
	
	public void clickOnTheSearchButton() {
		
		clickButton(By.xpath(searchButton));
	}
	
	public void verifyModelNumber(String modelNumber) {

		String displayModelNumber = "";
		
		boolean isElementPresent = isElementPresent(By.xpath(searchProductSku));
		
		if(isElementPresent) {
			String sku = getDisplayText(By.xpath(searchProductSku));
			displayModelNumber = sku.split(":")[1].trim();
		}
		
		if(isElementPresent && displayModelNumber.equals(modelNumber)) {
			System.out.println("Search Result displays model number entered :"+modelNumber);
		}else {
			System.out.println("Could not find any matches for "+modelNumber);
		}
		
		Assert.assertTrue(displayModelNumber.equals(modelNumber));
	}
	
}
