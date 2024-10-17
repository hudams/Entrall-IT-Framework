package baseUtil;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import reports.ExtentReportManager;
import reports.TestManager;
import utils.Configuration;

import static utils.IConstant.*;

public class BaseClass {

	//public ChromeDriver driver; 
	//public EdgeDriver driver; (Not Working)
	//public FirefoxDriver driver; (Not Working)
	public WebDriver driver;
	public HomePage homePage;
	Configuration configuration;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	@BeforeSuite
	public void initialReporting() {
		extentReports = ExtentReportManager.initialReports();
	}
	
	@BeforeMethod
	public void initialTest(Method method) {
		extentTest = TestManager.createTest(extentReports, method.getName());
		extentTest.assignCategory(method.getDeclaringClass().getName());
	}

	@BeforeMethod
	public void setUp() {
		configuration = new utils.Configuration();
		initDrive();
		// Not Working --- java.lang.IllegalStateException: The driver executable must exist: C:\Users\saimu\eclipse-workspace\com.enthrallit\.\driver\chromedriver.exe)
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\saimu\\eclipse-workspace\\com.enthrallit\\driver\\chromedriver.exe");
		//driver = new ChromeDriver();

		//WebDriver working (CHROME) with exception of ChromeOptions();
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver(); (it open up the tab but shows this error --- org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket connection to http://localhost:64519)
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--remote-allow-origins=*");
		//driver = new ChromeDriver(chromeOptions);

		// this Webdriver is working (FIREFOX)
		// WebDriverManager.firefoxdriver().setup();
		// driver = new FirefoxDriver();

		//this is not working (EDGE) it shows me the following error --- org.openqa.selenium.remote.http.ConnectionFailedException: Unable to establish websocket connection to http://localhost:64744/devtools/browser/)
		// WebDriverManager.edgedriver().setup();
		// driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.getProperties(URL));
		// driver.manage().window().fullscreen();
		//converting string to long type
		long pageLoadWait = Long.parseLong(configuration.getProperties(PAGELOAD_WAIT));
		long implicitlyWait = Long.parseLong(configuration.getProperties(IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadWait));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		initClass();
	}
	
	public void initDrive() {
		String browserName = configuration.getProperties(BROWSER);
		
		switch (browserName) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case EDGE:
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		}
	
	public void initClass() {
		homePage = new HomePage(driver);
	}

	@AfterMethod
	public void tearUp() {
		driver.quit();
	}
	
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}
		
		if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		}else if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(CommonActions.getSreenShot(method.getName(), driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
	}
	
	@AfterSuite
	public void publishReport() {
		extentReports.flush();
	}


}
