package tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ReadExcel;
import utils.ReusableMethods;

public class LoginTest extends BaseTest {

//	Instantiating logger for LoginTest
	public final static Logger log = Logger.getLogger(LoginTest.class);

//	Using DataProvider annotations to fetch data from Excel sheets in test cases

	@DataProvider(name = "getValidLoginData")
	public Object[][] validLoginData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "ValidLoginTestData");
		return arrayObject;
	}

	@DataProvider(name = "getInvalidEmailData")
	public Object[][] invalidEmailData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "InvalidEmailTestData");
		return arrayObject;
	}

	@DataProvider(name = "getInvalidPasswordData")
	public Object[][] invalidPasswordData() throws Exception {
		Object[][] arrayObject = ReadExcel.ExcelFile(prop.getProperty("excelPath"), "InvalidPassTestData");
		return arrayObject;
	}

	/* -----------------------Valid Scenario-------------------------- */

//	Method with valid login details
	@Test(dataProvider = "getValidLoginData")
	public void validLogin(String ExecutionRequired, String email, String password) throws InterruptedException {

		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Valid login scenario Test");
			log.info("Valid Login test case started!");
			LoginPage login = new LoginPage(driver);
			log.info("Clicking on Profile button");
			login.clickProfile();
			log.info("Clicking on Sign in button");
			login.clickSignIn();
			log.info("Clicking on sign in with google button");
			login.clickSignInGoogle();
			ReusableMethods.switchWindow(driver);
			log.info("Entering Email Address");
			login.enterEmail(email);
			log.info("Clicking Next button");
			login.clickNext();
			log.info("Entering Password");
			login.enterPassword(password);
			log.info("Clicking Next button");
			login.clickNext();
			Thread.sleep(10000);
			ReusableMethods.switchBackWindow(driver);
			log.info("Clicking close icon");
			login.clickCloseIcon();
			login.reloadPage();
			login.reloadPage();
			log.info("Clicking profile button again");
			login.clickProfile();
			log.info("Clicking My Proflie option");
			login.clickMyProfile();

			Assert.assertEquals(login.getProfileName(), "Red Bus");
			log.info("Valid login test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

	/* -----------------------Invalid Scenarios-------------------------- */

//	Method with invalid email address 
	@Test(dataProvider = "getInvalidEmailData")
	public void invalidEmail(String ExecutionRequired, String email, String password) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Login with invalid Email Address scenario Test");
			log.info("Login with invalid Email Address test case started!");
			LoginPage login = new LoginPage(driver);
			log.info("Clicking on Profile button");
			login.clickProfile();
			log.info("Clicking on Sign in button");
			login.clickSignIn();
			log.info("Clicking on Sign in with google button");
			login.clickSignInGoogle();
			ReusableMethods.switchWindow(driver);
			log.info("Entering Email Address");
			login.enterEmail(email);
			log.info("Clicking Next button");
			login.clickNext();
			ReusableMethods.switchBackClose(driver);
			Assert.assertEquals(driver.getTitle(), "Sign in - Google Accounts");
			log.info("Login with invalid Email Address test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

//	Method with invalid password
	@Test(dataProvider = "getInvalidPasswordData")
	public void invalidPassword(String ExecutionRequired, String email, String password) throws InterruptedException {
		String status = ExecutionRequired.toLowerCase();

		if (status.equals("yes")) {
			extentTest = extent.startTest("Login with invalid Password scenario Test");
			log.info("Login with invalid Password test case started!");
			LoginPage login = new LoginPage(driver);
			log.info("Clicking on Profile button");
			login.clickProfile();
			log.info("Clicking on Sign in button");
			login.clickSignIn();
			log.info("Clicking on Sign in with google button");
			login.clickSignInGoogle();
			ReusableMethods.switchWindow(driver);
			log.info("Entering Email Address");
			login.enterEmail(email);
			log.info("Clicking Next Button");
			login.clickNext();
			log.info("Entering Password");
			login.enterPassword(password);
			log.info("Clicking Next Button");
			login.clickNext();
			ReusableMethods.switchBackClose(driver);
			Assert.assertEquals(driver.getTitle(), "Sign in - Google Accounts");
			log.info("Login with invalid Email Address test case passed!");
		} else {
			log.info("Change Execution Required to 'Yes' in Excel if you want to Run the test case.!");
		}
	}

}
