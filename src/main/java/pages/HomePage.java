package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id =  "enroll-button")
	WebElement enrollButton;
	
	public void ValidateEnrollButton() throws InterruptedException {
		Thread.sleep(4000);
		enrollButton.click();
		Thread.sleep(4000);
	}
}
