package pl.lait.selenium;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {
//żeby test mógł się uruchomić musi być fraza "@Test"

	WebDriver driver;

	// mini metoda która zwraca stringa i klika
	public void linkClick(String linkText) {
		Init.log("Klikam w link:" + linkText);
		driver.findElement(By.linkText(linkText)).click();
	}

		public void linkName(String linkName) {
			Init.log("Klikam w przycisk Continue:" + linkName);
			driver.findElement(By.name(linkName)).click();
	}

	// metoda uwzględniająca radiobutton
	public void radioClick(String xpath) {
		Init.log("Klikam w element z xpath:" + xpath);
		driver.findElement(By.xpath(xpath)).click();
	}
/** Metoda wyszukuje element typu Select i wybiera wartość
 * @param name
 * @param visibeTxt
 */
	public void selectByVisibleText(String name, String visibeTxt) {
		Select airLineSelect = new Select(driver.findElement(By.name(name)));
		airLineSelect.selectByVisibleText(visibeTxt);
	}

	// przy uzyciu before ustalamy co ma być wykonane przed każdym testem ponizej
	@Before
	public void bifor() {
		// otwieramy daną przeglądarkę przed testem
		Init.log("Otwieram okno przeglądarki");
		driver = Init.getDriver();
	}

	@Ignore
	@Test
	public void topMenu() {

		linkClick("CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		Init.log("Klikam w link SUPPORT");
		driver.findElement(By.linkText("SUPPORT")).click();
		Init.log("Klikam w link REGISTER");
		driver.findElement(By.linkText("REGISTER")).click();
		Init.log("Klikam w link SIGN-ON");
		driver.findElement(By.linkText("SIGN-ON")).click();
		// pobieramy i zwracamy stringa z tytułem
		Init.log(driver.getTitle());
		driver.findElement(By.name("userName")).sendKeys("Martyna");
		driver.findElement(By.name("password")).sendKeys("perfecta");
		driver.findElement(By.name("login")).click();

		Init.sleep(2);
	}

	@Ignore
	@Test
	public void leftMenu() {
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.linkText("Car Rentals")).click();
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.linkText("Destinations")).click();
		driver.findElement(By.linkText("Vacations")).click();
	}

	@Test
	public void loginAndReservationLevel1() {
		driver.findElement(By.linkText("SIGN-ON")).click();

		driver.findElement(By.name("userName")).sendKeys("Martyna");
		driver.findElement(By.name("password")).sendKeys("perfecta");
		driver.findElement(By.name("login")).click();

		String OneWayXpath = "/html/body/div/table/tbody/tr/td[2]/table/" + "tbody/tr[4]/td/table/tbody/tr/td[2]/table/"
				+ "tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]";
		driver.findElement(By.xpath(OneWayXpath)).click();
		Init.sleep(2);

		WebElement passCountWebElem = driver.findElement(By.name("passCount"));
		Select passCountSelect = new Select(passCountWebElem);
		passCountSelect.selectByVisibleText("2");

		Select fromPortSelect = new Select(driver.findElement(By.name("fromPort")));
		fromPortSelect.selectByVisibleText("Paris");

		Select fromMonthSelect = new Select(driver.findElement(By.name("fromMonth")));
		fromMonthSelect.selectByValue("4");

		Select fromDaySelect = new Select(driver.findElement(By.name("fromDay")));
		fromDaySelect.selectByValue("20");

		Select toPortSelect = new Select(driver.findElement(By.name("toPort")));
		toPortSelect.selectByVisibleText("London");

		Select toMonthSelect = new Select(driver.findElement(By.name("toMonth")));
		toMonthSelect.selectByValue("5");

		Select toDaySelect = new Select(driver.findElement(By.name("toDay")));
		toDaySelect.selectByValue("18");

		String eco = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input";
		String biz = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]";
		String fir = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]";
		radioClick(fir);
		radioClick(biz);
		radioClick(eco);
		radioClick(fir);

		//Wybór wartości z listy rozwijanej
		Select airLineSelect = new Select(driver.findElement(By.name("airline")));
		airLineSelect.selectByVisibleText("Blue Skies Airlines");
		selectByVisibleText("airline", "Blue Skies Airlines");
		selectByVisibleText("airline", "Unified Airlines");
		selectByVisibleText("airline", "Pangea Airlines");
		selectByVisibleText("airline", "Blue Skies Airlines");
		linkName("findFlights");
		
		//driver.findElement(By.name("findFlights")).click();
		
		String bfir = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[3]/td[1]/input";
		String bsec = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input";
		String bthi = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input";
		String bfou = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[9]/td[1]/input";
		radioClick(bfir);
		radioClick(bsec);
		radioClick(bthi);
		radioClick(bfou);
		radioClick(bsec);
		
		String cfir = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[3]/td[1]/input";
		String csec = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[5]/td[1]/input";
		String cthi = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input";
		String cfou = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input";
		radioClick(cfir);
		radioClick(csec);
		radioClick(cthi);
		radioClick(cfou);
		radioClick(cthi);
		linkName("reserveFlights");
		
		driver.findElement(By.name("passFirst0")).sendKeys("Martyna");
		driver.findElement(By.name("passLast0")).sendKeys("Jeż");
		driver.findElement(By.name("creditnumber")).sendKeys("600123123");
		linkName("buyFlights");
		
		
		
		Init.sleep(8);

	}

	@After
	public void awter() {
		// tu trzeba zamknąć przeglądarkę
		Init.close();
	}

}
