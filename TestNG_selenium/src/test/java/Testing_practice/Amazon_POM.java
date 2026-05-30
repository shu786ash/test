// Amazon_POM.java

package Testing_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Amazon_POM {

	WebDriver driver;

	// locators

	By signin =
			By.id("nav-link-accountList");

	By email =
			By.id("ap_email");

	By continuebtn =
			By.id("continue");

	By password =
			By.id("ap_password");

	By loginbtn =
			By.id("signInSubmit");

	By searchbox =
			By.id("twotabsearchtextbox");

	By searchbutton =
			By.id("nav-search-submit-button");

	By firstproduct =
			By.xpath("(//span[contains(text(),'Apple')])[1]");

	By cartbutton =
			By.id("nav-cart");

	// constructor

	public Amazon_POM(WebDriver driver) {

		this.driver = driver;
	}

	// login functionality

	public void login() {

		driver.findElement(signin).click();

		driver.findElement(email)
		.sendKeys("yourmail@gmail.com");

		driver.findElement(continuebtn)
		.click();

		driver.findElement(password)
		.sendKeys("password");

		driver.findElement(loginbtn)
		.click();
	}

	// search functionality

	public void searchproduct() {

		driver.findElement(searchbox)
		.sendKeys("iphone");

		driver.findElement(searchbutton)
		.click();
	}

	// product open

	public void productdetails() {

		driver.findElement(firstproduct)
		.click();
	}

	// cart functionality

	public void gotocart() {

		driver.findElement(cartbutton)
		.click();
	}
}