package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

public class Assert_Test {

	WebDriver driver;

	WebDriverWait wait;

	@BeforeTest

	public void browsersetup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");
	}

	@Test(priority = 1)

	public void titlevalidation() {

		SoftAssert soft = new SoftAssert();

		String expectedtitle = "Selenium";

		String actualtitle = driver.getTitle();

		soft.assertEquals(actualtitle,
				expectedtitle,
				"Title validation failed");

		String expectedurl =
				"https://www.selenium.dev/";

		String actualurl =
				driver.getCurrentUrl();

		soft.assertEquals(actualurl,
				expectedurl,
				"URL validation failed");

		System.out.println("Soft Assert Executed");

		soft.assertAll();
	}

	@Test(priority = 2)

	public void urlvalidation() {

		String currenturl =
				driver.getCurrentUrl();

		System.out.println(currenturl);
	}

	@AfterTest

	public void afterTest() {

		driver.quit();
	}
}