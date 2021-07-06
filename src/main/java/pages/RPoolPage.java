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

public class RPoolPage {

	WebDriver driver;

	public RPoolPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding RPool Page Web Elements using Locators------------------ */
	
	@FindBy(how = How.XPATH, using = "//a[@id='cars']")
	public WebElement rPool;

	@FindBy(how = How.XPATH, using = "//div[@class='youTubeVideo']")
	public WebElement youtube;

	@FindBy(how = How.XPATH, using = "//*[@id=\"movie_player\"]/div[4]/button")
	WebElement playVideo;
	

//	Method to click Rpool
	public void clickRPool() {
		rPool.click();
	}
	
//	Method to switch to other frame
	public void switchFrame() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	       
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"aboutRpool\"]/div/div[1]/div[2]/div/div/iframe"));
        js.executeScript("arguments[0].scrollIntoView();", frame);
        driver.switchTo().frame(frame);
	}

//	Method to click play video button
	public void clickPlay() {
		(new WebDriverWait(driver, 20)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"movie_player\"]/div[4]/button")));

		playVideo.click();

	}
}
