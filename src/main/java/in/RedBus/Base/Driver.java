package in.RedBus.Base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.LogStatus;

import in.RedBus.Utils.ExcelFileIO;
import in.RedBus.Utils.FileHandling;
import in.RedBus.Utils.Screenshots;

public class Driver extends FileHandling {
	public static WebDriver driver;
	public static ExcelFileIO reader = new ExcelFileIO("./src/test/resources/DataSet.xlsx");
	public static String browser=prop.getProperty("browser");
	public static String browserType=prop.getProperty("browserType");
	public static int wait_value=Integer.parseInt((String) prop.get("implicitWait"));



	public static void driverInitialize() throws Exception {								//Driver initialized 
		if (browser.toLowerCase().equals("chrome")) {										//Action specified Chrome
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			ChromeOptions options = new ChromeOptions();
//			DesiredCapabilities dc = DesiredCapabilities.chrome();
//			 URL url = new URL("http://localhost:4444/wd/hub");
//			 RemoteWebDriver driver = new RemoteWebDriver(url,dc);
//			 options.merge(dc);
			if (browserType.toLowerCase().equals("headless")) {								//Action to handle headless in chrome
				options.addArguments("--window-size=1552,840");
				options.addArguments("--headless");
				options.addArguments("--user-agent=Chrome/88.0.4324.146");
				options.addArguments("disable-infobars");
				options.addArguments("--disable-notifications");
				options.addArguments("enable-automation");
				options.addArguments("--disable-popup-blocking");
				

				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
		} else if (browser.toLowerCase() == "ie") {
			System.setProperty("webdriver.ie.driver", prop.getProperty("iePath")); // IE
																												// doesn't
																												// have
																												// support
																												// for
																												// Headless
																												// Mode
			driver = new InternetExplorerDriver();

		} else if (browser.toLowerCase().equals("firefox")||browser.toLowerCase().equals("ff")) {		//Action to Handle Firefox
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxPath"));
			FirefoxOptions options = new FirefoxOptions();
			if (browserType.toLowerCase() == "headless") {
				options.addArguments("--headless");
				driver = new FirefoxDriver(options);
			} else {
				driver = new FirefoxDriver();
			}

		} else {
			System.out.println("Incompatible Browser Selection");
		}
		driver.manage().timeouts().implicitlyWait(wait_value, TimeUnit.SECONDS);
	}

	public static void openBrowser() throws InterruptedException {					//Method for openBrowser Action

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();		//to maximize the windows size

	}

	@AfterMethod()
	public static void closeBrowser(ITestResult result) throws Exception {			//Method to execute the status of browser and provide status to extentReport

		if (result.getStatus() == ITestResult.FAILURE) {
			// to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
			// to add error/exception in
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			// extent report
			String screenshotPath = Screenshots.getScreenshot(driver,result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			// to add screenshot in extent // report
		 //to add screenshot in extent report
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		// ending test and ends the current test and prepare to create html report
		extent.endTest(extentTest);
		}
		
		@AfterClass
		public static void quitBrowser(){										//Method to close and quit Browser After Test Being Executed
			driver.close();
			driver.quit();
		}
		
//		driver.close();

	

}
