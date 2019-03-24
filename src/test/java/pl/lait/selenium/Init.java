package pl.lait.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	//Zmienna globalna - statyczna - na niebiesko 
	static WebDriver driver; 
	
	//Metoda: getDriver
	public static WebDriver getDriver() {
		
		URL url =null;
		try {
			url = new URL("http:localhost:4444/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//cap.setPlatform(Platform.VISTA);
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		
		if(driver ==null) {
			//poniżej jest lokalny a teraz ze zdalnego korzystamy
			//driver = new ChromeDriver();
			driver = new RemoteWebDriver(url, cap);
			driver.get("http://newtours.demoaut.com/");
			//ustalenie jaki czas test ma na wykonanie danej akcji np. logowanie. 
			//Jeżeli się nie powiedzie przechodzi dalej i dany test jest na fail. 
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}else {
			return driver;
			
		}
		
	}
	
	//dzięki temu w wynikach testów możemy zobaczyć w jakiej części testu mamy np bład 
	//- rezulat widoczny po utuchomieniu MenuTest
	public static void log(String msg) {
		System.out.println("---" + msg + "---");
	}
	
	public static void close() {
		driver.close();
		driver = null;
		
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
