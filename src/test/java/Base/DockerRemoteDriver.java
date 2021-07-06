package Base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import tests.BaseTest;

public class DockerRemoteDriver {

//	Declaring static variables
	public final static Logger log = Logger.getLogger(DockerRemoteDriver.class);

//	Method to initialize and return remote webdriver container
	public static WebDriver setUpRemoteDrivers() throws MalformedURLException {

		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = null;

		if (BaseTest.prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
			log.info("Launching Chrome Container");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--no-sandbox");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("user-agent=Chrome/91.0.4472.124");
			driver = new RemoteWebDriver(url, options);

		} else if (BaseTest.prop.getProperty("browserName").equalsIgnoreCase("edge")) {
			log.info("Launching Microsoft Edge Container");
			DesiredCapabilities dc = DesiredCapabilities.edge();
			driver = new RemoteWebDriver(url, dc);

		} else if (BaseTest.prop.getProperty("browserName").equalsIgnoreCase("gecko")) {
			log.info("Launching Firefox Container");
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(url, dc);
		}

		return driver;
	}

}
