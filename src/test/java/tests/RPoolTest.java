package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.RPoolPage;
import utils.ReadExcel;

public class RPoolTest extends BaseTest {

//	Instantiating logger for RPoolTest
	public final static Logger log = Logger.getLogger(RPoolTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getRPoolData")
	public Object[][] RPoolData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "RPoolTestData");
		return arrayObject;
	}

//	Method for playing youtube video in RPool page
	@Test(dataProvider = "getRPoolData")
	public void rPoolYoutube(String ExecutionRequired) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("RPool Play Youtube video scenario test");
			log.info("RPool Play Youtube video test case started!");
			RPoolPage rPool = new RPoolPage(driver);
			log.info("Clicking on Rpool link");
			rPool.clickRPool();
			log.info("Switching frame to play youtube video");
			rPool.switchFrame();
			log.info("Clicking Play button");
			rPool.clickPlay();
			Assert.assertEquals(driver.getTitle(), "rPool - India’s new Carpool & Bikepool mobile app");
			log.info("RPool Play Youtube video test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}
}
