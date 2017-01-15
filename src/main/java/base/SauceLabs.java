package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import utils.ReadProperties;

public class SauceLabs extends ReadProperties {
	DesiredCapabilities caps;
	public static WebDriver driver;
	
	public void setSauceLabs() {
		String userName = getSaucelabsProperty("userName");
		String accessKey = getSaucelabsProperty("accessKey");
		String url = "https://" + userName + ":" + accessKey + "@ondemand.saucelabs.com:443/wd/hub";
		
		caps = setCapabilities();
		
		try {
			driver = new RemoteWebDriver(new URL(url), caps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver.get( getProperty("appUrl") );
	}
	
	public DesiredCapabilities setCapabilities() {
		String browser = getSaucelabsProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else {
			caps = DesiredCapabilities.firefox();
		}
		
		caps.setCapability("version", getSaucelabsProperty("browserVersion"));
		caps.setCapability("platform", getSaucelabsProperty("operatingSystem"));
		
		return caps;
	}
}
