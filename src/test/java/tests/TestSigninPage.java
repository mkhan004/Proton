package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestSigninPage extends TestBase{

	@BeforeClass
	public void classSetup() {
		menuBar.signinLink.click();
	}
	
	@Test
	public void testSigninWithValidCredentials() {
		signinPage.signin("shakil_ipe@yahoo.com", "365827");
		
		Assert.assertEquals(driver.getCurrentUrl(), "hsdgfjhds");
	}
	
	@AfterClass
	public void classTearDown() {
		menuBar.jobsearchLink.click();
	}
}
