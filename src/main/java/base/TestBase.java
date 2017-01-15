package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pages.JobSearchPage;

public class TestBase extends Driver {
	public JobSearchPage jobSearchPage;

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
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
