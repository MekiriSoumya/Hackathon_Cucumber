package TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(features={"FeatureFile\\Insurance.feature"},
	glue= {"stepDefinations"},plugin={"pretty", "html:Reports/myreportss.html",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	dryRun = false,
	monochrome = false,
	publish = false
	)

public class Testrun{
	
}