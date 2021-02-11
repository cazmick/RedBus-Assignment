package in.RedBus.Utils;

import org.testng.SkipException;
import com.relevantcodes.extentreports.LogStatus;

import in.RedBus.Base.Driver;

public class RequiredExecution extends Driver {
	public static void tocheckExecutionRequired(String executionRequired, String TestName) {		//Method to handle the Execution is Required or not
		if (executionRequired.toLowerCase().equals("no")) {
			extentTest = extent.startTest(TestName);
			extentTest.log(LogStatus.WARNING, "Execution required is " + executionRequired);
			throw new SkipException("Skipping this test ");
		}

	}

}
