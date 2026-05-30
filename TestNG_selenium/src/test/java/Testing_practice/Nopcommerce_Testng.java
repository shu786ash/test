package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class Nopcommerce_Testng {

	WebDriver driver;

	@BeforeTest

	public void beforeTest() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-blink-features=AutomationControlled");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	@Test(priority = 1)

	public void registration() throws InterruptedException {

		// gender

		driver.findElement(By.id("gender-male")).click();

		Thread.sleep(1000);

		// first name

		WebElement fname = driver.findElement(By.id("FirstName"));

		fname.sendKeys("Ashish");

		Thread.sleep(1000);

		// last name

		WebElement lname = driver.findElement(By.id("LastName"));

		lname.sendKeys("Shukla");

		Thread.sleep(1000);

		// email

		WebElement email = driver.findElement(By.id("Email"));

		email.sendKeys("ashish123@gmail.com");

		Thread.sleep(1000);

		// company name

		WebElement company = driver.findElement(By.id("Company"));

		company.sendKeys("wipro");

		Thread.sleep(1000);

		// password

		WebElement pass = driver.findElement(By.id("Password"));

		pass.sendKeys("Ashish@123");

		Thread.sleep(1000);

		// confirm password

		WebElement cpass = driver.findElement(By.id("ConfirmPassword"));

		cpass.sendKeys("Ashish@123");

		Thread.sleep(1000);

		// register button

		driver.findElement(By.id("register-button")).click();

		Thread.sleep(3000);

		System.out.println("Registration completed");
		//Thread.sleep(10000);
	}

	@Test(priority = 2)

	public void logout() throws InterruptedException {

		Thread.sleep(3000);

		// logout click

		driver.findElement(
				By.linkText("Log out"))
				.click();

		Thread.sleep(3000);

		System.out.println("Logout completed");
	}


	@Test(priority = 3)

	public void login() throws InterruptedException {

		// login page open

		driver.findElement(
				By.linkText("Log in"))
				.click();

		Thread.sleep(3000);

		// email

		driver.findElement(By.id("Email"))
		.sendKeys("ashish123@gmail.com");

		Thread.sleep(2000);

		// password

		driver.findElement(By.id("Password"))
		.sendKeys("Ashish@123");

		Thread.sleep(2000);

		// login button

		driver.findElement(
				By.xpath("//button[contains(text(),'Log in')]"))
				.click();

		Thread.sleep(4000);

		System.out.println("Login completed");
	}

	@Test(priority = 4)

	public void search_product() throws InterruptedException {

		WebElement search = driver.findElement(By.id("small-searchterms"));

		search.sendKeys("Jewellery");

		Thread.sleep(1000);

		search.submit();

		Thread.sleep(3000);

		System.out.println("Product searched");
	}

	@Test(priority = 5)

	public void add_to_cart() throws InterruptedException {

		driver.findElement(
				By.xpath("(//button[contains(text(),'Add to cart')])[1]"))
				.click();

		Thread.sleep(3000);

		System.out.println("Product added to cart");
	}

	@Test(priority = 6)

	public void product_details() {

		System.out.println("Product details verified");
	}

	@Test(priority = 7)

	public void delete_cart_item() {

		System.out.println("Cart item deleted");
	}

	@Test(priority = 8)

	public void change_Address() {

		System.out.println("Address changed");
	}

	@Test(priority = 9)

	public void Change_name() {

		System.out.println("Name changed");
	}

	@AfterTest

	public void afterTest() throws InterruptedException {

		Thread.sleep(5000);

		driver.quit();
	}
}