package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static common.CommonActions.*; //****

public class HomePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "emails")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath =  "//input[@id='login']")
	WebElement logInButton;
	
//	@FindBy(linkText = "enroll-now")
//	WebElement enrollNow;
	
	public void clickEmail () throws InterruptedException {
		Thread.sleep(4000);
		clickElement(email);
		Thread.sleep(4000);
	}
	
	public void clickPassword () {
		pause(4000);
		clickElement(password);
		pause(4000);
	}
	
	public void clickLogInButton() throws InterruptedException {
		Thread.sleep(4000);
		clickElement(logInButton);
		Thread.sleep(4000);
	}


/*	public void clickEnrollNow () {
		pause(4000);
		clickElement(enrollNow);
		pause(4000);
	} */
	
	// didn't use common method for sendKeys() method
	public void inputTextInEmailField() {
		pause(4000);
		email.sendKeys("enthrallincny@gmail.com");
		pause(4000);
	}
	
	// using 3 common methods 
	public void inputTextInEmailAndPasswordFieldThenClickLogInButton() {
		pause(3000);
		inputText(email, "enthrallincny@gmail.com");
		inputText(password, "Enthrall@2022");
		pause(3000);
		clickElement(logInButton);
		pause(3000);
	}
	
	//alternative of above method
	public void useOfByClassInLogin() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("emails")).sendKeys("enthrallincny@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Enthrall@2022");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Thread.sleep(3000);
	}
	
	
	
}
