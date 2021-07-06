package tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DonatePage;
import utils.ReadExcel;
import utils.ReusableMethods;

public class DonateTest extends BaseTest {

//	Instantiating logger for DonateTest
	public final static Logger log = Logger.getLogger(DonateTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getDonateData")
	public Object[][] redCareDonateData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "DonateTestData");
		return arrayObject;
	}

//	Method for Redbus care donate page
	@Test(dataProvider = "getDonateData")
	public void redCareDonate(String ExecutionRequired, String name, String email, String number)
			throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Red bus care donate scenario Test");
			log.info("Red bus care donate test case started!");
			DonatePage donate = new DonatePage(driver);
			log.info("Clicking red bus care");
			donate.clickRedCare();
			ReusableMethods.switchWindow(driver);
			log.info("Clicking amount to donate");
			donate.clickAmount();
			log.info("Entering Name");
			donate.enterName(name);
			log.info("Entering Email Address");
			donate.enterEmail(email);
			log.info("Entering Contact Number");
			donate.enterNumber(number);
			log.info("Clicking on Donate Now button");
			donate.clickDonateButton();
			log.info("Selecting Credit Card option for payment");
			donate.clickCreditCard();
			log.info("Clicking on Pay Now Button");
			donate.clickPayNowButton();
			ReusableMethods.switchBackClose(driver);
			Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
			log.info("Red bus care donate test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}
}
