package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.CommonActions.*; //****

import java.time.Duration;
import java.util.Set;

public class HomePage {

	WebDriver driver;
	JavascriptExecutor js;
	public Select select;
	public WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, Duration.ofMillis(4000));
	}
	
	
	@FindBy(name = "logo-link")
	WebElement logoLinkFromToolkitBar;
	
	@FindBy(name = "login-link")
	WebElement loginFromToolkitBar;
	
	@FindBy(how = How.NAME, using = "logo-link")
	WebElement logo;
	
	@FindBy(id = "emails")
	WebElement email;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(css  = "input.btn.btn-lg.px-5")
	WebElement logInButton;
	
	@FindBy(xpath = "//span[text()= 'Automation']")
	WebElement automation;
	
	@FindBy(xpath = "//a[text()= 'Enroll Now']")
	WebElement enrollNow;

	@FindBy(xpath = "//h1[text()= 'Enroll']")
	WebElement enrollNowHeader;
	
	@FindBy(xpath = "//input[@name='f_name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='m_name']")
	WebElement middleName;
	
	@	FindBy(xpath = "//input[@id='id_l_name']")
	WebElement lastName;
	
	@FindBy (xpath = "//select[@name='i_am']")
	WebElement iam;
	
	@FindBy(xpath = "//select[@name='course_wish_to_enroll']")
	WebElement courseWishToEnroll;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@id='id_email']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement enrollmentPassword;
	
	@FindBy(xpath = "//select[@id='id_gender']")
	WebElement gender;
	
	public void userLogIn() {
		pause(4000);
		verifyCurrentURL(driver, "https://enthrallit.com/");
		pause(2000);		
		verifyTitle(driver, "Enthrall IT");
		elementDisplayed(logoLinkFromToolkitBar);
		clickElement(logoLinkFromToolkitBar);
		pause(2000);
		elementDisplayed(loginFromToolkitBar);
		pause(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;  // ----- USED JavaScript to click the element ***
		js.executeScript("arguments[0].click()", loginFromToolkitBar);
		pause(2000);
		elementDisplayed(logo);
		verifyTitle(driver, "Enthrall IT");
		verifyCurrentURL(driver, "https://enthrallit.com/accounts/login/");
		elementDisplayed(email);
		elementSelected(email);
		pause(3000);
		String ml = email.getAttribute("maxlength");
		System.out.println("The value of the maxlenght attribute is: " + ml);
		inputText(email, "enthrallincny@gmail.com");
		pause(2000);
		elementDisplayed(password);
		js.executeScript("arguments[0].value='Enthrall@2022'", password); // --- // ----- USED JavaScript to input value in the element ***
		pause(2000);
		elementDisplayed(logInButton);
		pause(2000);
		elementEnabled(logInButton);
		clickElement(logInButton);
		pause(3000);
		elementDisplayed(automation);
		clickElement(automation);
		pause(2000);
		elementDisplayed(enrollNow);
		clickElement(enrollNow);
		pause(4000);
		Set<String> allWindowHandler = driver.getWindowHandles();
		pause(2000);
		String parent = (String)allWindowHandler.toArray()[0];
		pause(2000);
		String child = (String)allWindowHandler.toArray()	[1];
		pause(2000);
		driver.switchTo().window(child);
		pause(2000);
		verifyTitle(driver, "Enthrall IT - Dashboard");
		verifyCurrentURL(driver, "https://enthrallit.com/course/dashboard/enrolls/");
		elementDisplayed(firstName);
		clickElement(firstName);
		inputText(firstName, "Mohammed");
		elementDisplayed(middleName);
		elementSelected(middleName);
		inputText(middleName, "Saimul");
		elementDisplayed(lastName);
		clickElement(lastName);
		inputText(lastName, "Huda");
		pause(2000);
		select = new Select(iam);
		select.selectByValue("Student"); //selected by value
		pause(4000);
		
	}
	
	public void switch_between_window() {
		pause(4000);
		Set<String> allWindowHandler = driver.getWindowHandles();
		String parent = (String)allWindowHandler.toArray()[0];
		String child = (String)allWindowHandler.toArray()	[1];
		driver.switchTo().window(child);
		pause(2000);
		//verifyTextOfTheWebElement(enrollNowHeader, "Enroll Home");
		//pause(4000);	
	}
	
	
	
	
	
	
	
}












/*
//Why not working with line 125??? *******


public void clickEmail () throws InterruptedException {
		Thread.sleep(4000);
		enrollNow.click();
		Thread.sleep(4000);
	}

	// didn't use common method for sendKeys() method
	public void inputTextInEmailField() {
		pause(4000);
		email.sendKeys("enthrallincny@gmail.com");
		pause(4000);
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
	
	
public void clickLogo() {
	boolean elementDisplayed = driver.findElement(By.name("logo-link")).isDisplayed();
	System.out.println("Is the Logo displayed? Ans: " + elementDisplayed);
}

public void clickEnrollNow () {
	pause(4000);
	clickElement(enrollNow);
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

//CssSelector
public void clickLogInButtonUsingCssSelector() {
	driver.findElement(By.cssSelector("input.btn.btn-lg.px-5")).click();
}

// we created the common actions for these methods
public void getMethodsOfThePage() {
	String actual = driver.getTitle();
	System.out.println("Title of the page is: " + actual);
	String expected = "Enthrall IT";
	Assert.assertEquals(actual, expected, "Title doesn't match up");

	String currentURL = driver.getCurrentUrl();
	System.out.println("Current URL: " + currentURL);
	String expectedURL = "https://enthrallit.com/accounts/login/";
	Assert.assertEquals(currentURL, expectedURL, "The driver failed to direct at the right URL");

	//use of getText() in "login Button"
	String actualTextPresentInTheWebElement = logInButton.getText();
	System.out.println("Text present as: " + actualTextPresentInTheWebElement);
	//String expectedText = "LOG IN";
	//Assert.assertEquals(actualTextPresentInTheWebElement, expectedText, "The text of the WebElement doesn't match");
}

// first method that uses during the automation framework
// title, url, logo displayed?
//coming from common actions
public void newUserRegistrationPageValidation() {
	pause(2000);
	elementDisplayed(logo);
	verifyTitle(driver, "Enthrall IT");
	verifyCurrentURL(driver, "https://enthrallit.com/accounts/login/");
	elementDisplayed(enrollNow);
	verifyTextOfTheWebElement(enrollNow, "Enroll Now");
	clickElement(enrollNow);
	pause(5000);
	verifyTitle(driver, "Enthrall IT");
	verifyCurrentURL(driver, "https://enthrallit.com/course/apply/");
}

public void use_of_getAttribute_method() {
	elementSelected(email);
	pause(3000);
	String ml = email.getAttribute("maxlength");
	System.out.println("The value of the maxlenght attribute is: " + ml);
}

public void use_of_clear_method() {
	elementDisplayed(email);
	inputText(email, "enthrallincny@gmail.com");
	pause(2000);
	clearTextFromTheField(email);
	inputText(email, "enthrallincny@gmail.com");
	elementDisplayed(password);
	inputText(password, "Enthrall@2022");
	pause(2000);
	elementDisplayed(logInButton);
	pause(2000);
	elementEnabled(logInButton);
	clickElement(logInButton);
	pause(3000);
	elementDisplayed(automation);
	
}
*/
