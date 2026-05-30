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

public class CrossBrowser_Testing {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	SoftAssert soft;

	@Test(groups = "Smoke")

	public void chrome() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts()
//		.implicitlyWait(Duration.ofSeconds(5));
//
//		wait = new WebDriverWait(driver,
//				Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");
//		System.out.println("Chrome browser executed");
//		driver.close();
	}
	@Test(groups = "Smoke")

	public void chrometest() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		
	}

	@Test(groups = "regression")

	public void firefox() {

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

//		driver.manage().timeouts()
//		.implicitlyWait(Duration.ofSeconds(5));
//
//		wait = new WebDriverWait(driver,
//				Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");

//		System.out.println("Firefox browser executed");
//
//		driver.close();
	}

	@Test(groups = "regression")

	public void edge() {

		driver = new EdgeDriver();

		driver.manage().window().maximize();

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//		wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/");

//		System.out.println("Edge browser executed");
//
	driver.close();
	}

	@AfterTest

	public void afterTest() {

		System.out.println("Cross browser testing completed");
	}
}