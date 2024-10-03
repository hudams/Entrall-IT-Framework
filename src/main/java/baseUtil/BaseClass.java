package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseClass {
     	//public ChromeDriver driver; 
		//public EdgeDriver driver; (Not Working)
		//public FirefoxDriver driver; (Not Working)
		public WebDriver driver;
		public HomePage homePage;
		
		@BeforeMethod
		public void setUp() {
			// Not Working --- java.lang.IllegalStateException: The driver executable must exist: C:\Users\saimu\eclipse-workspace\com.enthrallit\.\driver\chromedriver.exe)
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\saimu\\eclipse-workspace\\com.enthrallit\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
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
			driver.get("https://enthrallit.com/accounts/login/");
			// driver.manage().window().fullscreen();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2000));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			homePage = new HomePage(driver);
		}
		
		@AfterMethod
		public void tearUp() {
			driver.quit();
		}
		
}
