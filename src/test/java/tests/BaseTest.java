package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.DockerRemoteDriver;
import utils.ScreenShots;

public class BaseTest {

//	Declaring static variables
	public final static Logger log = Logger.getLogger(BaseTest.class);

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static File file = new File(".\\Resources\\config.properties");
	public static FileInputStream fis = null;
	public static Properties prop = new Properties();

	static {
		try {
			fis = new FileInputStream(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	Method for setting Extent report
	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\ExtentReport.html");
	}

//	Method for closing and flushing extent report
	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

//	Method to initialize webdriver
	@BeforeMethod
	public static void intializeWebdriver() throws MalformedURLException {
		boolean isRemoteMode = Boolean.parseBoolean(prop.getProperty("remote"));
		if (isRemoteMode) {
			driver = DockerRemoteDriver.setUpRemoteDrivers();
		} else {
			if (prop.getProperty("browserName").equalsIgnoreCase("chrome")) {
				log.info("Launching Chrome Browser");
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
				boolean isHeadlessMode = Boolean.parseBoolean(prop.getProperty("headless"));
				if (isHeadlessMode) {
//				To open Chrome Driver in Headless mode
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--headless");
					options.addArguments("windows-size=1920,1080");
					options.addArguments("user-agent=whatever you want");
					driver = new ChromeDriver(options);
				} else {
					driver = new ChromeDriver(); // To open Chrome Driver
				}

			} else if (prop.getProperty("browserName").equalsIgnoreCase("edge")) {
				log.info("Launching Microsoft Edge Browser");
				System.setProperty("webdriver.edge.driver", prop.getProperty("edgeDriverPath"));

				driver = new EdgeDriver(); // To open Edge Driver

			} else if (prop.getProperty("browserName").equalsIgnoreCase("gecko")) {
				log.info("Launching Firefox Browser");
				System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
				boolean isHeadlessMode = Boolean.parseBoolean(prop.getProperty("headless"));
				if (isHeadlessMode) {
//				To open Firefox Driver in Headless mode
					FirefoxOptions options = new FirefoxOptions();
					options.setHeadless(isHeadlessMode);

					driver = new FirefoxDriver(options);
				} else {
					driver = new FirefoxDriver(); // To open FireFox Driver
				}
			}

			driver.manage().window().maximize();
//		Implicit Wait
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWaitTimeout")),
					TimeUnit.SECONDS);
		}
	}

//	Method to attach error screenshot in extent report
	@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = ScreenShots.takeScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test case passed successfully");
		}

		extent.endTest(extentTest);
	}

//	Method for hitting URL
	@BeforeMethod
	public static void openBrowser() {
		log.info("Hitting URL");
		driver.get(prop.getProperty("url"));
	}

//	Method for closing browser
	@AfterMethod
	public static void closeBrowser() {
		log.info("Closing Browser");
		driver.quit();
		log.info("************************************************************************************");
	}

}
