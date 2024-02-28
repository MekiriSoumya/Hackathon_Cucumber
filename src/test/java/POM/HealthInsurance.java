package POM;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Utilities.Excel;

public class HealthInsurance extends BasePage {
	
	public HealthInsurance(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//div/ul/li[2][@class='ruby-menu-mega shade mr']/a")
	WebElement HealthlInsuracePro;
	
	@FindBy (xpath="//div[3][@class='ruby-col-3 hidden-md']/ul/li/a/span")
	List<WebElement> HealthlInsuraceList;
	
	@FindBy (xpath="//div[3][@class='ruby-col-3 hidden-md']/h3/a")
	WebElement HealthlInsurace;
	
	public void moveToHInsurance() throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(HealthlInsuracePro).click();
		Thread.sleep(3000);
		HealthlInsuracePro.click();
		
	}
	
	public boolean testHealthInsurance() {
		boolean status=HealthlInsurace.isDisplayed();
		return status;
		
	}
	
	
	
	public void clickHealthInsur() throws IOException {
		Excel xl=new Excel();
		String str=HealthlInsurace.getText();	
		System.out.println(str);
		xl.setExcel(str,5,0);
		}
	public void HInsuranceList() throws IOException {
		Excel xl=new Excel();
		System.out.println("Health Insurance menu items:" + HealthlInsuraceList.size());
		for(int i=0;i<HealthlInsuraceList.size();i++) 
		{
			
			String str=HealthlInsuraceList.get(i).getText();
			xl.setExcel(str,i+6, 0);
			System.out.println(str);
			}
		
		}
	
	
	}
	
	


