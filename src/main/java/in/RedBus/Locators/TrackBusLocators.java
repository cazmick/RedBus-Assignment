package in.RedBus.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import in.RedBus.Base.PageObject;

public class TrackBusLocators extends PageObject {

	public TrackBusLocators(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='subtext_Tmb']")
	WebElement ScrollElement;
							
	@FindBy(how = How.XPATH, using = "//a[@class='know_more']")
	WebElement KnowMore_button;
																							//Locators for TrackBus
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Ticket No']")
	WebElement TicketNo;

	@FindBy(how = How.XPATH, using = "//div//input[@placeholder='Email Id']")
	WebElement Email;

	@FindBy(how = How.XPATH, using = "//input[@class='search_btn']")
	WebElement Search_Button;

	public void Know_More() throws InterruptedException {
		scrollElement(ScrollElement);
		exWait(KnowMore_button);
		KnowMore_button.click();
	}
																								//TrackBus Action Methods
	public void Details_TrackBus(String number, String email) {
		// driver.switchTo().frame(Frame);
		TicketNo.sendKeys(number);
		Email.sendKeys(email);
		Search_Button.click();
	}

}
