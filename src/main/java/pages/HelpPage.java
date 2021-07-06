package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {

	WebDriver driver;

	public HelpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding Help Web Elements using Locators------------------ */

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help')]")
	public WebElement help;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement closeIcon;

	@FindBy(how = How.CLASS_NAME, using = "parentText")
	public WebElement parentText;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'Availability of buses')]")
	public WebElement availability;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), 'No, thanks')]")
	public WebElement noThanks;

	@FindBy(how = How.XPATH, using = "//*[@id=\"suggestion-block\"]/div/div[2]")
	public WebElement good;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'We are glad ')]")
	public WebElement feedback;

	/* ------------Methods of Help Page------------- */
//	Method to click help
	public void clickHelp() {
		help.click();
	}

//	Method to click close icon
	public void clickCloseIcon() {
		closeIcon.click();
	}

//	Method to switch to other frame
	public void switchToOtherFrame() {
		driver.switchTo().frame(0);
	}

//	Method to click parent text
	public void clickParentText() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(parentText));
		parentText.click();
	}

//	Method to click availability option
	public void clickAvailability() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", availability);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(availability));
		availability.click();
	}

//	Method to click no thanks option
	public void clickNoThanks() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(noThanks));
		noThanks.click();
	}

//	Method to click good option
	public void clickGood() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(good));
		good.click();
	}

//	Method to return feedback
	public String getFeedback() {
		return feedback.getText();
	}
}
