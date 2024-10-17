package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import static common.CommonActions.*;

public class EnrollNow {
	WebDriver driver;
	public Select select;

	public EnrollNow(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//input[@name='f_name']")
	WebElement firstName;
	
	@FindBy (xpath = "//select[@name='i_am']")
	WebElement iam;
	
	public void navigateToEnrollPage() {
		pause(4000);
		elementDisplayed(firstName);
		clickElement(firstName);
		inputText(firstName, "Mohammed");
	}
	
	public void use_of_dropdown_with_selectByValue_method() {
		select = new Select(iam);
		select.selectByValue("Student");
		pause(2000);
	}
}
