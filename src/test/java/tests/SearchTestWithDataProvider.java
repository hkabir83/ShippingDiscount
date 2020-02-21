package tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utilities.AbstractClass;

public class SearchTestWithDataProvider extends AbstractClass {

	public String modelNumber = "AT082410C";

	@Test(dataProvider = "modelNumber")
	public void searchProduct(String modelNumber) {

		System.out.println("Searching product with model number >> :" + modelNumber);
		navigateToSearchPage();
		searchPage().enterModelNumberIntoSearchBox(modelNumber);
		searchPage().clickOnTheSearchButton();
		searchPage().verifyModelNumber(modelNumber);

	}

	@DataProvider(name = "modelNumber")
	public Object[] getData() {

		Object[] data = new Object[2];

		data[0] = "AT082410C";
		data[1] = "AT122610C";

		return data;

	}

}
