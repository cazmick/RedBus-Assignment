package in.RedBus.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class FileHandling {
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static File file = new File("./src/test/resources/configuration.properties");		//configuration file path
	public static FileInputStream fis = null;
	public static Properties prop = new Properties();
	static {
		try {
			fis = new FileInputStream(file);						//converting configuration to file format

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		try {
			prop.load(fis);											//load the data from configuration file
		} catch (IOException el) {
			el.printStackTrace();

		}

	}
	
	@BeforeTest
	public void setExtent() {										//cache the System property
	extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "kanishkamogha");
	extent.addSystemInfo("User Name", "Kanishka Mogha");
	extent.addSystemInfo("Environment", "Automation Testing");
	}
	@AfterTest
	public void endReport()											// execute the final report
	{
	extent.flush();
	extent.close();
	}
	
	
	
	


}
