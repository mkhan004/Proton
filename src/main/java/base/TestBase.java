package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pages.JobSearchPage;
import pages.MenuBar;
import pages.SigninPage;

@Listeners(listener.EliteListener.class)
public class TestBase extends Driver {
	public static JobSearchPage jobSearchPage;
	public static MenuBar menuBar;
	public static SigninPage signinPage;
	

	@BeforeSuite
	public void setup() {
		
		if ( Boolean.valueOf(getProperty("saucelabs")) ) {
			SauceLabs sauce = new SauceLabs();
			sauce.setSauceLabs();
			driver = sauce.driver;
		} else {
			setDriver();
		}
		
		jobSearchPage = PageFactory.initElements(driver, JobSearchPage.class);
		menuBar = PageFactory.initElements(driver, MenuBar.class);
		signinPage = PageFactory.initElements(driver, SigninPage.class);
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
