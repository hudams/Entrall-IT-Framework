package pages;

import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass{

	@Test
	public void logoTest() throws InterruptedException {
		homePage.ValidateEnrollButton();
	}
}
