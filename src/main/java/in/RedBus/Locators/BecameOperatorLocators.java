package in.RedBus.Locators;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import in.RedBus.Base.PageObject;

public class BecameOperatorLocators extends PageObject {

	public BecameOperatorLocators(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.LINK_TEXT, using = "BUS HIRE")
	WebElement Bushire;

	@FindBy(how = How.XPATH, using = "//div[@class='_3VcoR-iRCX0iy6hxaxf6ER']")
	WebElement scrollElement;

	@FindBy(how = How.XPATH, using = "//div[@class='_254VH5WNgWgjclgRRPngBJ']")
	WebElement BecomeAnOperator;

	@FindBy(how = How.ID, using = "Name")
	WebElement CompanyName;

	@FindBy(how = How.ID, using = "OperatorName")
	WebElement operatorName;
																		//Became operator Locators
	@FindBy(how = How.ID, using = "City")
	WebElement City;

	@FindBy(how = How.ID, using = "PrimaryPhNumber")
	WebElement MobileNumber;

	@FindBy(how = How.ID, using = "AlternatePhNumber")
	WebElement Alternate_MobileNumber;

	@FindBy(how = How.ID, using = "EmailAddress")
	WebElement emailid;

	@FindBy(how = How.ID, using = "AlternateEmailAddress")
	WebElement Alternate_emailId;

	@FindBy(how = How.ID, using = "OperatorAddress")
	WebElement FullAddress;

	@FindBy(how = How.ID, using = "PAN")
	WebElement PAN_Number;

	@FindBy(how = How.ID, using = "GSTIN")
	WebElement GSTIN_Number;

	@FindBy(how = How.XPATH, using = "//div[@id='submitFormDetails']")
	WebElement Submit_button;

	public void BusHire() throws InterruptedException {
		Bushire.click();
		Thread.sleep(1000);
		scrollElement(scrollElement);

	}

	public void click_becomeAnOperator() throws Exception {

		BecomeAnOperator.click();
	}

	public void sendComapanyName(String bo_Company) {
		CompanyName.sendKeys(bo_Company);
	}

	public void sendOperator(String bo_Operator) {
		operatorName.sendKeys(bo_Operator);
	}

	public void sendCity(String bo_city) {
		City.sendKeys(bo_city);
	}

	public void sendMobile(String bo_mobile) {
		MobileNumber.sendKeys(bo_mobile);
	}

	public void sendAlternateMob(String bo_altMobile) {
		Alternate_MobileNumber.sendKeys(bo_altMobile);
	}

	public void sendEmail(String bo_email) {
		emailid.sendKeys(bo_email);
	}
																		//Became operator methods
	public void sendAltEmail(String bo_altEmail) {
		Alternate_emailId.sendKeys(bo_altEmail);
	}

	public void sendAddress(String bo_address) {
		FullAddress.sendKeys(bo_address);
	}

	public void sendPAN(String bo_PAN) {
		PAN_Number.sendKeys(bo_PAN);
	}

	public void sendGST(String bo_Gst) {
		GSTIN_Number.sendKeys(bo_Gst);
	}

	public void click_Submit() {
		Submit_button.click();
	}

	public void signUp_BusHireOperator(String cmpny,String operator,String city,String mobile,String altMobile,String email,String altEmail,String address,String Pan,String gst) throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				sendComapanyName(cmpny);
				sendOperator(operator);
				sendCity(city);
				sendMobile(mobile);
				sendAlternateMob(altMobile);
				sendEmail(email);
				sendAltEmail(altEmail);
				sendAddress(address);
				sendPAN(Pan);
				sendGST(gst);
				click_Submit();
				Thread.sleep(1000);
				// driver.close();
			}

			Thread.sleep(1000);
		}
		driver.switchTo().window(mainWindow);
	}

}
