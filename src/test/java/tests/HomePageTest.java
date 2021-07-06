package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.ReadExcel;
import utils.ReusableMethods;

public class HomePageTest extends BaseTest {

//	Instantiating logger for HomeTest
	public final static Logger log = Logger.getLogger(HomePageTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getInvalidManageBookingData")
	public Object[][] InvalidManageBookingData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "ManageBookingTestData");
		return arrayObject;
	}

	@DataProvider(name = "getSMSAppData")
	public Object[][] SmsAppData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "SMSAppTestData");
		return arrayObject;
	}

	@DataProvider(name = "getCountryData")
	public Object[][] NavigateCountryData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "CountryTestData");
		return arrayObject;
	}

//	Method for invalid manage booking
	@Test(dataProvider = "getInvalidManageBookingData")
	public void manageBooking(String ExecutionRequired, String ticketNumber, String email) {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Invalid Show my ticket in Manage Booking scenario Test");
			log.info("Show my ticket in Manage Booking test case started!");
			HomePage home = new HomePage(driver);
			log.info("Clicking Manage Booking option in HomePage");
			home.clickManageBooking();
			log.info("Clicking show my ticket option");
			home.clickShowMyTicket();
			log.info("Entering Ticket Number");
			home.enterTicketNumber(ticketNumber);
			log.info("Entering Email Address");
			home.enterEmailAddress(email);
			log.info("Clicking on Submit button");
			home.clickSubmitButton();
			if (driver.getCurrentUrl().contains("error")) {
				Assert.assertFalse(true);
				log.info("Invalid Show my ticket in Manage Booking test case failed!");
			} else {
				log.info("Invalid Show my ticket in Manage Booking test case passed!");
			}
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}

//	Method for sending SMS link for redbus app 
	@Test(dataProvider = "getSMSAppData")
	public void smsAppLink(String ExecutionRequired, String number) {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("SMS App link scenario Test");
			log.info("SMS App link test case started!");
			HomePage home = new HomePage(driver);
			log.info("Entering Phone Number");
			home.enterNumber(number);
			log.info("Clicking on send me the link button");
			home.clickSendMeLink();
			Assert.assertEquals(home.getErrorMessage(), "Invalid Mobile No");
			log.info("SMS App link test case Passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

//	Method for navigating to other country page
	@Test(dataProvider = "getCountryData")
	public void navigateToCountry(String ExecutionRequired) {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Navigate to other country page scenario Test");
			log.info("Navigate to other country page test case started!");
			HomePage home = new HomePage(driver);
			log.info("Clicking on country malaysia");
			home.clickCountryMalaysia();
			ReusableMethods.switchWindowClose(driver);
			Assert.assertEquals(home.getCountryURL(), "https://www.redbus.my/");
			Assert.assertEquals(driver.getTitle(),
					"Bus Tickets Online, Ferry Booking | Best Online Bus Booking Platform - redBus Malaysia");
			log.info("Navigate to other country page test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}
}
