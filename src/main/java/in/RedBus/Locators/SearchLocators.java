package in.RedBus.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import in.RedBus.Base.PageObject;

public class SearchLocators extends PageObject {

	public SearchLocators(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='src']")
	WebElement source;

	@FindBy(xpath = "//li[@data-no='1']")
	WebElement interact_src;

	@FindBy(xpath = "//li[@data-no='1']")
	WebElement interact_dest;
																					//Search Locators
	@FindBy(xpath = "//input[@id='dest']")
	WebElement destination;

	@FindBy(xpath = "//input[@id='onward_cal']")
	WebElement date_tab;

	@FindBy(xpath = "//button[@id='search_btn']")
	WebElement search_button;

	public void enter_source(String source_val) {
		exWait(source);
		source.sendKeys(source_val);
		exWait(interact_src);
		interact_src.click();
//		Thread.sleep(2000);
	}
																					//Search Actions Method
	public void enter_dest(String dest_val) {
		exWait(destination);
		destination.sendKeys(dest_val);
		exWait(interact_dest);
		interact_dest.click();

	}

	public void select_date(String date,String month,String year) {
		exWait(date_tab);
		date_tab.click();
		DMY(date, month+" "+year);

	}

	public void search_button() {
		exWait(search_button);
		search_button.click();
	}

}
