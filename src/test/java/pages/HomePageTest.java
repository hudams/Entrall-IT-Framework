package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass{


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
	
	/*	
	@Test
	public void enrollNowTest() {
		homePage.clickEnrollNow();
	}
	 */	

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
}
