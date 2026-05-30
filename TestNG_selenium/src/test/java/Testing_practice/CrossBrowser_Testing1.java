package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

public class CrossBrowser_Testing1 {

	WebDriver driver;

	WebDriverWait wait;

	JavascriptExecutor js;

	SoftAssert soft;

	// Smoke Testing

	@Test(groups = "Smoke")

	public void chrome() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");

		System.out.println(
				"Chrome browser executed");
	}

	@Test(groups = "Smoke")

	public void chrometest() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.selenium.dev/");

		System.out.println(
				"Chrome test executed");
	}

	// Regression Testing

	@Test(groups = "Regression")

	public void firefox() {

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");

		System.out.println(
				"Firefox browser executed");
	}

	@Test(groups = "Regression")

	public void edge() {

		driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver,
				Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");

		System.out.println(
				"Edge browser executed");
	}

	// Sanity Testing

	@Test(groups = "Sanity")

	public void chromesanity() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		System.out.println(
				"Chrome sanity test executed");
	}

	@Test(groups = "Sanity")

	public void firefoxtest() {

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		System.out.println(
				"Firefox sanity test executed");
	}

	// Functional Testing

	@Test(groups = "Functional")

	public void functionaltest() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		System.out.println(
				"Functional testing executed");
	}

	@AfterTest(alwaysRun = true)
//	alwaysRun = true ko generally:
//
//		@AfterTest
//		@AfterMethod
//		@AfterClass
//	alwaysRun = true ensures ki agar test case fail bhi ho jaye,
//	tab bhi annotated method execute hoga.
//
//	Mostly cleanup activities ke liye use karte hain:
//	browser close,
//	report generation,
//	database disconnect etc.

	public void afterTest() {

		System.out.println(
				"Cross browser testing completed");

		driver.quit();
	}
}