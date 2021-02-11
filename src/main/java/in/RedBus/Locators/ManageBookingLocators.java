package in.RedBus.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import in.RedBus.Base.PageObject;

public class ManageBookingLocators extends PageObject {

	public ManageBookingLocators(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.XPATH, using = "//div[@class='manageHeaderLbl']")
	WebElement managebooking;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel')]")
	WebElement Cancel;

	@FindBy(how = How.NAME, using = "tin")
	WebElement Ticketno_Element1;
																				//Manage Booking Locators
	@FindBy(how = How.NAME, using = "email")
	WebElement email_Element1;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Select Passengers')]")
	WebElement selectPassenger_button;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ticketSearch']")
	WebElement reschedule_button;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Reschedule')]")
	WebElement reschedule;

	@FindBy(how = How.XPATH, using = " //input[@id='searchTicket']")
	WebElement TicketNo_Element2;

	@FindBy(how = How.XPATH, using = "//input[@id='searchEmail']")
	WebElement email_Element2;

	@FindBy(how = How.XPATH, using = "//input[@id='ticketSearch']")
	WebElement Search_button;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show My Ticket')]")
	WebElement ShowMyTicket;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketTIN']")
	WebElement Ticketno_Element3;

	@FindBy(how = How.XPATH, using = "//input[@id='searchTicketEmail']")
	WebElement email_Element3;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Email/SMS')]")
	WebElement SMS_Element;
	
	public void rescheduleButton() {
		reschedule_button.click();
	}

	public void ManageBooking() {
		exWait(managebooking);
		managebooking.click();

	}

	public void cancelClick() {
		exWait(Cancel);
		Cancel.click();
	}
																				//Manage Booking Methods
	public void sendTicketone(String ticket_one) {
		exWait(Ticketno_Element1);
		Ticketno_Element1.sendKeys(ticket_one);
	}

	public void sendEmailone(String email_one) {
		exWait(email_Element1);
		email_Element1.sendKeys(email_one);
	}

	public void selectPassengerButton() {
		exWait(selectPassenger_button);
		selectPassenger_button.click();
	}

	public void clickReschedule() {
		exWait(reschedule);
		reschedule.click();
	}

	public void sendTickettwo(String ticket_two) {
		exWait(TicketNo_Element2);
		TicketNo_Element2.sendKeys(ticket_two);
	}

	public void sendEmailtwo(String email_two) {
		exWait(email_Element2);
		email_Element2.sendKeys(email_two);
	}

	public void searchButton() {
		exWait(Search_button);
		Search_button.click();
	}

	public void clickShowTicket() {
		exWait(ShowMyTicket);
		ShowMyTicket.click();
	}

	public void sendTicketthree(String ticket_three) {
		exWait(Ticketno_Element3);
		Ticketno_Element3.sendKeys(ticket_three);
	}

	public void sendEmailthree(String email_three) {
		exWait(email_Element3);
		email_Element3.sendKeys(email_three);
	}

	public void clickSms() {
		exWait(SMS_Element);
		SMS_Element.click();
	}

}
