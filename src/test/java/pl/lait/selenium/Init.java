package pl.lait.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

	//Zmienna globalna - statyczna - na niebiesko 
	static WebDriver driver; 
	
	//Metoda: getDriver
	public static WebDriver getDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://www.newtours.demoaut.com/");
		return driver;
	}
	
	//dzięki temu w wynikach testów możemy zobaczyć w jakiej części testu mamy np bład 
	//- rezulat widoczny po utuchomieniu MenuTest
	public static void log(String msg) {
		System.out.println("---" + msg + "---");
	}
	
	public static void close() {
		driver.close();
		
	}
	// wstrzymanie przechodzenia do kolejnmych testów o określoną ilość czasu 
	// zwykle wyrażane w milisekundach, ponizej zamienione na sekundy. 
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
