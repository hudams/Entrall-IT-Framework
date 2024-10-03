package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import reports.Loggers;

public class CommonActions {

	public static void clickElement(WebElement element) {
		try {
			element.click();
			Loggers.logTheTest(element + "<------> has been clicked");
		} catch (NoSuchElementException | NullPointerException e) {
			// e.printStackTrace();
			// System.out.println("Exception is : " + e);
			Loggers.logTheTest(element + "<------> has not been found\n" + e.getMessage());
		}
		
	}
	
	
	public static void pause (long millis) {
		try {
			Thread.sleep(millis);
			Loggers.logTheTest("Sleeping ... zZz " + millis);
		} catch (InterruptedException e) {
			//System.out.println("Exception is: " + e);
			Loggers.logTheTest("Sleeping interrupted because of .. " + e.getMessage());
		}
	}
	
	public static void inputText(WebElement element, String input) {
		try {
			element.sendKeys(input);
			Loggers.logTheTest(input + "<------> has been put into <------> " + element);
		} catch (NoSuchElementException | NullPointerException e) {
			//e.printStackTrace();
			Loggers.logTheTest(element + "<------> has not been found\n" + e.getMessage());
		}
	}
}
