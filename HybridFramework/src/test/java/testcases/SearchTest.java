package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class SearchTest extends BaseClass {

	@Test

	public void searchProduct() {

		SearchPage sp = new SearchPage(driver);

		sp.enterProduct("iphone");

		sp.clickSearch();

		System.out.println("Product Search Successful");
	}
}