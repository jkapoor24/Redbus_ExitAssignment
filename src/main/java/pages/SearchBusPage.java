package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchBusPage {
	WebDriver driver;
	String parentWindow;

	public SearchBusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding Search Bus Web Elements using Locators------------------ */

	@FindBy(how = How.XPATH, using = "//input[@id='src']")
	public WebElement fromPlace;

	@FindBy(how = How.XPATH, using = "//input[@id='dest']")
	public WebElement toPlace;

	@FindBy(how = How.XPATH, using = "//li[@select-id='results[0]']")
	public WebElement selectFirst;
	
	@FindBy(how = How.ID, using = "onward_cal")
	public WebElement datePicker;

	@FindBy(how = How.CLASS_NAME, using = "monthTitle")
	public WebElement monthYearHeader;

	@FindBy(how = How.CLASS_NAME, using = "next")
	public WebElement next;

//	@FindBy(how = How.XPATH, using = "//td[text()='17']")
//	public WebElement date;
	
	@FindBy(how = How.XPATH, using = "//button[@id='search_btn']")
	public WebElement searchBusButton;
	
	@FindBy(how = How.XPATH, using = "//label[@class='custom-checkbox'][@for='dt12 pm to 6 pm']")
	public WebElement filter;
	
	@FindBy(how = How.XPATH, using = "//span[@id='togglebtn']")
	public WebElement toggleButton;
	
	
	
	/* ------------Methods of Search Bus Page-------------*/
	
//	Method to enter source 
	public void enterFromPlace(String from) {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='src']")));
		fromPlace.sendKeys(from);
		selectFirst.click();
	}

//	Method to enter destination
	public void enterToPlace(String to) {
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='dest']")));
		toPlace.sendKeys(to);
		selectFirst.click();
	}

//	Method to return string array of month and year value after splitting
	public String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

//	Method to selecting date
	public void selectDate(String expectedMonth, String expectedYear, String expectedDate) {

		datePicker.click();
		(new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("rb-calendar")));
		String monthYearVal = monthYearHeader.getText();

		while (!(getMonthYear(monthYearVal)[0].equals(expectedMonth)
				&& (getMonthYear(monthYearVal)[1].equals(expectedYear)))) {
			next.click();
			monthYearVal = monthYearHeader.getText();
		}
		
		WebElement date = driver.findElement(By.xpath("//td[text()="+expectedDate+"]"));
		date.click();

	}
	
	
//	Method to click search bus button
	public void clickSearchBusButton() throws InterruptedException {
		(new WebDriverWait(driver, 10))
		.until(ExpectedConditions.visibilityOf(searchBusButton));
		searchBusButton.click();
		Thread.sleep(3000);
	}
	
	
//	Method to click toggle button
	public void clickToggleButton() {
		toggleButton.click();
	}
}
