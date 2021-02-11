package in.RedBus.Locators;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import in.RedBus.Base.PageObject;

public class TermsConditionLocators extends PageObject {

	public TermsConditionLocators(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'T & C')]")
	WebElement TandC_buttons;

	@FindBy(how = How.XPATH, using = "//b[contains(text(),'View Passenger Guidelines.')]")
	WebElement passengerGuideline;
																									//Terms and Condition Locator	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Assam')]")
	WebElement Assam;

	public void TermsAndCondition() throws InterruptedException {
		scrollElement(TandC_buttons);
		exWait(TandC_buttons);
		TandC_buttons.click();

	}

	public void GuideLine() {
		exWait(passengerGuideline);
		passengerGuideline.click();
	}
																										//Terms and Condition methods
	public void SwitchTabs() throws InterruptedException {

		// driver.switchTo().frame(frame);

		String mainWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		for (String childWindow : handles) {

			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);

				GuideLine();
				scrollElement(Assam);
				Assam.click();
			}

			Thread.sleep(1000);
			driver.switchTo().window(mainWindow);
		}
		
	}

}
