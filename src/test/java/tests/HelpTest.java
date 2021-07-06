package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HelpPage;
import utils.ReadExcel;
import utils.ReusableMethods;

public class HelpTest extends BaseTest {

//	Instantiating logger for HelpTest
	public final static Logger log = Logger.getLogger(HelpTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getHelpData")
	public Object[][] HelpData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "HelpTestData");
		return arrayObject;
	}

//	Method to open chatbot of Help page
	@Test(dataProvider = "getHelpData")
	public void helpChatBot(String ExecutionRequired) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Help chatbot scenario Test");
			log.info("Help Chatbot test case started!");
			HelpPage help = new HelpPage(driver);
			log.info("Clicking Help link");
			help.clickHelp();
			ReusableMethods.switchWindow(driver);
			log.info("Clicking close icon of login frame");
			help.clickCloseIcon();
			log.info("Switching to other frame to select options");
			help.switchToOtherFrame();
			log.info("Clicking New Bus Booking help option");
			help.clickParentText();
			log.info("Selecting Availability of buses");
			help.clickAvailability();
			log.info("Clicking No Thanks Option");
			help.clickNoThanks();
			log.info("Again clicking No Thanks Option");
			help.clickGood();
			log.info("Choosing Good Option for feedback");
			help.clickGood();
			Assert.assertEquals(help.getFeedback(),
					"We are glad to know that. Thank you for chatting with redBus. Have a wonderful day!");
			ReusableMethods.switchBackClose(driver);
			log.info("Help Chatbot test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}
}
