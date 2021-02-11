package TestAction;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.TermsConditionLocators;
import in.RedBus.Utils.RequiredExecution;

public class TermsConditionTest extends Driver{
	public final static Logger logger = Logger.getLogger(TermsConditionTest.class); 
	public static String sheetName = prop.getProperty("SheetTC");
	
	@Test
	public void TandC() throws Exception {
		logger.info("------------------------------TERMS AND CONDITION PAGE-------------------------");
		extentTest = extent.startTest("TandC");
		String TestCase="termsCondition";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		TermsConditionLocators termsCondition = new TermsConditionLocators(driver);
		termsCondition.TermsAndCondition();
		System.out.println(driver.getTitle());
		termsCondition.SwitchTabs();
		
		
		
	}

}
