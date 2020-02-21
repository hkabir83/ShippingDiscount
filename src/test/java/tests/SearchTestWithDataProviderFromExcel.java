package tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import utilities.AbstractClass;

public class SearchTestWithDataProviderFromExcel extends AbstractClass {

	public String modelNumber = "AT082410C";

	@Test(dataProvider = "getExcelData")
	public void searchProduct(String modelNumber) {

		System.out.println("Searching product with model number ::" + modelNumber);
		navigateToSearchPage();
		searchPage().enterModelNumberIntoSearchBox(modelNumber);
		searchPage().clickOnTheSearchButton();
		searchPage().verifyModelNumber(modelNumber);

	}

	@DataProvider
	public Object[][] getExcelData() {

		Object[][] data = getDataFromExcelSheet();

		return data;

	}

}
