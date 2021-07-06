package pages;

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

public class SitemapPage {
	
	WebDriver driver;

	public SitemapPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding RTC Operator Page Web Elements using Locators------------------ */

	@FindBy(how = How.LINK_TEXT, using = "Sitemap")
	public WebElement sitemap;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/article[2]/div[2]/ul[1]/li[7]/a[1]")
	public WebElement viewMore;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/article[2]/div[1]/ul[1]/li[14]/a[1]")
	public WebElement hrtc;
	
	@FindBy(how = How.XPATH, using = "//a[@id='time-btn-33']")
	public WebElement bookNow;
	
//	@FindBy(how = How.XPATH, using = "//tbody/tr[4]/td[4]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[2]/li[31]")
//	public WebElement date;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/section[2]/div[1]/table[1]/tbody[2]/tr[4]/td[4]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[2]/li[33]/span[1]")
	public WebElement date;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"16679276\"]/div/div[2]/div[1]")
	public WebElement viewSeats;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"16679276\"]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]/i")
	public WebElement closeIcon;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'HIDE SEATS')]")
	public WebElement hideSeats;
	
	/* ---------------Finding Pilgrimage Package Page Web Elements using Locators------------------ */
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='root']/div[1]/article[1]/div[2]/ul[1]/li[3]/a[1]")
	public WebElement pilgrimagePack;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"home-wrapper\"]/div/section[2]/div/ul/li/div/div/ul/li/span[2]")
	public WebElement arrowKey;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Oops! No buses found.')]")
	public WebElement errorMessage;
	
	
	
	/* ------------Methods of RTC Operator Page-------------*/
	
//	Method to click sitemap link
	public void clickSitemap() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(sitemap));
		sitemap.click();
	}
	
//	Method to click view more option
	public void clickViewMore() {
		viewMore.click();
	}
	
//	Method to click HRTC option
	public void clickHRTC() {
		hrtc.click();
	}
	
//	Method to click book now button
	public void clickBookNow() {
		bookNow.click();
		Actions a = new Actions(driver);
		// scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
//	Method to select date
	public void selectDate() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(date));
		date.click();
	}
	
	/* ------------Methods of Pilgrimage Package Page-------------*/
	
//	Method to click pilgrimage pack
	public void clickPilgrimagePack() {
		pilgrimagePack.click();
	}
	
//	Method to click arrow key
	public void clickArrowKey() {
		arrowKey.click();
	}
	
//	Method to return error message
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
