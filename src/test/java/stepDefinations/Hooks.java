package stepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
 
 
public class Hooks {
 
	 public static WebDriver driver;
	 static Properties p;
	@BeforeAll
    public static void setup() throws IOException, InterruptedException
    {
    	driver=BaseClass.initializeBrowser();
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("URL"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.manage().window().maximize();
    	
    	//Thread.sleep(2000);

	}

    @AfterAll
    public static void tearDown() {
       driver.quit();
    }
    
 
 
    @AfterStep
    public void addScreenshot(Scenario scenario) {
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        }
    }
