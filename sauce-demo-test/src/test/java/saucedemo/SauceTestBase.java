package saucedemo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceTestBase
{
	RemoteWebDriver driver;

	@BeforeEach
	public void setup() throws Exception
	{
		driver = createSauceDriver();
	}

	@AfterEach
	public void teardown()
	{
		driver.quit();
	}

	public static RemoteWebDriver createSauceDriver() throws MalformedURLException
	{
		ChromeOptions capabilities = new ChromeOptions();
		String SAUCE_USERNAME = System.getenv("SAUCE_USERNAME");
		String SAUCE_ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

		System.out.println("SAUCE_USERNAME: " + SAUCE_USERNAME);
		System.out.println("SAUCE_ACCESS_KEY: " + SAUCE_ACCESS_KEY);

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", SAUCE_USERNAME);
		sauceOptions.setCapability("accessKey", SAUCE_ACCESS_KEY);
		capabilities.setCapability("sauce:options", sauceOptions);

		URL SAUCE_URL = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");


		RemoteWebDriver driver = new RemoteWebDriver(SAUCE_URL, capabilities);
		return driver;
	}
}
