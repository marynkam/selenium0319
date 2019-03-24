package pl.lait.Steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

//import cucumber.api.PendingException;
import cucumber.api.java.*;
import cucumber.api.java.en.*;
import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.ReservationPage;
import pl.lait.selenium.Init;

public class LoginPageStepDefs {
	
	WebDriver driver;
	//umożliwienie korzystania z lp z logowania na każdej stronie
	//inicjalizacja Pageobjectów
	LoginPage lp; 
	ReservationPage rp; 
	
	
	@Before
	public void starter() {
		driver = Init.getDriver();
		lp = new LoginPage(driver);
		rp = new ReservationPage();
	}
	
	//upewnienie się, że jesteśmy na właściciwej stronie głównej, na pierwszym kroku. Za każdym razem
	@Given("^I open main page$")
	public void i_open_main_page() throws Throwable {
		String pageTitle = driver.getTitle();
		//String properPageTitle = "Welcome: Mercury Tours";
		Init.log("Current page title: " + pageTitle);
		Assert.assertTrue("Niepoprawny tytuł strony", pageTitle.equals("Welcome: Mercury Tours"));
	    //LoginPage lp = new LoginPage(driver);
	    //lp.goToLoginPage();
	}

	@When("^I fill the login form with login \"([^\"]*)\" and pass \"([^\"]*)\"$")
	public void i_fill_the_login_form_with_login_and_pass(String arg1, String arg2) throws Throwable {
	    lp.goToLoginPage();
	    lp.loginAs(arg1, arg2);
		
		// Write code here that turns the phrase above into concrete actions
	   // System.out.println("tu bym klikał w formularz logowania w wpisał parametry arg1 i arg2");
	}

	@Then("^I should see the flight reservation form$")
	public void i_should_see_the_flight_reservation_form() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@When("^I choose \"([^\"]*)\" passangers$")
	public void i_choose_passangers(String arg1) throws Throwable {
	    rp.passCount(arg1);
	}

	@When("^I choose one way trip type$")
	public void i_choose_one_way_trip_type() throws Throwable {
		rp.oneWay();
	}

	@When("^I start from \"([^\"]*)\" at month: \"([^\"]*)\" day \"([^\"]*)\"$")
	public void i_start_from_at_month_day(String arg1, String arg2, String arg3) throws Throwable {
	    rp.from(arg1, arg2, arg3);
	}

	@When("^I end at \"([^\"]*)\" at month: \"([^\"]*)\" day \"([^\"]*)\"$")
	public void i_end_at_at_month_day(String arg1, String arg2, String arg3) throws Throwable {
	    rp.to(arg1, arg2, arg3);
	}

	@When("^I i want to fly first class using \"([^\"]*)\"$")
	public void i_i_want_to_fly_first_class_using(String arg1) throws Throwable {
	   rp.firstClass();
	  //TODO brak wyboru pozostałych klas 
	}

	@Then("^I submit first level of my flight reservation$")
	public void i_submit_first_level_of_my_flight_reservation() throws Throwable {
	    rp.submit();
	}
@After
public void endTest() {
	Init.close();
}

}
