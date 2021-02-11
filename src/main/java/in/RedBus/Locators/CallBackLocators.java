package in.RedBus.Locators;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class CallBackLocators extends PageObject{

	public CallBackLocators(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//a[contains(text(),'BUS HIRE')]")
	WebElement busHire;
	
	@FindBy(xpath = "//div[contains(text(),'Verified Drivers and Vehicles')]")
	WebElement scrollCommute;
	
	@FindBy(className = "_37v4jd2t38Bgz56yFS_OXA")
	WebElement rCommuteButton;
	
	@FindBy(xpath = "//button[@id='rcommute_request_call_back']")
	WebElement callBackButton;
	
	@FindBy(xpath = "//input[@placeholder='YOUR NAME']")
	WebElement yourName;
																					//CallBack Locators
	@FindBy(xpath = "//input[@placeholder='YOUR CONTACT NUMBER']")
	WebElement yourContact;
	
	@FindBy(xpath = "//input[@placeholder='YOUR EMAIL ID']")
	WebElement yourEmail;
	
	@FindBy(xpath = "//input[@placeholder='ORGANISATION NAME']")
	WebElement organisationName;
	
	@FindBy(xpath = "//iframe[@role='presentation']")
	WebElement captchaFrame;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement captcha;
	
	@FindBy(xpath = "//button[@id='rcommute_form_submit']")
	WebElement submitButton;
	
	public void clickBus() {
		exWait(busHire);
		busHire.click();
	}
	public void ClickCommute() {
		scrollElement(scrollCommute);
		exWait(rCommuteButton);
		rCommuteButton.click();
	}
	
	public void CallButtonClick() {
		exWait(callBackButton);
		callBackButton.click();
	}
	public void enterName(String cb_Name) {
		exWait(yourName);
		yourName.sendKeys(cb_Name);
	}
	public void enterContact(String cb_Contact) {
		exWait(yourContact);
		yourContact.sendKeys(cb_Contact);
	}
	public void enterEmail(String cb_email) {
		exWait(yourEmail);															//Call Back Action Methods
		yourEmail.sendKeys(cb_email);
	}
	public void enterOrgName(String cb_orgName) {
		exWait(organisationName);
		organisationName.sendKeys(cb_orgName);
	}
	public void captchClick() throws Exception {
		driver.switchTo().frame(captchaFrame);
		captcha.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}
	public void clicksubmit() {
		exWait(submitButton);
		submitButton.click();
	}
	
	public void switchwin(String name,String contact,String email,String Org) throws Exception {
		String mainHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,250)");
		for (String windowHandle : allHandles) {
			if (!mainHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				
				CallButtonClick();
				enterName(name);
				enterContact(contact);
				enterEmail(email);
				enterOrgName(Org);
				captchClick();
				clicksubmit();
				
				

			}
			driver.switchTo().window(mainHandle);

		}
	}
	
	

}
