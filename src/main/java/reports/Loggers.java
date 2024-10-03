package reports;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Reporter;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonStringFormatVisitor;

public class Loggers {
	// why static? --- bc this used inside the static method
	static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	// the class can call directly --- static
	public static void logTheTest(String msg) {
		logger.log(Level.INFO, msg); // it helps to print in console 
		Reporter.log(msg + "<br>"); // for testing report as index.html
		
	}
}
