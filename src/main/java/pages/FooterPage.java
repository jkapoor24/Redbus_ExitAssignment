package pages;

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

public class FooterPage {
	WebDriver driver;

	public FooterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding Blog Page Web Elements using Locators------------------ */

	@FindBy(how = How.LINK_TEXT, using = "Blog")
	public WebElement blog;

	@FindBy(how = How.XPATH, using = "//input[@class='search-field']")
	public WebElement searchField;

	@FindBy(how = How.XPATH, using = "//a[@class='blogpost-button']")
	public WebElement readMoreBlog;

	/*
	 * ---------------Finding Careers Page Web Elements using
	 * Locators------------------
	 */

	@FindBy(how = How.LINK_TEXT, using = "Careers")
	public WebElement careers;

//	@FindBy(how = How.XPATH, using = "/html/body/section/footer/div[3]/div/div/div[1]/div[1]/a[7]")
//	public WebElement careers;

	@FindBy(how = How.XPATH, using = "//a[@id='scroll-aHref-3']")
	public WebElement jobs;

	@FindBy(how = How.XPATH, using = "//body/div[@id='reactContentMount']/div[1]/div[1]/div[9]/ul[1]/a[5]/img[1]")
	public WebElement naukri;

	@FindBy(how = How.XPATH, using = "//*[@id=\"onBoardContainer\"]/ul/a[3]/img")
	public WebElement instaHyre;

	@FindBy(how = How.CLASS_NAME, using = "more-link")
	public WebElement readMore;

	@FindBy(how = How.ID, using = "login_Layer")
	public WebElement login;

	@FindBy(how = How.XPATH, using = "//input[@id='eLogin']")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='pLogin']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
	public WebElement loginButton;

	/*
	 * ---------------Finding Contact Us Page Web Elements using
	 * Locators------------------
	 */

	@FindBy(how = How.LINK_TEXT, using = "Contact Us")
	public WebElement contactUsLink;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Click Here')]")
	public WebElement clickHereLink;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'press@redbus.com')]")
	public WebElement enquiryEmail;

	/* ------------Methods of Blog Page------------- */

//	Method to click blog link
	public void clickBlog() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(blog));
		blog.click();
	}

//	Method to enter blog name in search field
	public void enterSearchField(String search) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchField));
		searchField.sendKeys(search);
	}

//	Method to click search button
	public void clickSearchButton() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementsByClassName('search-submit')[0].click()");
	}

//	Method to click read more option
	public void clickReadMoreBlog() {
		readMoreBlog.click();
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}

	/* ------------Methods of Careers Page------------- */

//	Method to click careers link
	public void clickCareers() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(careers));
		careers.click();
	}

//	Method to click on naukri option
	public void clickNaukri() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", naukri);
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(naukri));
		js.executeScript("document.getElementsByTagName('img')[36].click()");
//		naukri.click();
	}

//	Method to click read more option
	public void clickReadMore() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(readMore));
		readMore.click();
	}

//	Method to click login to apply option
	public void clickLoginToApply() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(login));
		login.click();
	}

//	Method to enter email address
	public void enterEmail(String e) {
		email.sendKeys(e);
	}

//	Method to enter password
	public void enterPassword(String p) {
		password.sendKeys(p);
	}

//	Method to click login button
	public void clickLoginButton() {
		loginButton.click();
	}

	/* ------------Methods of Contact Us Page------------- */

//	Method to click contact us link
	public void clickContactUs() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(contactUsLink));
		contactUsLink.click();
	}

//	Method to return enquiry email
	public String getEnquiryEmail() {
		return enquiryEmail.getText();
	}

//	Method to tap on click here link
	public void tapClickHereLink() {
		clickHereLink.click();
	}
}
