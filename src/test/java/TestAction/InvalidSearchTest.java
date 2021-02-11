package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.SearchLocators;
import in.RedBus.Utils.RequiredExecution;

public class InvalidSearchTest extends Driver {
	public final static Logger logger = Logger.getLogger(InvalidSearchTest.class); 
	public static String sheetName = prop.getProperty("SheetSearch");
	@Test
	public void invalidSearchBus() throws Exception {
		logger.info("------------------------------INVALID SEARCH BUS SCENARIO-------------------------");
		extentTest = extent.startTest("invalidSearchBus");
		String TestCase="invalidSearch";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		SearchLocators search = new SearchLocators(driver);
		String home_title = driver.getTitle();
		System.out.println(home_title);
		search.enter_source(testData.get("Source"));
		search.enter_dest(testData.get("Destination"));
		search.search_button();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), testData.get("Expected_Result"));
	}

}
