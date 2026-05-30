package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators

	By firstProduct =
	By.xpath("(//div[@class='product-thumb'])[1]");

	By addToCart =
	By.id("button-cart");

	By successMessage =
	By.xpath("//div[contains(@class,'alert-success')]");

	By cartButton =
	By.id("cart-total");

	By removeButton =
	By.xpath("//button[contains(@data-original-title,'Remove')]");

	// Methods

	public void clickFirstProduct() {

		driver.findElement(firstProduct)
		.click();
	}

	public void clickAddToCart() {

		driver.findElement(addToCart)
		.click();
	}

	public boolean verifySuccessMessage() {

		return driver.findElement(successMessage)
				.isDisplayed();
	}

	public void clickCart() {

		driver.findElement(cartButton)
		.click();

		try {

			Thread.sleep(5000);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void removeProduct() {

		driver.findElement(removeButton)
		.click();

		System.out.println(
		"Product Removed Successfully");
	}
}