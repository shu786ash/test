package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LogoutPage;
import pages.LoginPage;

public class LogoutTest extends BaseClass {

	@Test

	public void logoutTest()
			throws InterruptedException {

		driver.get(
		"https://tutorialsninja.com/demo/");

		LoginPage lp =
				new LoginPage(driver);

		lp.clickMyAccount();

		lp.clickLogin();

		lp.enterEmail(prop.getProperty("email"));

		lp.enterPassword(
		prop.getProperty("password"));

		lp.clickLoginButton();

		Thread.sleep(3000);

		LogoutPage lo =
				new LogoutPage(driver);

		lo.clickMyAccount();

		Thread.sleep(2000);

		lo.clickLogout();

		System.out.println(
		"Logout Successful");
	}
}