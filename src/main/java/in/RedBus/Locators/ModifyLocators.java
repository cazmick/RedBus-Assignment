package in.RedBus.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class ModifyLocators extends PageObject {

	public ModifyLocators(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='close']")
	WebElement icon_close;

	@FindBy(xpath = "//div[contains(text(),'Modify')]")
	WebElement modify_button;

	@FindBy(xpath = "//input[@id='dest']")							//Modify Locators
	WebElement modify_destination;

	@FindBy(xpath = "//button[@class=' button ms-btn']")
	WebElement modify_interact_dest;

	@FindBy(xpath = "//input[@id='onward_cal']")
	WebElement date_tab;

	public void icon_close() {
		exWait(icon_close);
		icon_close.click();
	}

	public void click_modify() {
		exWait(modify_button);
		modify_button.click();
	}																		//Modify Methods

	public void modify_dest(String update_dest) throws Exception {

		exWait(modify_destination);
//		checkClickableExplicitly(modify_destination, 10);
		modify_destination.clear();
		modify_destination.sendKeys(update_dest);

	}

	public void modify_date() {
		exWait(date_tab);
		checkClickableExplicitly(date_tab, 10);
		date_tab.click();
		DMY("21", "Apr 2021");
//		date_tab.click();

	}

	public void modify_search() {
		exWait(modify_interact_dest);
		modify_interact_dest.click();
	}

}
