package POM;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.Excel;

public class TravelInsurance extends BasePage {
	
	
	
	public TravelInsurance(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath="//div/ul/li[1][@class='logo-li']")
	WebElement PolicyBazzar;
	
	@FindBy (xpath="/html/body/main/div[2]/section/div[7]/a")
	WebElement TravelInsurace;
	
	@FindBy (xpath="//div[@class='pqHeading ']/h1")
	WebElement TravelInsuraceTitle;
	
	@FindBy (xpath="//input[@id='country']")
	WebElement Country;
	
	@FindBy (xpath="//div[@id='search-country']/ul/li")
	List<WebElement> SelectCountry;
	
	@FindBy (xpath="//ul[@class='search-list']/li[1]")
	WebElement FirstOption;
	
	@FindBy (xpath="//button[@class='travel_main_cta']")
	WebElement Next_btn;
	
	@FindBy (xpath="//div[@class='MuiPickersDateRangePickerInput-root']/div[1]")
	WebElement StartDate;
	
	@FindBy (xpath="//div[1]/div/h6[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-displayInline']")
	WebElement MonthYear;

	@FindBy (xpath="//div[2]/div[1]/button[2][@data-mui-test='next-arrow-button']")
	WebElement Arrow;

	@FindBy (xpath="//span[@class='MuiPickersDay-dayLabel']")
	List<WebElement> SelectDate;
		
	@FindBy (xpath="//label[text()='2']")
	WebElement TravellerCount;
	
	@FindBy (xpath="//div[@id='0']")
	WebElement Traveller1Age;
	
	@FindBy (xpath="//div[@id='1']")
	WebElement Traveller2Age;
	
	@FindBy (xpath="//div[@class='options_box_wrapper__option']")
	List<WebElement> TravellerAge;
	
	@FindBy (xpath="//input[@id='ped_no']")
	WebElement Illness_rbtn;
	
	@FindBy (id="mobileNumber")
	WebElement MobileNo;
	
	@FindBy (xpath="//input[@id='studentTrip']")
	WebElement StudentPlan;
	
	@FindBy (xpath="//label[text()='Traveller 1 (22 yrs)']")
	WebElement Traveller1_chbx;
	
	@FindBy (xpath="//label[text()='Traveller 2 (21 yrs)']")
	WebElement Traveller2_chbx;
	
	@FindBy (xpath="//select[@id='feet']")
	WebElement TripDuration;
	
	@FindBy (xpath="//button[text()='Apply']")
	WebElement Apply_btn;
	
	@FindBy (xpath="//span[@class='exitIntentPopup__box__closePop']")
	WebElement Popup;
	
	@FindBy (xpath="//section[@class='newFilterSection sort']")
	WebElement Sort;
	
	@FindBy (xpath="//input[@id='17_sort']")
	WebElement SortLowToHigh;
	
	@FindBy (xpath="//p[@class='quotesCard--insurerName']")
	List<WebElement> TravelInsuranceCmp;
	
	@FindBy (xpath="//span[@class='premiumPlanPrice']")
	List<WebElement> TravelInsuranceAmt;
	
	@FindBy (xpath="//a[text()='Policybazaar']")
	WebElement Logo;
	
	public boolean testLogo()
	{
		boolean status=PolicyBazzar.isDisplayed();
		return status;
	}
	
	public void clickTravelInsurace()
	{
		TravelInsurace.click();
	}
	
	public String testTravelInsurace()
	{
		String title=TravelInsuraceTitle.getText();
		return title;
	}
	
	
	public void selectCountry(String s) throws Exception
	{
		Country.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Country.sendKeys(s);
		Thread.sleep(1000);
		FirstOption.click();
			
		}
	
	public void clickNext()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Next_btn);
	}
	
	public void clickStartDate() {
		StartDate.click();
	}
		
	public void datePicker(String mn,String dat) throws InterruptedException {
		
		Thread.sleep(1000);
		while(true) 
		{
			String mon=MonthYear.getText();
			if(mn.equals(mon)) {
				break;
			}
			
			Arrow.click();
			
		}
		for(WebElement dt:SelectDate) 
		{
			Thread.sleep(3000);
			if(dt.getText().equals(dat)) {
				dt.click();
				Thread.sleep(2000);
				break;
			}	
		}
		
		
	}
	
	public void setTravellerCount() {
		TravellerCount.click();
	}
	
	public void clickTraveller1() {
		Traveller1Age.click();
	}
	
	public void clickTraveller2() {
		Traveller2Age.click();
	}
		
	public void setTravellerAge(String age) {
		for(int i=0;i<TravellerAge.size();i++) {
			String str=TravellerAge.get(i).getText();
			if(str.equals(age)) {
				TravellerAge.get(i).click();
				break;
			}
		}
	}
	public void clickIllness_rbtn()
	{
		Illness_rbtn.click();
	}
	
	public void setMobileNo(String string) {
		MobileNo.sendKeys(string);
	}
	
	public void selectStudentPlan() {
		StudentPlan.click();
		Traveller1_chbx.click();
		Traveller2_chbx.click();
		
	}
	public void selectTripDuration()
	{
		TripDuration.click();
		Select td=new Select(TripDuration);
		td.selectByVisibleText("30 Days");
		Apply_btn.click();
	}
	
	public void sortLtoH() throws InterruptedException {
		Sort.click();
		SortLowToHigh.click();
		Thread.sleep(10000);
	}
	
	public void handlePopUp() {
		try {
		Popup.click();
		}
		catch(Exception e){}
	}
	
	public void insuraceCmpList() throws IOException {
		Excel xl=new Excel();
		xl.setExcel("Travel Insurance Plan", 0, 0);
		xl.setExcel("Plan Amount", 0, 1);
		for(int i=0;i<3;i++) {
			String cmp=TravelInsuranceCmp.get(i).getText();
			xl.setExcel(cmp, i+1, 0);
				for(int j=0;j<1;j++) {
					String amt=TravelInsuranceAmt.get(i).getText();
					xl.setExcel(amt, i+1, 1);
					System.out.println(cmp+"				"+amt);
				}
		}
				
	}
	
	public List<String> travelCmpny(int n) {
		List<String> CmpnyList=new ArrayList<String>();
		for(int i=0;i<TravelInsuranceCmp.size();i++) {
			if(i<n) {
				CmpnyList.add(TravelInsuranceCmp.get(i).getText());
			}
		}
		return CmpnyList;
	}
	public List<String> insuranceAmt(int n){
		List<String> AmtList=new ArrayList<String>();
		for(int i=0;i<TravelInsuranceAmt.size();i++) {
			if(i<n) {
				AmtList.add(TravelInsuranceAmt.get(i).getText());
			}
		}
		return AmtList;
	}
	
	public void navigateBack() {
		Logo.click();
	}
		
	}
		
	

