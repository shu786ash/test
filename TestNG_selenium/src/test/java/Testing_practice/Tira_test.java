
package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tira_test {

	WebDriver driver;
	WebDriverWait wait;
	Tira_POM page;
	@BeforeTest

	public void beforeTest() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://www.tirabeauty.com/");
		page = new Tira_POM(driver);
	}

	@Test(priority = 1)

	public void multiple_search() throws InterruptedException {

		page.searchproduct();
		System.out.println("Search completed");
	}

	@Test(priority = 2)
	public void product_details() throws InterruptedException {
		page.filterproduct();

		System.out.println("Filter applied");
	}

	@Test(priority = 3)
	public void add_to_cart() throws InterruptedException {
		page.addtocart();
		System.out.println("Product added to cart");
	}

	@Test(priority = 4)
	public void login() throws InterruptedException {
		page.login();
		System.out.println("Login process completed");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}