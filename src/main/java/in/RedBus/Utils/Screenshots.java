package in.RedBus.Utils;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FileUtils;

public class Screenshots {
	public static String getScreenshot(WebDriver fail_driver,String file_name) throws IOException { /* METHOD FOR SCREENSHOT */
		String dateName = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) fail_driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/Screenshot/"+file_name+dateName+".png";
		File finalDest = new File(destination);
		FileUtils.copyFile(source, finalDest);
		return destination;

	}

}
