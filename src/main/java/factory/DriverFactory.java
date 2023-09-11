package factory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new FirefoxDriver());

		}

		else {

			System.out.println("please select the browser correctly");
		}

		 
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 
		

		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
