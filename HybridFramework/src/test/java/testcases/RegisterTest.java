package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.RegistrationPage;

public class RegisterTest extends BaseClass {

	RegistrationPage rp;

	@BeforeTest

	public void start() throws Exception {

		setup();
	}

	@Test

	public void registerTest() {

		rp = new RegistrationPage(driver);

		rp.clickMyAccount();

		rp.clickRegister();

		rp.enterFirstname("Ashish");

		rp.enterLastname("Shukla");


		rp.enterEmail("ashish" + System.currentTimeMillis() + "@gmail.com");

		rp.enterTelephone("6393549105");

		rp.enterPassword("Ashish@123");

		rp.enterConfirmPassword("Ashish@123");

		rp.clickPrivacy();

		rp.clickContinue();

		System.out.println("Registration Successful");
	}

	@AfterTest

	public void end() {

		//closeBrowser();
		//driver.quit();
	}
}