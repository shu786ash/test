package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	WebDriver driver;

	By myAccount =
			By.xpath("//span[text()='My Account']");

	By register =
			By.linkText("Register");

	By firstname =
			By.id("input-firstname");

	By lastname =
			By.id("input-lastname");

	By email =
			By.id("input-email");

	By telephone =
			By.id("input-telephone");

	By password =
			By.id("input-password");

	By confirmpassword =
			By.id("input-confirm");

	By privacy =
			By.name("agree");

	By continueButton =
			By.xpath("//input[@value='Continue']");

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
	}

	public void clickMyAccount() {

		driver.findElement(myAccount).click();
	}

	public void clickRegister() {

		driver.findElement(register).click();
	}

	public void enterFirstname(String fname) {

		driver.findElement(firstname).sendKeys(fname);
	}

	public void enterLastname(String lname) {

		driver.findElement(lastname).sendKeys(lname);
	}

	public void enterEmail(String mail) {

		driver.findElement(email).sendKeys(mail);
	}

	public void enterTelephone(String phone) {

		driver.findElement(telephone).sendKeys(phone);
	}

	public void enterPassword(String pass) {

		driver.findElement(password).sendKeys(pass);
	}

	public void enterConfirmPassword(String cpass) {

		driver.findElement(confirmpassword).sendKeys(cpass);
	}

	public void clickPrivacy() {

		driver.findElement(privacy).click();
	}

	public void clickContinue() {

		driver.findElement(continueButton).click();
	}
}