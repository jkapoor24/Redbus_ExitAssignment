package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FooterPage;
import pages.HomePage;
import utils.ReadExcel;
import utils.ReusableMethods;

public class FooterTest extends BaseTest {

//	Instantiating logger for FooterTest
	public final static Logger log = Logger.getLogger(FooterTest.class);

//Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getBlogData")
	public Object[][] searchBlogData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "BlogTestData");
		return arrayObject;
	}

	@DataProvider(name = "getCareersData")
	public Object[][] careersData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "CareersTestData");
		return arrayObject;
	}

	@DataProvider(name = "getContactUsData")
	public Object[][] ContactUsData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "ContactUsTestData");
		return arrayObject;
	}

//	Method to search and read Blog
	@Test(dataProvider = "getBlogData")
	public void searchBlog(String ExecutionRequired, String search) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Search and Read Blog scenario Test");
			log.info("Search Blog test case started!");
			FooterPage footer = new FooterPage(driver);
			log.info("Clicking on Blog Link");
			footer.clickBlog();
			ReusableMethods.switchWindow(driver);
			log.info("Search for blog topic to read");
			footer.enterSearchField(search);
			log.info("Clicking Search Button");
			footer.clickSearchButton();
			log.info("Clicking Read More Button");
			footer.clickReadMoreBlog();
			ReusableMethods.switchBackClose(driver);
			Assert.assertEquals(driver.getTitle(), "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India");
			log.info("Search blog test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

//	Method to open careers page and apply for job in naukri 
	@Test(dataProvider = "getCareersData")
	public void careers(String ExecutionRequired, String email, String password) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Careers page scenario Test");
			log.info("Careers test case started!");
			FooterPage footer = new FooterPage(driver);
			log.info("Clicking on Careers link");
			footer.clickCareers();
			ReusableMethods.switchWindowClose(driver);
			log.info("Clicking on Naukri.com");
			footer.clickNaukri();
			ReusableMethods.switchWindowClose(driver);
			log.info("Clicking on read more to read job desciption");
			footer.clickReadMore();
			ReusableMethods.switchWindowClose(driver);
			log.info("Clicking Login to Apply");
			footer.clickLoginToApply();
			log.info("Entering Email address");
			footer.enterEmail(email);
			log.info("Entering Password");
			footer.enterPassword(password);
			log.info("Clicking Login button");
			footer.clickLoginButton();
			Assert.assertEquals(driver.getTitle(),
					"Job Description – RedBus Jobs – Career Opportunities in RedBus – Naukri.com");
			log.info("Careers test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}

	}

//	Method to open contact us page
	@Test(dataProvider = "getContactUsData")
	public void contactUs(String ExecutionRequired) {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Contact Us page scenario Test");
			log.info("Contact Us test case started!");
			FooterPage footer = new FooterPage(driver);
			log.info("Clicking Contact Us link");
			footer.clickContactUs();
			ReusableMethods.switchWindowClose(driver);
			log.info("Clicking Click Here link");
			footer.tapClickHereLink();
			Assert.assertEquals(footer.getEnquiryEmail(), "press@redbus.com");
			ReusableMethods.switchWindowClose(driver);
			Assert.assertEquals(driver.getTitle(), "red:Care");
			log.info("Contact Us test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}
}
