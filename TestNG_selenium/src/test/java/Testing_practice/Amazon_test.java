// Amazon_Test.java

package Testing_practice;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class Amazon_test {

	WebDriver driver;

	@Test(priority = 1)

	public void login()
			throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		Amazon_POM page =
				new Amazon_POM(driver);

		page.login();

		Thread.sleep(3000);

		driver.close();
	}

	@Test(priority = 2)

	public void search()
			throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		Amazon_POM page =
				new Amazon_POM(driver);

		page.searchproduct();

		Thread.sleep(3000);

		driver.close();
	}

	@Test(priority = 3)

	public void product()
			throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		Amazon_POM page =
				new Amazon_POM(driver);

		page.searchproduct();

		Thread.sleep(3000);

		page.productdetails();

		Thread.sleep(3000);

		driver.close();
	}

	@Test(priority = 4)

	public void cart()
			throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		Amazon_POM page =
				new Amazon_POM(driver);

		page.gotocart();

		Thread.sleep(3000);

		driver.close();
	}
}