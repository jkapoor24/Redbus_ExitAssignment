package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DonatePage {

	WebDriver driver;

	public DonatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*-------Finding Donate Page Web Elements using Locators------------------*/

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'redBus Cares')]")
	WebElement redCareOffer;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), '1000')]")
	WebElement amount;

	@FindBy(how = How.XPATH, using = "//input[@type='text'][@id='otherAmount']")
	WebElement name;

	@FindBy(how = How.XPATH, using = "//input[@type='email'][@id='otherAmount']")
	WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@type='number'][@id='otherAmount'][@class='userInfo lastuserinfo']")
	WebElement phone;

	@FindBy(how = How.CLASS_NAME, using = "donateBtn")
	WebElement donateButton;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Credit Card')]")
	WebElement creditCard;

	@FindBy(how = How.CLASS_NAME, using = "payNowBtn")
	WebElement payNowButton;

	/* ------------Methods of Donate Page------------- */

//	Method to click red care option
	public void clickRedCare() {
		redCareOffer.click();
	}

//	Method to enter amount
	public void clickAmount() {
		amount.click();
	}

//	Method to enter name
	public void enterName(String n) {
		name.sendKeys(n);
	}

//	Method to enter email address
	public void enterEmail(String e) {
		email.sendKeys(e);
	}

//	Method to enter phone number
	public void enterNumber(String n) {
		phone.sendKeys(n);
	}

//	Method to click on donate button
	public void clickDonateButton() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(donateButton));
		donateButton.click();
	}

//	Method to select credit card option
	public void clickCreditCard() {
		creditCard.click();
	}

//	Method to click pay now button
	public void clickPayNowButton() {
		payNowButton.click();
	}
}
