package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.SignInLocators;
import in.RedBus.Utils.RequiredExecution;

public class InvalidLoginTest extends Driver{
	public final static Logger logger = Logger.getLogger(InvalidLoginTest.class); 
	public static String sheetName = prop.getProperty("SheetinvalidLogin");

	@Test
	public void invalidLogin() throws Exception {
		logger.info("------------------------------INVALID LOGIN SCENARIO-------------------------");
		extentTest = extent.startTest("invalidLogin");
		String TestCase="invalidLogin";
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
		Assert.assertEquals(false, true);
		

	}

}
