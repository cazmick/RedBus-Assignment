package in.RedBus.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class FilterLocators extends PageObject {

	public FilterLocators(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//i[@class='icon icon-close c-fs']")
	WebElement close;

	@FindBy(xpath = "//ul[@class='addn-filters']//span[contains(text(),'Live Tracking')]")
	WebElement live_tracking;

	@FindBy(xpath = "//ul[@class='addn-filters']//span[contains(text(),'Red Deals')]")
	WebElement red_deals;
																												//Filter Locators
	@FindBy(xpath = "//ul[@class='addn-filters']//span[contains(text(),'Reschedulable')]")
	WebElement reschedulable;

	@FindBy(xpath = "//label[@for='dtAfter 6 pm' and @class='custom-checkbox']")
	WebElement dt_after6pm;

	@FindBy(xpath = "//label[@for='bt_SEATER' and @title='SEATER']")
	WebElement bus_type_seater;

	@FindBy(xpath = "//label[@for='atBefore 6 am' and @class='custom-checkbox']")
	WebElement at_before6am;

	public void click_livetracking() {
		exWait(live_tracking);
		live_tracking.click();
	}
																											//Filter Methods
	public void busSeating() throws Exception {
		exWait(bus_type_seater);
		bus_type_seater.click();
	
	}

	public void selectArrivalTime() {
		exWait(dt_after6pm);
		dt_after6pm.click();
	}

}
