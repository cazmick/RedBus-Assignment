package in.RedBus.Locators;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import in.RedBus.Base.PageObject;

public class GolbalSitesLocators extends PageObject {

	public GolbalSitesLocators(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//span[@class='flagicon icon-COL']")
	WebElement Tab_Colombia;
	@FindBy(how = How.XPATH, using = "//a[@class='redbus-logo home-redirect']")
	WebElement redBus_logo;																	//Global Sites Locators
	@FindBy(how = How.XPATH, using = "//span[@class='flagicon icon-IND']")
	WebElement Tab_India;
	@FindBy(how = How.XPATH, using = "//span[@class='flagicon icon-IDN']")
	WebElement Tab_Indonesia;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Our Global Presence')]")
	WebElement elementtoScroll;

	public void scrollToGlobal() {
		scrollElement(elementtoScroll);
	}

	public void SwitchWindowColombia() throws InterruptedException {

		String mainWindow = driver.getWindowHandle();
		exWait(Tab_Colombia);
		Tab_Colombia.click();
		Set<String> handles = driver.getWindowHandles();

		for (String childWindow : handles) {

			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				String actualTitle = driver.getTitle();
				String expectedTitle = "Compra Pasajes de Bus Online - redBus Colombia";
				assertEquals(expectedTitle, actualTitle);
				driver.close();
			}
			driver.switchTo().window(mainWindow);
		}
	}
																					//Global Sites Methods
	public void SwitchWindowIndia() {
		String mainWindow = driver.getWindowHandle();
		exWait(Tab_India);
		Tab_India.click();
		Set<String> handles = driver.getWindowHandles();

		for (String childWindow : handles) {

			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				String actualTitle = driver.getTitle();
				String expectedTitle = "Book Bus Travels, AC Volvo Bus, rPool & Bus Hire - redBus India";
				assertEquals(expectedTitle, actualTitle);
				driver.close();
			}
			driver.switchTo().window(mainWindow);
		}
	}

	public void SwitchWindowIndonesia() {
		String mainWindow = driver.getWindowHandle();
		exWait(Tab_Indonesia);
		Tab_Indonesia.click();
		Set<String> handles = driver.getWindowHandles();

		for (String childWindow : handles) {

			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				String actualTitle = driver.getTitle();
				String expectedTitle = "Pesan Tiket Bus Online, AKAP, dan Shuttle - redBus.id";
				assertEquals(expectedTitle, actualTitle);
				driver.close();
			}

		}
		driver.switchTo().window(mainWindow);
	}

}
