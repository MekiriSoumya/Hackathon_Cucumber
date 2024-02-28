package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarInsurance extends BasePage {
	
	public CarInsurance(WebDriver driver) {
		super(driver);
		
	}
	@FindBy (xpath="/html/body/main/div[2]/section/div[4]/a")
	WebElement CarInsurance;
	
	@FindBy (xpath="//input[@id='regNoTextBox']")
	WebElement CarNo;
	
	@FindBy (xpath="//button[@id='btnGetQuotes']")
	WebElement ViewPrice;
	
	@FindBy (xpath="//div[@id='dvMake']/div/ul[1]/div/li/span")
	List<WebElement> Carcmpny;
	
	@FindBy (xpath="//ul/div[@id='modelScroll']/li/span")
	List<WebElement> CarCmpnyOpt;
	
	@FindBy (xpath="//ul/div[@id='modelScroll']/li/span/b")//div[@id='dvModel']/div/div[2]/ul/div/li/span
	List<WebElement> CarModel;
	
	@FindBy (xpath="//div[@id='dvFuelType']/ul[1]/div/li")
	List<WebElement> CarFuel;
	
	
	@FindBy (xpath="//ul/div[@id='variantScroll']/li/span")
	List<WebElement> CarVariants;
	
	@FindBy (xpath="//div[@id='dvRegYear']/ul/div/li/span/b")
	List<WebElement> CarReg;
	
	@FindBy (xpath="//input[@id='name']")
	WebElement FullName;
	
	@FindBy (xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy (xpath="//input[@id='mobileNo']")
	WebElement MobileNo;
	
	@FindBy (xpath="//button[@id='btnLeadDetails']")
	WebElement ViewPrices;
	
	@FindBy (xpath="//a[@class='pb-logo']")
	WebElement Logo;
	
	public void clickCarInsurance() throws InterruptedException {
		CarInsurance.click();
	}
	
	public boolean testCarInsurance()
	{
		boolean status=CarNo.isDisplayed();
		return status;
	}
	
	
	public void clickViewPrice()
	{
		ViewPrice.click();
	}
	public void setCarNo(String string) {
		CarNo.sendKeys(string);
		ViewPrice.click();
	}
	
	public void selectCarCmpny() {
		for(WebElement cmpny:Carcmpny) 
		{
			String str=cmpny.getText();
			System.out.println(str);
			if(str.equals("MARUTI")) {
				cmpny.click();
				break;
			}	
		}
	}
	
	public void selectCarModel() {
		for(WebElement model:CarModel) 
		{
			if(model.getText().equals("ALTO")) {
				model.click();
				break;
			}	
		}
	}
	
	
	public void selectFuel() {
		for(WebElement model:CarFuel) 
		{
			if(model.getText().equals("Petrol")) {
				model.click();
				break;
			}	
		}
	}
	
	public void selectVariant() {
		for(WebElement variant:CarVariants) 
		{
			if(variant.getText().equals("LX (796 cc)")) {
				variant.click();
				break;
			}	
		}
	}
	
	public void selectCarReg() throws InterruptedException {
		for(WebElement reg:CarReg) 
		{
			if(reg.getText().equals("2023")) {
				reg.click();
				break;
			}	
		}
	}
	
	public void clickViewPrices() {
		ViewPrices.click();
	}
	
	public void setInvalidEmail(String string,String string2,String string3) {
		FullName.sendKeys(string);
		Email.sendKeys(string2);
		MobileNo.sendKeys(string3);
		
	}
	
	
	public void navigateBack() {
		Logo.click();
	}
	
	
}
