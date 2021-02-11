package in.RedBus.Locators;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class SocialMediaLocators extends PageObject {

	public SocialMediaLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[@class='fbicon icon-Facebook']")
	WebElement facebook;
																				//Social Media Locators
	@FindBy(xpath = "//span[@class='twittericon icon-Twitter']")
	WebElement twitter;

	public void scrollPage() {
		scroll();
	}

	public void facebookClick() {
		exWait(facebook);
		facebook.click();
	}
																					//Social Media Actions
	public void twitterClick() {
		exWait(twitter);
		twitter.click();
	}

	public void switchFacebook() {
		String mainHandle = driver.getWindowHandle();
		facebookClick();
		Set<String> allHandles = driver.getWindowHandles();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,250)");
		for (String windowHandle : allHandles) {
			if (!mainHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				driver.getTitle();
				driver.close();

			}
			driver.switchTo().window(mainHandle);

		}
	}

	public void switchTwitter() {
		String mainHandle = driver.getWindowHandle();
		twitterClick();
		Set<String> allHandles = driver.getWindowHandles();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,250)");
		for (String windowHandle : allHandles) {
			if (!mainHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				driver.getTitle();
				driver.close();

			}
			driver.switchTo().window(mainHandle);

		}
	}

}
