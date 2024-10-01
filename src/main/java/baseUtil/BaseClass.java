package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;

public class BaseClass {

		public WebDriver driver;
		public HomePage homePage;
		
		@BeforeMethod
		public void setUp() {
			// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			// driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://enthrallit.com/");
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
