package POM_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {

	WebDriver driver;

	public Page(WebDriver driver) {

		this.driver = driver;
	}

	// Registration Locators

	By firstname = By.id("input-firstname");

	By lastname = By.id("input-lastname");

	By email = By.id("input-email");

	By telephone = By.id("input-telephone");

	By password = By.id("input-password");

	By confirmpassword = By.id("input-confirm");

	By checkbox = By.name("agree");

	By continuebutton = By.xpath("//input[@value='Continue']");

	By continueafterregistration = By.linkText("Continue");

	// Login Locators

	By loginbutton = By.xpath("//input[@value='Login']");

	// Search Locators

	By search = By.name("search");

	By searchbutton = By.xpath("//button[@class='btn btn-default btn-lg']");

	// Cart Locators

	By product = By.linkText("iPhone");

	By addtocart = By.id("button-cart");

	By shoppingcart = By.linkText("shopping cart");

	By checkout = By.linkText("Checkout");

	By removebutton = By.xpath("//button[@data-original-title='Remove']");

	// Logout Locators

	By myaccount = By.xpath("//span[text()='My Account']");

	By logout = By.linkText("Logout");



	// Registration Methods

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

	public void clickCheckbox() {

		driver.findElement(checkbox).click();
	}

	public void clickContinue() {

		driver.findElement(continuebutton).click();
	}

	public void clickContinueAfterRegistration() {

		driver.findElement(continueafterregistration).click();
	}



	// Login Methods

	public void enterLoginEmail(String emailid) {

		driver.findElement(email).sendKeys(emailid);
	}

	public void enterLoginPassword(String pass) {

		driver.findElement(password).sendKeys(pass);
	}

	public void clickLoginButton() {

		driver.findElement(loginbutton).click();
	}



	// Search Methods

	public void searchProduct(String productname) {

		driver.findElement(search).sendKeys(productname);
	}

	public void clickSearchButton() {

		driver.findElement(searchbutton).click();
	}



	// Cart Methods

	public void clickProduct() {

		driver.findElement(product).click();
	}

	public void clickAddToCart() {

		driver.findElement(addtocart).click();
	}

	public void clickShoppingCart() {

		driver.findElement(shoppingcart).click();
	}

	public void clickCheckout() {

		driver.findElement(checkout).click();
	}

	public void clickRemoveButton() {

		driver.findElement(removebutton).click();
	}



	// Logout Methods

	public void clickMyAccount() {

		driver.findElement(myaccount).click();
	}

	public void clickLogout() {

		driver.findElement(logout).click();
	}

}