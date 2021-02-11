package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.BecameOperatorLocators;
import in.RedBus.Utils.RequiredExecution;

public class BecameOperatorTest extends Driver {
	public final static Logger logger = Logger.getLogger(BecameOperatorTest.class); 
	public static String sheetName = prop.getProperty("SheetBecomeOperator");
	
	@Test
	public void BecameOperator() throws Exception {
		logger.info("------------------------------BECOME OPERATOR SCENARIO-------------------------");
		extentTest = extent.startTest("BecameOperator");
		String TestCase="BecomeOperator";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		BecameOperatorLocators becameOperator = new BecameOperatorLocators(driver);
		becameOperator.BusHire();
		becameOperator.click_becomeAnOperator();
		becameOperator.signUp_BusHireOperator(testData.get("Name"),testData.get("Company"),testData.get("OperatorName"),testData.get("City"),testData.get("Mobile"),testData.get("AltMobile"),testData.get("Email"),testData.get("AltEmail"),testData.get("PAN"),testData.get("GST"));
		Assert.assertEquals(driver.getTitle(), testData.get("Expected_Result"));
		
	}

}
