package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.BusHirePage;
import utils.ReadExcel;

public class BusHireTest extends BaseTest {

//	Instantiating logger for BusHireTest
	public final static Logger log = Logger.getLogger(BusHireTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getBusHireOutstationData")
	public Object[][] BusHireOutstationData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "BusHireOutstationTestData");
		return arrayObject;
	}

	@DataProvider(name = "getBusHireLocalData")
	public Object[][] BusHireLocalData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "BusHireLocalTestData");
		return arrayObject;
	}

	@DataProvider(name = "getBusHireAirportData")
	public Object[][] BusHireAirportData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "BusHireAirportTestData");
		return arrayObject;
	}

//	Method to Bus Hire for Outstation journey
	@Test(dataProvider = "getBusHireOutstationData")
	public void busHireOutstation(String ExecutionRequired, String source, String destination, String passangers)
			throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Bus Hire for Outstation scenario Test");
			log.info("Bus Hire for Outstation test case started!");
			BusHirePage bus = new BusHirePage(driver);
			log.info("Clicking Bus Hire link");
			bus.clickBusHire();
			log.info("Selecting outstation type for hire Bus");
			bus.clickOutstation();
			log.info("Clicking One Way Option");
			bus.clickOneWay();
			log.info("Entering source location");
			bus.EnterSource(source);
			log.info("Entering destination location");
			bus.EnterDestination(destination);
			log.info("Selecting date and time");
			bus.selectFromWhen();
			bus.selectTillWhen();
			log.info("Entering number of passangers");
			bus.enterNumberOfPassangers(passangers);
			log.info("Clicking proceed button");
			bus.clickProceedButtonOutstation();
			Assert.assertEquals(bus.getHeaderLabel(), "Fill Contact Details");
			log.info("Bus Hire for Outstation test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

//	Method to Bus Hire for Local journey
	@Test(dataProvider = "getBusHireLocalData")
	public void busHireLocal(String ExecutionRequired, String source, String passangers) throws InterruptedException {

		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Bus Hire for Local scenario Test");
			log.info("Bus Hire for Local test case started!");
			BusHirePage bus = new BusHirePage(driver);
			log.info("Clicking Bus Hire link");
			bus.clickBusHire();
			log.info("Selecting Local type for hire Bus");
			bus.clickLocal();
			log.info("Entering source location");
			bus.EnterSource(source);
			log.info("Selecting a package");
			bus.clickSelectPackage();
			log.info("Entering starting date and time");
			bus.startingDateLocal();
			log.info("Entering number of passangers");
			bus.enterNumberOfPassangers(passangers);
			log.info("Clicking proceed button");
			bus.clickProceedButtonLocal();
			Assert.assertEquals(bus.getHeaderLabel(), "Fill Contact Details");
			log.info("Bus Hire for Local test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

//	Method to Bus Hire for Airport journey
	@Test(dataProvider = "getBusHireAirportData")
	public void busHireAirport(String ExecutionRequired, String destination, String passangers)
			throws InterruptedException {

		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Bus Hire for Airport scenario Test");
			log.info("Bus Hire for Airport test case started!");
			BusHirePage bus = new BusHirePage(driver);
			log.info("Clicking Bus Hire link");
			bus.clickBusHire();
			log.info("Selecting Airport type for hire Bus");
			bus.clickAirport();
			log.info("Selecting City");
			bus.selectCity();
			log.info("Entering airport to destination place");
			bus.enterAirportDestination(destination);
			log.info("Selecting date and time");
			bus.dateAirport();
			log.info("Entering number of passangers");
			bus.enterNumberOfPassangers(passangers);
			log.info("Clicking proceed button");
			bus.clickProceedButtonAirport();
			Assert.assertEquals(bus.getHeaderLabel(), "Fill Contact Details");
			log.info("Bus Hire for Airport test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}
}
