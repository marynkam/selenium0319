package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.selenium.Init;

public class ReservationPage2 {
	

	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input")
	WebElement bfir;
	@FindBy (xpath ="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")
	WebElement bsec;
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")
	WebElement bthi; 
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]/input")
	WebElement bfou;
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[1]/input")
	WebElement cfir;
	@FindBy (xpath ="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input")
	WebElement csec;
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")
	WebElement cthi; 
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")
	WebElement cfou;
	
	@FindBy (name = "reserveFlights")
	WebElement reserveFlightsBtn;
	
	public void selectFlights(int departing, int returning) {
	switch (departing) {
	case 1:
		bfir.click();
	case 2:
		bsec.click();
		break;
	case 3:
		bthi.click();
		break;
	case 4:
	bfou.click();
	break;
	default:
	break;
	}
	
	switch (returning) {
	case 1:
		cfir.click();
	case 2:
		csec.click();
		break;
	case 3:
		cthi.click();
		break;
	case 4:
	    cfou.click();
	break;
	default:
	break;
		
	}
	}
	
	public ReservationPage2() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	//____________________reservation 3 level ___________________________________________________
	
	
	
	@FindBy (name = "passFirst0")
	WebElement passFirst0Input;
	
	@FindBy (name = "passLast0")
	WebElement passLast0Input;
	
	@FindBy (name = "pass.0.meal")
	WebElement meal0Select;
	
	@FindBy (name = "buyFlights")
	WebElement buyFlights;
	
	@FindBy (xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img")
	WebElement logOut;
	
	
	
	//______________reservation 3 end____________________________________________________________
	
	
	public void submit() {
		reserveFlightsBtn.click();
	}
		public void pass0(String firstName, String lastName, String mealCode) {
			//KSML
			passFirst0Input.sendKeys(firstName);
			passLast0Input.sendKeys(lastName);
			Select m = new Select(meal0Select);
			m.selectByValue(mealCode);

}
		public void submit2() {
			buyFlights.click();
		}
		public void logOut() {
			logOut.click();
		}
		
	}
