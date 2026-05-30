package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage lp;

	@BeforeTest

	public void start() throws Exception {

		setup();
	}

	@Test

	public void loginTest() {

		lp = new LoginPage(driver);

		lp.clickMyAccount();

		lp.clickLogin();

		lp.enterEmail(prop.getProperty("email"));

		lp.enterPassword(
		prop.getProperty("password"));

		lp.clickLoginButton();

		System.out.println("Login Successful");
	}

	@AfterTest

	public void end() {

		//closeBrowser();
		//driver.quit();
	}
}