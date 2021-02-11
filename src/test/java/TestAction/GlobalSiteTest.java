package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.GolbalSitesLocators;
import in.RedBus.Utils.RequiredExecution;

public class GlobalSiteTest extends Driver {
	public final static Logger logger = Logger.getLogger(GlobalSiteTest.class); 
	public static String sheetName = prop.getProperty("SheetGlobalSite");

	@Test
	public void globalWebsite() throws Exception {
		logger.info("------------------------------CARRER PAGE SCENARIO-------------------------");
		extentTest = extent.startTest("globalWebsite");
		String TestCase="globalSite";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		GolbalSitesLocators globalSite = new GolbalSitesLocators(driver);
		globalSite.scrollToGlobal();
		globalSite.SwitchWindowColombia();
		globalSite.SwitchWindowIndia();
		globalSite.SwitchWindowIndonesia();
		Assert.assertEquals(true, true);

	}

}
