package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* ---------------Finding Login Page Web Elements using Locators------------------ */

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	public WebElement profile;
	
	@FindBy(how = How.ID, using = "signInLink")
	public WebElement signIn;
	
	@FindBy(how = How.ID, using = "g_id_onload")
	public WebElement signInGoogle;
	
	@FindBy(how = How.ID, using = "identifierId")
	public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//span[@class='VfPpkd-vQzf8d']")
	public WebElement next;
	
	@FindBy(how = How.NAME, using = "password")
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement closeIcon;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'My Profile')]")
	public WebElement myProfile;
	
	@FindBy(how = How.ID, using = "displayname")
	public WebElement profileName;	
	
	@FindBy(how = How.XPATH, using = "//div[@class='o6cuMc']")
	public WebElement errorAccount;
	
	@FindBy(how = How.XPATH, using = "//div[@jsname='B34EJ']")
	public WebElement errorPassword;
	
	
//	Method to click profile button
	public void clickProfile() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//i[@id='i-icon-profile']"))));
		profile.click();
	}
	
//	Method to click sign in button
	public void clickSignIn() throws InterruptedException {
		signIn.click();
		driver.switchTo().frame(driver.findElement(By.className("modalIframe")));
		Thread.sleep(2000);
		
	}
	
//	Method to click sign in with google button
	public void clickSignInGoogle() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(signInGoogle));
		signInGoogle.click();
	}
	
//	Method to enter email address
	public void enterEmail(String e) {
		email.sendKeys(e);
	}
	
//	Method to return error account message
	public String errorAccountMessage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(errorAccount));
		return errorAccount.getText();
	}
	
//	Method to return error password message
	public String errorPasswordMessage() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(errorPassword));
		return errorPassword.getText();
	}
	
//	Method to click next button
	public void clickNext() {
		next.click();
	}
	
//	Method to enter password
	public void enterPassword(String p) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
		password.sendKeys(p);
	}
	
//	Method to click close icon option
	public void clickCloseIcon() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(closeIcon));
		closeIcon.click();
	}
	
//	Method to reload page
	public void reloadPage() {
		driver.navigate().refresh();
		driver.navigate().to(driver.getCurrentUrl());
	}
	
//	Method to click my profile option
	public void clickMyProfile() {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(myProfile));
		myProfile.click();
	}
	
//	Method to return profile name
	public String getProfileName() {
		return profileName.getText();
	}
	
}
