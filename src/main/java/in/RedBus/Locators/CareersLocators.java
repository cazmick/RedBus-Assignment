package in.RedBus.Locators;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class CareersLocators extends PageObject {

	public CareersLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Careers")
	WebElement carrers;

	@FindBy(xpath = "//a[@id='scroll-aHref-1']")
	WebElement ourCrew;
																									//Career Page Locators
	@FindBy(linkText = "Life at redBus")
	WebElement lifeRedbus;

	@FindBy(linkText = "Jobs")
	WebElement jobs;

	public void carrersButton() {
		
		scroll();
		exWait(carrers);
		carrers.click();
	}

	public void crewButton() {
		exWait(ourCrew);

		ourCrew.click();
	}

	public void lifeRedbusButton() {
		exWait(lifeRedbus);
		lifeRedbus.click();
	}

	public void jobsButton() {
		exWait(jobs);
		jobs.click();
	}
	
	public void switchCarrer() {
		String mainHandle = driver.getWindowHandle();
		Set<String> allHandles = driver.getWindowHandles();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,250)");
		for (String windowHandle : allHandles) {											//Career Page Action Method
			if (!mainHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				crewButton();
				lifeRedbusButton();
				jobsButton();
				driver.close();

			}
			driver.switchTo().window(mainHandle);

		}
	}

}
