package objectPages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ElementUtil;
import utils.JavaScriptUtil;

public class SearchPage  {
	private WebDriver driver;  
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	static final Logger logger = LogManager.getLogger(SearchPage.class.getName());
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(this.driver);
		javaScriptUtil =new JavaScriptUtil(this.driver);
	}
	 
	
	
	//WebElements
	
	private By acceptCookies = By.xpath("//input[@id='sp-cc-accept']");
	private By leftMenuAll = By.xpath("//span[@class='hm-icon-label']");
	private By leftMenuElecronicsAndComputer =By.xpath("//div[normalize-space()='Electronics & Computers']");
	private By leftMenuPhonesAndAccessories =By.linkText("Phones & Accessories");
	private By mobilePhones =By.xpath("//a[@title='Mobile Phones']//div[@class='a-section octopus-pc-category-card-v2-shield']");
	private By cameraResolution = By.linkText("20 MP & above") ;
	private By modelYearCheckBox = By.xpath("//li[@id='p_n_feature_thirteen_browse-bin/12421314031']//input[@type='checkbox']");
	private By modelYearLink = By.linkText("2023"); 
	private By minPriceTextBox = By.xpath("//input[@id='low-price']");
	private By maxPriceTextBox = By.xpath("//input[@id='high-price']") ; 
	private By priceButton =By.xpath("//input[@class='a-button-input']") ;
	 
	
	public void AcceptCookies()
	{
		
		elementUtil.doClick(acceptCookies);
		 
		
	}
	
	
	
	
	public void NavigateToDesiredOption()
	{
		elementUtil.doClick(leftMenuAll);  
		logger.info("Successfully clicked on left menu all ");
		WebElement leftMenuEleAndCom = elementUtil.waitForElementToBeClickable(leftMenuElecronicsAndComputer, 3000);		  
		javaScriptUtil.scrollDown(leftMenuEleAndCom);
		leftMenuEleAndCom.click();
		logger.info("Successfully clicked on electronics and telecommunication under all menu ");
		WebElement element = elementUtil.waitForElementToBeClickable(leftMenuPhonesAndAccessories, 3000);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		logger.info("Successfully clicked on phones and accessories under electronics and telecommunication menu ");
		
		
	}
	
	public void MobilePhoneOption()
	{elementUtil.doClick(mobilePhones);
	logger.info("Successfully clicked mobile phones");
	}  
	
	public void CameraResolutionFilter()
	{WebElement camResolution = elementUtil.waitForElementToBeClickable(cameraResolution, 3000); 
	javaScriptUtil.scrollDown(camResolution);
	elementUtil.doClick(camResolution);
	logger.info("Successfully selected camera resolution filter");
	 
	}
	
	
	public void FilterByModelYear()
		{WebElement modelYrCheckBox = elementUtil.waitForElementToBeClickable(modelYearCheckBox, 3000);
		javaScriptUtil.scrollDown(modelYrCheckBox); 
		elementUtil.doClick(modelYearLink);
		logger.info("Successfully selected model year filter");}

	public void SetPriceRange(String minRange, String maxRange)
	{
		elementUtil.doSendKeys(minPriceTextBox, minRange);
		elementUtil.doSendKeys(maxPriceTextBox, maxRange);
		elementUtil.doClick(priceButton);
		logger.info("Selected price range" +minRange  +" to " +maxRange +" ");
		 
	}
	
	
	public boolean ListofSamsungPhones () {
		
		boolean SamsungPhoneFound =false;
		List<WebElement> allmobilenames =driver.findElements(By.xpath("//div//h2//span"));
		System.out.println("Number of elements:" +allmobilenames.size()); 
	    for (int i=0; i<allmobilenames.size();i++){
	     String Mobilenames = allmobilenames.get(i).getText();
	      
	     logger.info("----------------------------------------------------------") ;
	     logger.info("Mobile Name  "  +Mobilenames);
	     logger.info("----------------------------------------------------------") ;
	      if(Mobilenames.contains("samsung"))
	      {
	    	  SamsungPhoneFound =true;
	    	  System.out.println("Below are the samsung phones : ");
	    	  System.out.println(Mobilenames);
	      }
	      
	       
	    	  
	       
	    	  
	    }
	   
	    System.out.println("No Samsung phone found within given specification");
	    return SamsungPhoneFound;
		
	}
	
	
}
