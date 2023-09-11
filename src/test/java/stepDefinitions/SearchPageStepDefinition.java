package stepDefinitions;  
 
import static org.junit.Assert.assertEquals;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
import objectPages.SearchPage;
import utils.ConfigReader;
 
 
public class SearchPageStepDefinition   {
	
	ConfigReader configReader = new ConfigReader();
	Properties prop = configReader.init_prop();
	static final Logger logger = LogManager.getLogger(SearchPageStepDefinition.class.getName());
	private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());
	 
	@Given("user is on the Amazon.co.uk homepage")
	public void user_is_on_the_amazon_co_uk_homepage() {
 
		DriverFactory.getDriver().get(prop.getProperty("testurl"));
		logger.info("Launched browser and opened " +prop.getProperty("testurl"));
		 searchPage.AcceptCookies();
		
		
		
		
		
	}

	@When("user navigate to All and Electronics and Computers and Phones and Accessories and Mobile Phones")
	public void user_navigate_to_all_electronics_and_computers_phones_and_accessories_mobile_phones() {
		searchPage.NavigateToDesiredOption();
	}

	@When("user clicks on Mobile Phones")
	public void user_clicks_on_mobile_phones() {
		searchPage.MobilePhoneOption();
	}

	@When("user filter phones by Camera Resolution")
	public void user_filter_phones_by_camera_resolution() {
		searchPage.CameraResolutionFilter();
	}

	@When("user filter phones by Model Year")
	public void user_filter_phones_by_model_year() {
		searchPage.FilterByModelYear() ;
	}

	@When("user set the price range")
	public void user_set_the_price_range() {
		searchPage.SetPriceRange("50", "100");
	}

	@Then("user should see a list of Samsung phones meeting the criteria")
	public void user_should_see_a_list_of_samsung_phones_meeting_the_criteria() {
		
		boolean status =searchPage.ListofSamsungPhones ();
	     assertEquals(true, status);
		
	     
	}


	
}
