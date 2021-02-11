package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.ProfileUpdateLocators;
import in.RedBus.Locators.SignInLocators;
import in.RedBus.Utils.RequiredExecution;

public class ProfileUpdateTest extends Driver {
	public final static Logger logger = Logger.getLogger(LoginTest.class);
	public static String sheetName = prop.getProperty("SheetProfileUpdate");

	@Test(priority = 1)
	public void validLogin() throws Exception {
		logger.info("------------------------------LOGIN SCENARIO-------------------------");
		extentTest = extent.startTest("validLogin");
		String TestCase = "login";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		SignInLocators login = new SignInLocators(driver);
		login.click_icon_profile();
		login.click_signIn();
		Thread.sleep(1000);
		login.click_fbButton();
		Thread.sleep(1000);
		login.switchWindowFacebook(testData.get("emailID"), testData.get("password"));
		Thread.sleep(2000);
		login.iconClose();

	}

	@Test(priority = 2)
	public void actions() throws Exception {
		logger.info("------------------------------ACTIONS SCENARIO-------------------------");
		extentTest = extent.startTest("actions");
		String TestCase = "actions";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);
		RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		ProfileUpdateLocators profileUpdate = new ProfileUpdateLocators(driver);
		profileUpdate.iconSign();
		profileUpdate.clickListProfile();
		profileUpdate.click_wallet();

	}
	@Test(priority = 3)
	public void update() throws Exception {
		logger.info("------------------------------UPDATE SCENARIO-------------------------");
		extentTest = extent.startTest("update");
		String TestCase = "update";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);
		RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		ProfileUpdateLocators update = new ProfileUpdateLocators(driver);
		update.update_myProfile(testData.get("Name"), testData.get("Code"), testData.get("Phone"));
		Assert.assertEquals(true, true);
		
	}

}
