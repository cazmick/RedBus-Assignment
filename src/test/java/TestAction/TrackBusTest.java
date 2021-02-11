package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.TrackBusLocators;
import in.RedBus.Utils.RequiredExecution;

public class TrackBusTest extends Driver {
	public final static Logger logger = Logger.getLogger(TrackBusTest.class);
	public static String sheetName = prop.getProperty("SheetTrackBus");

	@Test
	public void TrackDetails() throws Exception {
		logger.info("------------------------------TRACK BUS SCENARIO-------------------------");
		extentTest = extent.startTest("TrackDetails");
		String TestCase = "trackBus";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, TestCase);
		RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		TrackBusLocators trackBus = new TrackBusLocators(driver);
		trackBus.Know_More();
		trackBus.Details_TrackBus(testData.get("Ticket No"), testData.get("Email"));
		Assert.assertEquals(driver.getTitle(), "");

	}

}
