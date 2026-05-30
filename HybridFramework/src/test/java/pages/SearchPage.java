package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

	WebDriver driver;

	By searchBox = By.name("search");

	By searchButton = By.xpath("//button[contains(@class,'btn-default')]");

	public SearchPage(WebDriver driver) {

		this.driver = driver;
	}
	public void clearSearch() {

		driver.findElement(searchBox).clear();
	}

	public void enterProduct(String product) {

		driver.findElement(searchBox).sendKeys(product);
	}

	public void clickSearch() {

		driver.findElement(searchButton).click();
	}
}