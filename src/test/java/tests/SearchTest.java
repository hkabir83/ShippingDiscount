package tests;

import org.testng.annotations.Test;
import utilities.AbstractClass;

public class SearchTest extends AbstractClass{
	
public String modelNumber = "AT082410C";
	
	@Test
	public void searchProduct() {
		
		System.out.println("Searching product with model number :"+modelNumber);
		
		navigateToSearchPage();
		searchPage().enterModelNumberIntoSearchBox(modelNumber);
		searchPage().clickOnTheSearchButton();
		searchPage().verifyModelNumber(modelNumber);
		
	}

}
