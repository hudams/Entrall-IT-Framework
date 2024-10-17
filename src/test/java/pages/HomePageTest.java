package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass{



	
	@Test
	public void userLogInTest() {
		homePage.userLogIn();
	}
	
	@Test
	public void switch_between_window_Test() {
		homePage.userLogIn();
		homePage.switch_between_window();
	}
	
}






















/*
	@Test
	public void logoTest() throws InterruptedException {
		homePage.ValidateEnrollButton();

	@Test
	public void clickLogoTest() {
		homePage.clickLogo();
	}
	
	@Test
	public void clickLogInButtonUsingCssSelectorTest() {
		homePage.clickLogInButtonUsingCssSelector();
	}
	
	@Test
	public void Logo() {
		homePage.Logo();
	}
	
	@Test
	public void emailTest() throws InterruptedException {
		homePage.clickEmail();
	}

	@Test
	public void passwordTest() throws InterruptedException {
		homePage.clickEmail();
		homePage.clickPassword();
	}

	@Test
	public void logInButtonTest() throws InterruptedException {
		homePage.clickLogInButton();
	} 


	@Test
	public void enrollNowTest() {
		homePage.clickEnrollNow();
	}

	@Test
	public void inputTextInEmailFieldTest() throws InterruptedException {
		homePage.clickEmail();
		homePage.inputTextInEmailField();
	}

	@Test
	public void inputTextInEmailAndPasswordFieldThenClickLogInButtonTest() {
		homePage.inputTextInEmailAndPasswordFieldThenClickLogInButton();
	}

	@Test
	public void useOfByClassInLoginTest() throws InterruptedException {
		homePage.useOfByClassInLogin();
	}

	@Test
	public void getMethodsOfThePageTest() {
		homePage.getMethodsOfThePage();
	}
	
	@Test
	public void newUserRegistrationPageValidationTest() {
		homePage.newUserRegistrationPageValidation();
	}
	
	@Test
	public void use_of_getAttribute_methodTest() {
		homePage.use_of_getAttribute_method();
	}
	
	@Test
	public void use_of_clear_method_Test() {
		homePage.use_of_clear_method();
	}
	
	*/
