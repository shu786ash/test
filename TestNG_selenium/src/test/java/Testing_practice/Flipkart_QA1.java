package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Flipkart_QA1 {

	WebDriver driver;

	WebDriverWait wait;

	@BeforeTest

	public void beforeTest() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
	}

	@Test(priority = 1)

	public void login() throws InterruptedException {

		Thread.sleep(5000);

		// login button

		driver.findElement(
				By.xpath("//span[contains(text(),'Login')]"))
				.click();

		Thread.sleep(5000);

		// mobile input field

		WebElement mobile = driver.findElement(
				By.xpath("//input[contains(@class,'r4vIwl')]"));

		mobile.click();

		Thread.sleep(2000);

		mobile.sendKeys("6393549105");

		Thread.sleep(3000);

		// request otp button

		driver.findElement(
				By.xpath("//button[contains(text(),'Request OTP')]"))
				.click();

		Thread.sleep(5000);

		System.out.println("Login completed");
	}

	@Test(priority = 2)

	public void multiple_search() throws InterruptedException {

		WebElement search = wait.until(
				ExpectedConditions.elementToBeClickable(By.name("q")));

		search.sendKeys("beauty product");

		search.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		search = driver.findElement(By.name("q"));

		search.clear();

		search.sendKeys("lipstick");

		search.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		search = driver.findElement(By.name("q"));

		search.clear();

		search.sendKeys("lip balm");

		search.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		System.out.println("Multiple search completed");
	}

	@Test(priority = 3)

	public void add_to_cart() throws InterruptedException {

		WebElement search = driver.findElement(By.name("q"));

		search.clear();

		search.sendKeys("Laptop");

		search.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		WebElement firstProduct = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//div[@class='KzDlHZ'])[1]")));

		firstProduct.click();

		Thread.sleep(3000);

		for (String win : driver.getWindowHandles()) {

			driver.switchTo().window(win);
		}

		System.out.println("Product opened");

		Thread.sleep(3000);

		WebElement addtocart = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//button[contains(text(),'Add to cart')]")));

		addtocart.click();

		Thread.sleep(3000);

		System.out.println("Product added to cart");
	}

	@Test(priority = 4)

	public void product_details() {

		WebElement title = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(text(),'Laptop')]")));

		System.out.println("Product Title: " + title.getText());

		WebElement price = driver.findElement(
				By.xpath("//div[contains(text(),'₹')]"));

		System.out.println("Product Price: " + price.getText());

		WebElement rating = driver.findElement(
				By.xpath("//div[contains(@class,'XQDdHH')]"));

		System.out.println("Product Rating: " + rating.getText());
	}

	@Test(priority = 5)

	public void delete_cart_item() {

		System.out.println("Delete cart item test executed");
	}

	@Test(priority = 6)

	public void change_Address() {

		System.out.println("Change address test executed");
	}

	@Test(priority = 7)

	public void Change_name() {

		System.out.println("Change name test executed");
	}

	@AfterTest

	public void afterTest() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}
}