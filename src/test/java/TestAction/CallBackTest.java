package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.CallBackLocators;
import in.RedBus.Utils.RequiredExecution;

public class CallBackTest extends Driver {
	public final static Logger logger = Logger.getLogger(CallBackTest.class); 
	public static String sheetName = prop.getProperty("SheetCallBack");

	@Test
	public void CallBackForm() throws Exception {
		logger.info("------------------------------CALL BACK SCENARIO-------------------------");
		extentTest = extent.startTest("CallBackForm");
		String TestCase="callBack";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		CallBackLocators callBack = new CallBackLocators(driver);
		callBack.clickBus();
		callBack.ClickCommute();
		callBack.switchwin(testData.get("Name"),testData.get("Contact"),testData.get("Email"),testData.get("Organisation"));
		Assert.assertEquals(true, false);
	}

}
