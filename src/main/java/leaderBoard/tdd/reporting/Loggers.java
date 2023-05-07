package leaderBoard.tdd.reporting;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Reporter;

import com.aventstack.extentreports.Status;


public class Loggers {
	
private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static void getLog(String msg) {
		LOGGER.log(Level.INFO, msg);
		Reporter.log(msg + "<br>");
		ExtentTestManager.getTest().log(Status.INFO, msg);
	}

}
