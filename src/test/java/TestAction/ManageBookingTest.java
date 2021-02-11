package TestAction;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.istack.logging.Logger;

import in.RedBus.Base.Driver;
import in.RedBus.Locators.ManageBookingLocators;
import in.RedBus.Utils.RequiredExecution;

public class ManageBookingTest extends Driver{
	public final static Logger logger = Logger.getLogger(ManageBookingTest.class); 
	public static String sheetName = prop.getProperty("SheetManageBooking");
	
	@Test(priority = 1)
	public void TicketCancel() throws Exception {
		logger.info("------------------------------TICKET CANCEL SCENARIO-------------------------");
		extentTest = extent.startTest("TicketCancel");
		String TestCase="ticketCancel";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
		Driver.driverInitialize();
		Driver.openBrowser();
		ManageBookingLocators manageBook = new ManageBookingLocators(driver);
		manageBook.ManageBooking();
		manageBook.cancelClick();
		manageBook.sendEmailone(testData.get("email"));
		manageBook.sendTicketone(testData.get("Ticket"));
		manageBook.selectPassengerButton();
		Assert.assertEquals(true, false);
	
	}
	
	@Test(priority = 2)
	public void RescheduleBooking() throws Exception {
		logger.info("------------------------------RESCHEDULR BOOKING SCENARIO-------------------------");
		extentTest = extent.startTest("Reschedule Booking");
		String TestCase="rescheduleBooking";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        TicketCancel();
		ManageBookingLocators manageBook = new ManageBookingLocators(driver);
		manageBook.ManageBooking();
		manageBook.clickReschedule();
		manageBook.sendEmailtwo(testData.get("email"));
		manageBook.sendTickettwo(testData.get("Ticket"));
		manageBook.rescheduleButton();
		Assert.assertEquals(true, false);
	
	}
	
	@Test(priority = 3)
	public void MyTicket() throws Exception {
		logger.info("------------------------------MY TICKET SCENARIO-------------------------");
		extentTest = extent.startTest("MyTicket");
		String TestCase="myTicket";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        RescheduleBooking();
		ManageBookingLocators manageBook = new ManageBookingLocators(driver);
		
		manageBook.ManageBooking();
		manageBook.clickShowTicket();
		manageBook.sendEmailthree(testData.get("email"));
		manageBook.sendTicketthree(testData.get("Ticket"));
		manageBook.searchButton();
		Assert.assertEquals(true, false);
		
	}
	
	@Test(priority = 4)
	public void SMS_Ticket() throws Exception {
		logger.info("------------------------------SMS TICKET SCENARIO-------------------------");
		extentTest = extent.startTest("SMS_Ticket");
		String TestCase="sms";
        HashMap<String,String>testData = new HashMap<String,String>();        
        testData=reader.getRowTestData(sheetName,TestCase);
        RequiredExecution.tocheckExecutionRequired(testData.get("Execution"), TestCase);
        MyTicket();
		ManageBookingLocators manageBook = new ManageBookingLocators(driver);
		manageBook.ManageBooking();
		manageBook.clickSms();
		manageBook.sendEmailthree(testData.get("email"));
		manageBook.sendTicketthree(testData.get("email"));
		manageBook.searchButton();
		Assert.assertEquals(true, false);
		
		
	}
	
	

}
