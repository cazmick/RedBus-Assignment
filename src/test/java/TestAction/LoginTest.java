package TestAction;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.SignInLocators;
import in.RedBus.Utils.RequiredExecution;

public class LoginTest extends Driver {
	public final static Logger logger = Logger.getLogger(LoginTest.class); 
	public static String sheetName = prop.getProperty("SheetLogin");
	
	
	@Test
	public void validLogin() throws Exception {
		logger.info("------------------------------VALID LOGIN SCENARIO-------------------------");
		extentTest = extent.startTest("validLogin");
		String TestCase="validLogin";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        Driver.driverInitialize();
		Driver.openBrowser();
		SignInLocators login = new SignInLocators(driver);
		login.click_icon_profile();
		login.click_signIn();
		Thread.sleep(1000);
		login.click_fbButton();
		Thread.sleep(1000);
		login.switchWindowFacebook(testData.get("emailID"),testData.get("password"));
		Thread.sleep(2000);
		login.iconClose();
		Assert.assertEquals(driver.getTitle(), testData.get("Expected_Result"));

	}
	


}
