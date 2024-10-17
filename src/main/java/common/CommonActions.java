package common;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.google.common.io.Files;

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

	public static void elementDisplayed(WebElement element) {
		try {
			boolean flag = element.isDisplayed();
			Loggers.logTheTest(element + "<------> is Displayed, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			Loggers.logTheTest(element + "<------> is not Displayed\n" + e.getMessage());
		}

	}

	public static void elementEnabled(WebElement element) {
		try {
			boolean flag = element.isEnabled();
			Loggers.logTheTest(element + "<------> is Enabled, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			Loggers.logTheTest(element + "<------> is not Enabled\n" + e.getMessage());
		}
	}
	public static void elementSelected(WebElement element) {
		try {
			boolean flag = element.isSelected();
			Loggers.logTheTest(element + "<------> is Selected, " + flag);
		} catch (NoSuchElementException | NullPointerException e) {
			Loggers.logTheTest(element + "<------> is not Selected\n" + e.getMessage());
		}
	}
	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			String actualTitle = driver.getTitle();
			Loggers.logTheTest("Actual title is: " + actualTitle + " ----> And Expected Title is: " + expectedTitle);
			//Assert.assertEquals(actualTitle, expectedTitle, "Title doesn't match up");
		} catch (NullPointerException e) {
			Loggers.logTheTest("Driver is not initiated properly Or Title doesn't match up");
			Assert.fail();
		}

	}
	
	public static void verifyCurrentURL(WebDriver driver, String expectedURL) {
		try {
			String currentURL  = driver.getCurrentUrl();
			Loggers.logTheTest("Current URL: " + currentURL + " ----> Expected URL: " + expectedURL);
			Assert.assertEquals(currentURL, expectedURL, "Current URL is not corrent");
		} catch (NullPointerException e) {
			Loggers.logTheTest("Driver is not initiated properly Or Current URL doesn't match");
			Assert.fail();
		}
	}
	
	public static void verifyTextOfTheWebElement(WebElement element, String expected) {
		try {
			String actual  = element.getText();
			Loggers.logTheTest("Current Text: " + actual + " ----> Expected URL: " + expected);
			Assert.assertEquals(actual, expected, "Current Text is not corrent");
		} catch (NoSuchElementException | NullPointerException e) {
			Loggers.logTheTest(element + "<------> is not Displayed or Text doesn't match\n" + e.getMessage());
		}
	}
	
	public static void clearTextFromTheField(WebElement element) {
		try {
			element.clear();
			Loggers.logTheTest("The Text from the: " + element + " ----> is cleared");
		} catch (NoSuchElementException | NullPointerException e) {
			Loggers.logTheTest(element + "<------> has not been found\n" + e.getMessage());
			Assert.fail();
		}
	}
	
	public static void selectDropdown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			Loggers.logTheTest(value + " has been selected from the dropdown of ---> " + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + " : This element Not Found");
			Assert.fail();
		}	
	}
	
	public static void inputTextThenClickEnter(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.ENTER);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	public static void inputTextThenClickReturn(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.RETURN);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	public static void inputTextThenClickTab(WebElement element, String input) {
		try {
			element.sendKeys(input, Keys.TAB);
			Loggers.logTheTest(input + " <-----> has been put into <-----> " + element + " and then clicked by Enter Key");
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
			Loggers.logTheTest(element + "<----------> has not been found\n" + e.getMessage() );
			Assert.fail();
		}
	}
	
	// very very important interview question
		public static String getSreenShot(String testName, WebDriver driver) {
			TakesScreenshot ss = (TakesScreenshot) driver;
			String path = System.getProperty("user.dir") + "/test-output/screenShots";
			File folder = new File(path);
			if (!folder.exists()) {
				folder.mkdirs();
			}

			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
			String formattedDate = dateFormat.format(date);

			File targetFile = new File(path + "/error_" + testName + "_" + formattedDate + ".png");
			try {
				File srcFile = ss.getScreenshotAs(OutputType.FILE);
				Files.copy(srcFile, targetFile);
				Loggers.logTheTest("Screenshot has been successfully capture at: \n" + targetFile.getAbsolutePath());
			} catch (WebDriverException | IOException e) {
				e.printStackTrace();
				Loggers.logTheTest("Screenshot cannot be captured");
			}
			return targetFile.getAbsolutePath();
		}
}				
