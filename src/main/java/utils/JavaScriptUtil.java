package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 

public class JavaScriptUtil {

	WebDriver driver;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
	} 
	  

	public void scrollDown(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollPageUp() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	 
	 
}
