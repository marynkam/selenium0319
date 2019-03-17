package pl.lait.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//nowa klasa by przenieść logowanie do oddzielnej paczki
	
	
	WebDriver driver; 
	//.wskazuje na przyciski na stronie - szukaj go po link text SignOn, moze być po id lub innej danej 
	@FindBy(linkText = "SIGN-ON")
	WebElement signOnLink;

	@FindBy(name = "userName")
	WebElement loginInput;
	
	@FindBy(name = "password")
	WebElement passwdInput;
	
	@FindBy(name = "login")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//metoda do używania guzików 
	public void goToLoginPage() {
		signOnLink.click();
	}

	public void loginAs (String login, String pass) {
		loginInput.sendKeys(login);
		passwdInput.sendKeys(pass);
		loginBtn.click();
	}
}
