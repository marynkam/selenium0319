package pl.lait.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTest {
//żeby test mógł się uruchomić musi być fraza "@Test"
	
	WebDriver driver;
	// przy uzyciu before ustalamy co ma być wykonane przed każdym testem ponizej 
	@Before
	public void bifor() {
		//otwieramy daną przeglądarkę przed testem 
		Init.log("Otwieram okno przeglądarki");
		driver = Init.getDriver();
	}
	@Test
	public void topMenu() {
		
		Init.log("Klikam w link CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		Init.log("Klikam w link SUPPORT");
		driver.findElement(By.linkText("SUPPORT")).click();
		Init.log("Klikam w link REGISTER");
		driver.findElement(By.linkText("REGISTER")).click();
		Init.log("Klikam w link SIGN-ON");
		driver.findElement(By.linkText("SIGN-ON")).click();
		//pobieramy i zwracamy stringa z tytułem 
		Init.log(driver.getTitle());
		
	}
	
	@After
	public void awter() {
		//tu trzeba zamknąć przeglądarkę 
		Init.close();
	}
	
}
