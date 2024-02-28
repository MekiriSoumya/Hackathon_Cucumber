package stepDefinations;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;

import Factory.BaseClass;
import POM.TravelInsurance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TravelInsurancesd extends BaseClass {
	TravelInsurance tr;
	
	@Given("user has to launch the policybazzar website")
	public void user_has_to_launch_the_policybazzar_website() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(1000);
	}
	
	@Then("user verify the webPage")
	public void user_verify_the_webPage() {
		tr=new TravelInsurance(BaseClass.getDriver());
		Assert.assertEquals(tr.testLogo(), true);
	}

	@When("user clicks Travel Insurance")
	public void user_clicks_travel_insurance() {
	    tr.clickTravelInsurace();
	}
	
	@Then("user verify the travel insurance page")
	public void user_verify_the_travel_insurance_page() {
		Assert.assertEquals(tr.testTravelInsurace(),"Let's secure your travel");
	}

	@When("user Enters any European country {string}, selects from dropdown and clicks next button")
	public void user_enters_any_european_country_selects_from_dropdown_and_clicks_next_button(String dest) throws Exception {
	    tr.selectCountry(dest);
	    tr.clickNext();
	}

	@When("select start date and end date of trip and clicks next button {string} {string} {string} {string}")
	public void select_start_date_and_end_date_of_trip_and_clicks_next_button(String string, String string2, String string3, String string4) throws InterruptedException {
	    tr.clickStartDate();
	    tr.datePicker(string, string2);
	    tr.datePicker(string3, string4);
	    tr.clickNext();
	}

	@When("user selects number of travellers, their age and ckicks next button {string} {string}")
	public void user_selects_number_of_travellers_their_age_and_ckicks_next_button(String string, String string2) {
	    tr.setTravellerCount();
	    tr.clickTraveller1();
	    tr.setTravellerAge(string);
	    tr.clickTraveller2();
	    tr.setTravellerAge(string2);
	    tr.clickNext();
	}

	@When("user enters pre-existing medical condition of traveller")
	public void user_enters_pre_existing_medical_condition_of_traveller() {
		tr.clickIllness_rbtn();
		
	}

	@When("user enters {string} and clicks view plan button")
	public void user_enters_and_clicks_view_plan_button(String string) {
		tr.setMobileNo(string);
		tr.clickNext();

	}

	@When("user selects plan type as student plan")
	public void user_selects_plan_type_as_student_plan() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		tr.selectStudentPlan(); 
	}

	@When("user fills the student travel information and trip duration and clicks on apply button")
	public void user_fills_the_student_travel_information_and_trip_duration_and_clicks_on_apply_button() {
		tr.selectTripDuration();
		
	}

	@When("user filters the plan from Low to High")
	public void user_filters_the_plan_from_low_to_high() throws InterruptedException {
		Thread.sleep(3000);
		tr.sortLtoH();
		
	}

	@When("user need to print three lowest student plans in console and excel")
	public void user_need_to_print_three_lowest_student_plans_in_console_and_excel() throws IOException {
		tr.insuraceCmpList();
	}

}
