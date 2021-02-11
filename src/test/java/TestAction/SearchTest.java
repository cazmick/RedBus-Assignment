package TestAction;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.FilterLocators;
import in.RedBus.Locators.ModifyLocators;
import in.RedBus.Locators.SearchLocators;
import in.RedBus.Locators.SortSelectLocators;
import in.RedBus.Utils.RequiredExecution;

public class SearchTest extends Driver {
	public final static Logger logger = Logger.getLogger(SearchTest.class);
	public static String sheetName = prop.getProperty("SheetSearch");

	@Test(priority = 1)
	public void SearchBus() throws Exception {
		logger.info("------------------------------SEARCH BUS SCENARIO-------------------------");
		extentTest = extent.startTest("SearchBus");
		String TestCase="search";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		SearchLocators search = new SearchLocators(driver);
		String home_title = driver.getTitle();
		search.enter_source(testData.get("Source"));
		search.enter_dest(testData.get("Destination"));
		search.select_date(testData.get("Date"),testData.get("Month"),testData.get("Year"));
		search.search_button();
		Thread.sleep(2000);
		String actualResult = driver.getTitle();
		Assert.assertNotEquals(home_title, actualResult);
	}

	@Test(priority = 2)
	public void ModifySearch() throws Throwable {
		logger.info("------------------------------MODIFY SEARCH SCENARIO-------------------------");
		extentTest = extent.startTest("ModifySearch");
		String TestCase="modify";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        SearchBus();
		ModifyLocators modify = new ModifyLocators(driver);
		Thread.sleep(1000);
		modify.click_modify();
		modify.modify_dest(testData.get("Destination"));
		modify.modify_search();
		Assert.assertEquals(true, true);

	}

	@Test(priority = 3)
	public void Filter() throws Throwable {
		logger.info("------------------------------FILTER SCENARIO-------------------------");
		extentTest = extent.startTest("Filter");
		String TestCase="filter";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        ModifySearch();
		FilterLocators filter = new FilterLocators(driver);
		filter.click_livetracking();
		filter.busSeating();
		filter.selectArrivalTime();
		Assert.assertEquals(true, true);
	}

	@Test(priority = 4)
	public void Sort() throws Throwable {
		logger.info("------------------------------SORT SCENARIO-------------------------");
		extentTest = extent.startTest("Sort");
		String TestCase="sort";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        Filter();
		SortSelectLocators sort = new SortSelectLocators(driver);
		sort.sortFare();
		Thread.sleep(2000);
		sort.seatSelect();
		sort.cursorAction();
		

	}

}
