package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.SearchPage;

public class RemoveProductTest
extends BaseClass {

	@Test

	public void removeProductFromCart()
			throws InterruptedException {

		driver.get(
		"https://tutorialsninja.com/demo/");

		SearchPage sp =
				new SearchPage(driver);

		sp.clearSearch();

		sp.enterProduct("iphone");

		sp.clickSearch();

		Thread.sleep(3000);

		CartPage cp =
				new CartPage(driver);

		cp.clickFirstProduct();

		Thread.sleep(3000);

		cp.clickAddToCart();

		Thread.sleep(3000);

		cp.clickCart();
		Thread.sleep(5000);
		cp.removeProduct();
	}
}