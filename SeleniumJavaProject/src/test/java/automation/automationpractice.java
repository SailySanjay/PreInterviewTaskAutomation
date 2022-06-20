package automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class automationpractice {
Actions action;
	
	public void performMouseOver(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();		
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void clear(WebElement element) {
		element.clear();
	}
	
	public void setText(String text, WebElement element) {
		element.sendKeys(text);		
	}
	
	public void selectByVisibleText(WebElement selectSize, String text) {
		Select s = new Select(selectSize);
		s.selectByVisibleText(text);
	}
	
	public void btnClkJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);		
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public boolean validateText(WebDriver driver, WebElement element, String requiredText) {
		String actualText = element.getText();
		if(actualText.equals(requiredText)) {
			return true;
		}		
		return false;
	}

}
