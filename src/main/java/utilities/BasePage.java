package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage extends AbstractClass{
	
	public void clickButton(By locator){
		try {
			WebElement ele = getElement(locator);
			ele.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	
	public void enterDataIntoTextField(By locator,String value){
		
		try {
			WebElement ele = getElement(locator);
			ele.sendKeys(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}				
		
	}
	
	public boolean isElementPresent(By locator) {
		
		boolean isElementPresent = false;
		try {
			List<WebElement> ele = getElements(locator);
			if(ele.size() > 0) {
				isElementPresent = true;
			}else {
				isElementPresent = false;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
		
		return isElementPresent;
	}
	
	public String getDisplayText(By locator){
		
		String text = "";
		try{
			WebElement ele = getElement(locator);
			text = ele.getText();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return text;
	}

}
