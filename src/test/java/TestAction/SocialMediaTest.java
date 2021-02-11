package TestAction;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.SocialMediaLocators;
import in.RedBus.Utils.RequiredExecution;

public class SocialMediaTest extends Driver {
	public final static Logger logger = Logger.getLogger(SocialMediaTest.class); 
	public static String sheetName = prop.getProperty("SheetSocialMedia");



	
	@Test
	public void social() throws Exception {
		logger.info("------------------------------SOCIAL MEDIA SCENARIO-------------------------");
		extentTest = extent.startTest("social");
		String TestCase="socialMedia";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		SocialMediaLocators socialMedia = new SocialMediaLocators(driver);
		socialMedia.scrollPage();
		socialMedia.switchFacebook();
		socialMedia.scrollPage();
		socialMedia.switchTwitter();
	}

}
