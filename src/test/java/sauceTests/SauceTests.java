package sauceTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;

import saucseDemoPages.LoginPage;

public class SauceTests {
	
	private SHAFT.GUI.WebDriver driver ; 
	private LoginPage loginPage ; 
	
	@BeforeClass
	public void beforeClass() {
		SHAFT.Properties.reporting.set().cleanAllureResultsDirectoryBeforeExecution(true);
		SHAFT.Properties.reporting.set().openAllureReportAfterExecution(false);
		SHAFT.Properties.reporting.set().openExecutionSummaryReportAfterExecution(true);
		


	}
	
	@BeforeMethod 
	public void beforeMethod() {
		driver = new SHAFT.GUI.WebDriver() ; 
		loginPage = new LoginPage(driver);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		
	}
	
	
	@Test
	public void verifyUserAbilityToLogin() {
		
		loginPage.navigatToApplication();
		loginPage.fillUserData();
		loginPage.verifyLogginedSuccessfully();
	}

}
