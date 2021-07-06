package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding Manage Booking Link Page Web Elements using Locators------------------ */

	@FindBy(how = How.XPATH, using = "//div[@id='manageHeaderdd']")
	public WebElement manageBooking;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	public WebElement showMyTicket;
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketTIN']")
	public WebElement ticketNumber;
	
	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketEmail']")
	public WebElement emailAddress;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ticketSearch']")
	public WebElement submit;
	
	
	
	
	/* ---------------Finding Sms App Link Page Web Elements using Locators------------------ */

	@FindBy(how = How.XPATH, using = "//input[@id='smsTXTBOX']")
	public WebElement numberField;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Invalid Mobile No')]")
	public WebElement errorMessage;
	
	@FindBy(how = How.ID, using = "sendLinkButton")
	public WebElement sendLinkButton;

	/* ---------------Finding Country Malaysia Page Web Elements using Locators------------------ */
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'malaysia')]")
	public WebElement countryMalaysia;
	
	
	/* ------------Methods of Manage Booking Page-------------*/
	
//	Method to click manage booking option
	public void clickManageBooking() {
		manageBooking.click();
	}
	
//	Method to click show my ticket option
	public void clickShowMyTicket() {
		showMyTicket.click();
	}
	
//	Method to enter ticket number
	public void enterTicketNumber(String num) {
		ticketNumber.sendKeys(num);
	}
	
//	Method to enter email address
	public void enterEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}
	
//	Method to click submit button
	public void clickSubmitButton() {
		submit.click();
	}
	
	/* ------------Methods of SMS App Link Page-------------*/
	
//	Method to enter phone number
	public void enterNumber(String number) {
		numberField.sendKeys(number);
	}
	
//	Method to return error message
	public String getErrorMessage() {
		return errorMessage.getText();
	}

//	Method to click send me link button
	public void clickSendMeLink() {
		sendLinkButton.click();
	}
	
	
	/* ------------Methods of Country Page-------------*/
	
//	Method to click country malaysia
	public void clickCountryMalaysia() {
		countryMalaysia.click();
	}
	
//	Method to return country URL
	public String getCountryURL() {
		return driver.getCurrentUrl();
	}
}
