package stepDefinations;

import java.io.IOException;

import org.junit.Assert;

import Factory.BaseClass;
import POM.CarInsurance;
import POM.TravelInsurance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarInsurancesd extends BaseClass {
	
	TravelInsurance tr;
	CarInsurance cr;
	
	@Given("user navigates back to the home page for car insurance")
	public void user_navigates_back_to_the_home_page_for_car_insurance() {
		tr=new TravelInsurance(BaseClass.getDriver());
	    tr.navigateBack(); 
	}

	@When("user clicks on Car Insurance")
	public void user_clicks_on_car_insurance() throws InterruptedException {
		cr=new CarInsurance(BaseClass.getDriver());
	    cr.clickCarInsurance();
	}
	
	@Then("user verify the car insurance page")
	public void user_verify_the_car_insurance_page() {
		Assert.assertEquals(cr.testCarInsurance(), true);
	}

	@When("user clicks on view price button without entering car number")
	public void user_clicks_on_view_price_button_without_entering_car_number() throws InterruptedException {
	    cr.clickViewPrice();
	    Thread.sleep(1000);
	}

	@Then("user captures the error message")
	public void user_captures_the_error_message() throws IOException {
	    takeScreenshot(1);
	}

	@When("user enters the car number {string} and click on view price")
	public void user_enters_the_car_number_and_click_on_view_price(String string) {
	    cr.setCarNo(string);
	    cr.clickViewPrice();
	}

	@When("user selects car Brand")
	public void user_selects_car_brand() {
	    cr.selectCarCmpny();
	}

	@When("user selects car model")
	public void user_selects_car_model() {
	    cr.selectCarModel();
	}

	@When("user selects car fuel type")
	public void user_selects_car_fuel_type() {
	    cr.selectFuel();
	}

	@When("user selects car variant")
	public void user_selects_car_variant() {
	    cr.selectVariant();
	}

	@When("user selects car registration year")
	public void user_selects_car_registration_year() throws InterruptedException {
	    cr.selectCarReg();
	}

	@When("user clicks on view price without entering any details")
	public void user_clicks_on_view_price_without_entering_any_details() throws InterruptedException {
	    cr.clickViewPrices();
	    Thread.sleep(1000);
	}

	@Then("capture the error messages")
	public void capture_the_error_messages() throws IOException {
	    takeScreenshot(2);
	}


	@When("user enters full name {string} , invalid email {string} and valid mobile number {string}")
	public void user_enters_full_name_invalid_email_and_valid_mobile_number(String string, String string2, String string3) {
	    cr.setInvalidEmail(string,string2,string3);
	}
	
	@Then("capture the error message of invalid email")
	public void capture_the_error_message_of_invalid_email() throws IOException {
	    takeScreenshot(3);
	}

}
