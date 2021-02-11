package in.RedBus.Locators;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import in.RedBus.Base.PageObject;

public class SignInLocators extends PageObject {

	public SignInLocators(WebDriver driver) {
		super(driver);

	}

	@FindBy(how = How.XPATH, using = "//i[@id='i-icon-profile']")
	WebElement icon_profile;

	@FindBy(how = How.XPATH, using = "//li[@id='signInLink']")
	WebElement signIn;

	@FindBy(xpath = "//iframe[@class='modalIframe']")
	WebElement frame;
																	//SignIn Locators
	@FindBy(id = "newFbId")
	WebElement facebook_button;

	@FindBy(id = "email")
	WebElement facebook_email;

	@FindBy(id = "pass")
	WebElement facebook_password;

	@FindBy(id = "loginbutton")
	WebElement LogIn_button;

	@FindBy(xpath = "//i[@class='icon-close']")
	WebElement icon_close;

	public void click_icon_profile() {
		exWait(icon_profile);
		icon_profile.click();

	}

	public void click_signIn() {
		exWait(signIn);
		signIn.click();
		exWait(frame);
		switchIFrame(frame);

	}
																			//Sign In Action Methods 
	public void click_fbButton() {
		exWait(facebook_button);
		facebook_button.click();

	}

	public void switchWindowFacebook(String email,String pass) throws Exception {

		String mainHandle = driver.getWindowHandle();

		Set<String> allHandles = driver.getWindowHandles();
		for (String windowHandle : allHandles) {
			if (!mainHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				exWait(facebook_email);
				exWait(facebook_password);
				facebook_email.sendKeys(email);
				exWait(LogIn_button);
				facebook_password.sendKeys(pass);
				LogIn_button.click();
				

			}
			Thread.sleep(3000);
//			driver.switchTo().window(mainHandle);
		}
		driver.switchTo().window(mainHandle);

	}

	public void iconClose() throws Exception {


		icon_close.click();
	}

}
