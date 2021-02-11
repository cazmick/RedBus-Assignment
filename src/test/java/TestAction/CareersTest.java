package TestAction;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.CareersLocators;
import in.RedBus.Utils.RequiredExecution;

public class CareersTest extends Driver {
	public final static Logger logger = Logger.getLogger(CareersTest.class); 
	public static String sheetName = prop.getProperty("SheetCareerSite");
	
	@Test
	public void carrerPage() throws Exception {
		logger.info("-------------------------CARRER PAGE SCENARIO---------------------- ");
		extentTest = extent.startTest("carrerPage");

		String TestCase="careerSite";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		extentTest = extent.startTest("carrerPage");
		Driver.openBrowser();
		CareersLocators career = new CareersLocators(driver);
		career.carrersButton();
		career.switchCarrer();
		
		
	}
	

}
