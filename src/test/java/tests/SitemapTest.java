package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.SitemapPage;
import utils.ReadExcel;
import utils.ReusableMethods;

public class SitemapTest extends BaseTest {

//	Instantiating logger for BusHireTest
	public final static Logger log = Logger.getLogger(SitemapTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getRTCOperatorData")
	public Object[][] RTCOperatorData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "RTCOperatorTestData");
		return arrayObject;
	}

	@DataProvider(name = "getPilgrimageData")
	public Object[][] PilgrimageData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "PilgrimageTestData");
		return arrayObject;
	}

//	Method to book bus with RTC Operators
	@Test(dataProvider = "getRTCOperatorData")
	public void bookBus_RTCOperator(String ExecutionRequired) {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {

			extentTest = extent.startTest("Book Bus with RTC Operators scenario test");
			log.info("Book Bus with RTC Operators test case started!");
			SitemapPage site = new SitemapPage(driver);
			log.info("Clicking Sitemap Link");
			site.clickSitemap();
			ReusableMethods.switchWindowClose(driver);
			log.info("Clicking View More");
			site.clickViewMore();
			log.info("Selecting HRTC Operator");
			site.clickHRTC();
			log.info("Clicking Book Now Button");
			site.clickBookNow();
			log.info("Selecting date to book bus");
			site.selectDate();
			Assert.assertEquals(driver.getTitle(), "Search Bus Tickets");
			log.info("Book bus with RTC Operator test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

//	Method to book Pilgrimage package
	@Test(dataProvider = "getPilgrimageData")
	public void bookPilgrimagePackage(String ExecutionRequired) {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {

			extentTest = extent.startTest("Book Pilgrimage Package scenario test");
			log.info("Book Pilgrimage package test case started!");
			SitemapPage site = new SitemapPage(driver);
			log.info("Clicking Sitemap link");
			site.clickSitemap();
			ReusableMethods.switchWindowClose(driver);
			log.info("Clicking Pilgrimage Package button");
			site.clickPilgrimagePack();
			log.info("Clicking Arrow Key to select package");
			site.clickArrowKey();
			Assert.assertEquals(driver.getTitle(), "redBus | Search");
			log.info("Book Pilgrimage package test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}
}
