package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TopOperatorPage;
import utils.ReadExcel;

public class TopOperatorTest extends BaseTest {

//	Instantiating logger for TopOperatorTest
	public final static Logger log = Logger.getLogger(TopOperatorTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getTopOperatorData")
	public Object[][] topOperatorData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "TopOperatorTestData");
		return arrayObject;
	}

//	Method to search bus using Top Operator
	@Test(dataProvider = "getTopOperatorData")
	public void topOperator(String ExecutionRequired, String fromOperator, String toOperator)
			throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Search bus by top operators scenario test");
			log.info("Search bus by top operators test case started!");
			TopOperatorPage operator = new TopOperatorPage(driver);
			log.info("Selecting specific top operator");
			operator.selectTopOperator();
			log.info("Entering from which place");
			operator.enterFromOperatorPlace(fromOperator);
			log.info("Entering to which place");
			operator.enterToOperatorPlace(toOperator);
			log.info("Selecting date to search bus");
			operator.clickOnDate();
			log.info("Clicking on search buses button");
			operator.clickOnSearchBus();
			Assert.assertEquals(driver.getTitle(), "Search Bus Tickets");
			log.info("Search bus by top operators test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}
}
