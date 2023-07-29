package saucseDemoPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.driver.SHAFT;

public class LoginPage {
	
	private SHAFT.GUI.WebDriver driver ; 
	
	//constructor 
	public LoginPage(SHAFT.GUI.WebDriver driver ) {
		this.driver = driver ;
		
	}
	
	//locators 
	private By userNameField= By.xpath("//input[@name='user-name']");
	private By password = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//input[@name='login-button']");
	
	private String baseURL = SHAFT.Properties.web.baseURL();
	private String url = "https://www.saucedemo.com/";
	
	private By appLogo = By.xpath("//div[@class='app_logo']");

	//actions 
	
	public void navigatToApplication() {
		driver.browser().navigateToURL(url);
	}
	
	public void fillUserData() {
		driver.browser().refreshCurrentPage();
		driver.element().type(userNameField, "standard_user")
		                .type(password, "secret_sauce")
		                .click(loginButton);
		driver.browser().switchToNewTab("https://www.saucedemo.com/inventory.html");
		driver.browser().refreshCurrentPage();
	}
	
	public void verifyLogginedSuccessfully() {
		
		new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(appLogo));
		
		driver.element().verifyThat(appLogo).exists().perform();
		
	}
	
	

}
