package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.SearchPage;

public class CartTest extends BaseClass {

	@Test

	public void addToCartTest()
			throws InterruptedException {

		SearchPage sp =
				new SearchPage(driver);
		driver.get("https://tutorialsninja.com/demo/");
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

		Assert.assertTrue(
				cp.verifySuccessMessage());

		System.out.println(
		"Product Added To Cart Successfully");
	}
}