package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TopOperatorPage {
	
	WebDriver driver;

	public TopOperatorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/* ---------------Finding Top Operators Web Elements using Locators------------------ */

	@FindBy(how = How.XPATH, using = "//a[text()='SRS Travels']")
	public WebElement topOperator;	
	
	@FindBy(how = How.ID, using = "txtSource")
	public WebElement fromOperatorPlace;
	
	@FindBy(how = How.ID, using = "txtDestination")
	public WebElement toOperatorPlace;
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Bangalore (All Locations')]")
	public WebElement firstFromOperatorPlace;
	
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Delhi (All Locations)')]")
	public WebElement firstToOperatorPlace;
	
	@FindBy(how = How.ID, using = "txtOnwardCalendar")
	public WebElement dateOperator;
	
	@FindBy(how = How.XPATH, using = "//*[@id='rb-calmiddle']/ul[2]/li[28]")
	public WebElement dateNumber;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[1]/div[3]/button")
	public WebElement searchButton;
	
	
	
	/* ------------Methods of Top Operator Page-------------*/
//	Method to select top operator
	public void selectTopOperator() {
		topOperator.click();
	}
	
//	Method to enter source place
	public void enterFromOperatorPlace(String from) {
		fromOperatorPlace.sendKeys(from);
		firstFromOperatorPlace.click();
	}
	
//	Method to enter destination place
	public void enterToOperatorPlace(String to) {
		toOperatorPlace.sendKeys(to);
		firstToOperatorPlace.click();
	}
	
//	Method to click on date
	public void clickOnDate() {
		dateOperator.click();
		dateNumber.click();
	}
	
//	Method to click on search bus button
	public void clickOnSearchBus() {
		searchButton.click();
	}
	
}
