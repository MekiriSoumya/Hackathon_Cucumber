package stepDefinations;

import java.io.IOException;

import org.junit.Assert;

import Factory.BaseClass;
import POM.CarInsurance;
import POM.HealthInsurance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HealthInsurancesd {
	
	HealthInsurance hl;
	CarInsurance cr;
	
	@Given("user navigates back to the home page for health Insurance")
	public void user_navigates_back_to_the_home_page_for_health_insurance() throws InterruptedException {
		cr=new CarInsurance(BaseClass.getDriver());
		cr.navigateBack();
	}

	@When("user clicks on insurance products")
	public void user_clicks_on_insurance_products() throws InterruptedException {
		hl=new HealthInsurance(BaseClass.getDriver());
		hl.moveToHInsurance(); 
	}
	
	@Then ("user verify the Health insurance")
	public void user_verify_the_Health_insurance() {
		Assert.assertEquals(hl.testHealthInsurance(), true);
	}

	@When("user need to print all health insurance menu in console and excel")
	public void user_need_to_print_all_health_insurance_menu_in_console_and_excel() throws IOException {
		hl.clickHealthInsur();
	    hl.HInsuranceList();
	}


}
