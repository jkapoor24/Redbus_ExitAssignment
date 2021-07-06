package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SearchBusPage;
import utils.ReadExcel;

public class SearchBusTest extends BaseTest {

//	Instantiating logger for SearchBusTest
	public final static Logger log = Logger.getLogger(SearchBusTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getValidSearchBusData")
	public Object[][] validSearchBusData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "ValidSearchBusTestData");
		return arrayObject;
	}

	@DataProvider(name = "getToggleSearchBusData")
	public Object[][] toggleSearchBusData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "ToggleSearchBusTestData");
		return arrayObject;
	}

	@DataProvider(name = "getInvalidSearchBusData")
	public Object[][] invalidSearchBusData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "InvalidSearchBusTestData");
		return arrayObject;
	}

	/* -----------------------Valid Scenarios-------------------------- */

//	Method to search bus with valid details
	@Test(dataProvider = "getValidSearchBusData")
	public void validSearchBus(String ExecutionRequired, String fromPlace, String toPlace, String month, String year,
			String date) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Valid Search bus scenario test");
			log.info("Valid Search bus test case started!");
			SearchBusPage searchPage = new SearchBusPage(driver);
			log.info("Entering from which place");
			searchPage.enterFromPlace(fromPlace);
			log.info("Entering to which place");
			searchPage.enterToPlace(toPlace);
			log.info("Selecting date to search bus");
			searchPage.selectDate(month, year, date);
			log.info("Clicking on search buses button");
			searchPage.clickSearchBusButton();
			Assert.assertEquals(driver.getTitle(), "Search Bus Tickets");
			log.info("Valid Search bus test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}

//	Method to search bus with valid details by toggling or switching source and destination
	@Test(dataProvider = "getToggleSearchBusData")
	public void toggleSearchBus(String ExecutionRequired, String fromPlace, String toPlace, String month, String year,
			String date) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Toggling search bus scenario test");
			log.info("Toggling Search bus test case started!");
			SearchBusPage searchPage = new SearchBusPage(driver);
			log.info("Entering from which place");
			searchPage.enterFromPlace(fromPlace);
			log.info("Entering to which place");
			searchPage.enterToPlace(toPlace);
			log.info("Selecting date to search bus");
			searchPage.selectDate(month, year, date);
			log.info("Clicking on toggle button for swapping location");
			searchPage.clickToggleButton();
			log.info("Clicking on search buses button");
			searchPage.clickSearchBusButton();
			Assert.assertEquals(driver.getTitle(), "Search Bus Tickets");
			log.info("Toggling Search bus test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

	/* -----------------------Invalid Scenario-------------------------- */

//	Method to search bus with invalid details
	@Test(dataProvider = "getInvalidSearchBusData")
	public void invalidSearchBus(String ExecutionRequired, String fromPlace, String toPlace, String month, String year,
			String date) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Invalid Search bus scenario test");
			log.info("Invalid Search bus test case started!");
			SearchBusPage searchPage = new SearchBusPage(driver);
			log.info("Entering from which place");
			searchPage.enterFromPlace(fromPlace);
			log.info("Passing blank entry to which place");
			log.info("Selecting date to search bus");
			searchPage.selectDate(month, year, date);
			log.info("Clicking on search buses button");
			searchPage.clickSearchBusButton();
			Assert.assertEquals(driver.getTitle(), "Search Bus Tickets");
			log.info("Search bus test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}
}
