package utils;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;
	JavaScriptUtil jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver);
	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> elementsList = driver.findElements(locator);
		return elementsList;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {

			element = driver.findElement(locator);

		} catch (Exception e) {

		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		waitForElementPresent(locator, 10);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		waitForElementToBeClickable(locator, 200000);
		getElement(locator).click();
	}

	public void doClick(WebElement element) {

		element.click();
	}

	public WebElement waitForElementPresent(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;
	}

	public WebElement waitForElementToBeClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	 

}
