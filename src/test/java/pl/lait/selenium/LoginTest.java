package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.ReservationPage;
import pl.lait.pageObjects.ReservationPage2;

@Ignore
public class LoginTest {
	
	
	WebDriver driver; 
	@Before
	public void bifor() {
		driver = Init.getDriver();
		
		
	}
@Test 
public void reserveTest() {
	LoginPage lp = new LoginPage(driver);
	lp.goToLoginPage();
	lp.loginAs("Martyna", "perfecta");
	ReservationPage rp = new ReservationPage();
	rp.from("Frankfurt", "10", "18");
	rp.to("London", "3", "20");
	rp.passCount("2");
	rp.firstClass();
	rp.submit();
	
	//drugi etap
	
	ReservationPage2 rp2 = new ReservationPage2();
		rp2.selectFlights(2, 4);
		rp2.submit();
		
		//etap 3
		
		rp2.pass0("Martyna", "mjkhsdki", "KSML");
		rp2.submit2();
		
		//Etap4 
		
		rp2.logOut();
	}
	


@After
public void awter() {
	// tu trzeba zamknąć przeglądarkę
	Init.close();
}
}
