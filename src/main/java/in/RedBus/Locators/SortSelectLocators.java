package in.RedBus.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class SortSelectLocators extends PageObject {

	public SortSelectLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Fare")
	WebElement sort_fare;

	@FindBy(xpath = "//div[@class='button view-seats fr']")
	WebElement seat_select;
																		//Sort Selector Locator
	@FindBy(xpath = "//canvas[@xpath='1']")
	WebElement action_cursor;

	public void sortFare() {
		exWait(sort_fare);
		sort_fare.click();
	}
																				//Sort Methods
	public void seatSelect() throws Exception {
		exWait(seat_select);
		seat_select.click();

//		Actions action = new Actions(driver);
//		action.moveToElement(seat_select).click().perform();
	}

	public void cursorAction() {
		Actions action = new Actions(driver);
		action.moveByOffset(822, 595).contextClick();

	}
}
