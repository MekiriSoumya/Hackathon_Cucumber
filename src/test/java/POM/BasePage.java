package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

}

//StartDate.click();
//Thread.sleep(1000);
//while(true) {
//	String mon=MonthYear.getText();
//	if(mn.equals(mon)) {
//		break;
//	}
//	else {
//		Arrow.click();
//	}
//}
//for(int i=0;i<SelectDate.size();i++) {
//	if(SelectDate.get(i).getText().equals(dt)) {
//		SelectDate.get(i).click();
//		Thread.sleep(2000);
//		break;
//	}	
//}

