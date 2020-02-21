package tests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.AbstractClass;

public class SearchTestWithTestNGParameter extends AbstractClass {

	public String modelNumber = "AT082410C";

	@Test
	@Parameters("modelNumber")
	public void searchProduct(@Optional("AT082410C") String modelNumber) {

		System.out.println("Searching product with model number > :" + modelNumber);

		navigateToSearchPage();
		searchPage().enterModelNumberIntoSearchBox(modelNumber);
		searchPage().clickOnTheSearchButton();
		searchPage().verifyModelNumber(modelNumber);

	}
}
