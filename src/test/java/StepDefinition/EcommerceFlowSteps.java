package StepDefinition;

import org.openqa.selenium.WebDriver;

import POM_test.Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EcommerceFlowSteps {

	WebDriver driver = Hooks.driver;

	String generatedemail;

	Page p;

	@Given("user open TutorialsNinja registration page")
	public void user_open_tutorialsninja_registration_page() {

		driver = Hooks.driver;

		p = new Page(driver);

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	}

	@When("^user enter firstname (.*)$")
	public void user_enter_firstname(String firstname) {

		p.enterFirstname(firstname);
	}

	@And("^user enter lastname (.*)$")
	public void user_enter_lastname(String lastname) {

		p.enterLastname(lastname);
	}

	@And("^user enter registration email (.*)$")
	public void user_enter_registration_email(String email) {

		generatedemail = "ashish" + System.currentTimeMillis() + "@gmail.com";

		p.enterEmail(generatedemail);
	}

	@And("^user enter telephone (.*)$")
	public void user_enter_telephone(String telephone) {

		p.enterTelephone(telephone);
	}

	@And("^user enter registration password (.*)$")
	public void user_enter_registration_password(String password) {

		p.enterPassword(password);
	}

	@And("^user enter confirm password (.*)$")
	public void user_enter_confirm_password(String confirmpassword) {

		p.enterConfirmPassword(confirmpassword);
	}

	@And("user click on privacy policy checkbox")
	public void user_click_on_privacy_policy_checkbox() {

		p.clickCheckbox();
	}

	@And("user click on continue button")
	public void user_click_on_continue_button() throws InterruptedException {

		p.clickContinue();

		Thread.sleep(2000);
	}

	@And("user logout after registration")
	public void user_logout_after_registration() throws InterruptedException {

		p.clickContinueAfterRegistration();

		Thread.sleep(2000);

		p.clickMyAccount();

		Thread.sleep(2000);

		p.clickLogout();

		Thread.sleep(2000);
	}

	@And("user open login page")
	public void user_open_login_page() {

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	@And("^user enter login email (.*)$")
	public void user_enter_login_email(String email) {

		p.enterLoginEmail(generatedemail);
	}

	@And("^user enter login password (.*)$")
	public void user_enter_login_password(String password) {

		p.enterLoginPassword(password);
	}

	@And("user click on login button")
	public void user_click_on_login_button() throws InterruptedException {

		p.clickLoginButton();

		Thread.sleep(2000);
	}

	@And("^user search product (.*)$")
	public void user_search_product(String productname) {

		p.searchProduct(productname);
	}

	@And("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {

		p.clickSearchButton();

		Thread.sleep(2000);
	}

	@And("user click on searched product")
	public void user_click_on_searched_product() throws InterruptedException {

		p.clickProduct();

		Thread.sleep(2000);
	}

	@And("user click on add to cart button")
	public void user_click_on_add_to_cart_button() throws InterruptedException {

		p.clickAddToCart();

		Thread.sleep(2000);
	}

	@And("user click on shopping cart")
	public void user_click_on_shopping_cart() throws InterruptedException {

		p.clickShoppingCart();

		Thread.sleep(2000);
	}

	@And("user click on checkout button")
	public void user_click_on_checkout_button() throws InterruptedException {

		p.clickCheckout();

		Thread.sleep(2000);
	}

	@And("user click on remove button")
	public void user_click_on_remove_button() throws InterruptedException {

		p.clickRemoveButton();

		Thread.sleep(2000);
	}

	@And("user logout successfully")
	public void user_logout_successfully() throws InterruptedException {

		p.clickMyAccount();

		Thread.sleep(2000);

		p.clickLogout();

		Thread.sleep(2000);
	}

	@Then("complete ecommerce flow should execute successfully")
	public void complete_ecommerce_flow_should_execute_successfully() {

		System.out.println("Complete Flow Passed");
	}
}