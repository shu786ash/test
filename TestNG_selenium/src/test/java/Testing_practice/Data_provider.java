package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class Data_provider {

	WebDriver driver;

	@DataProvider(name = "browsers",parallel = false)

	public Object[][] dp() {

		return new Object[][] {

			{"chrome"},

			{"firefox"},

			{"edge"}

		};
	}

	@Test(dataProvider = "browsers")

	public void crossbrowser_test(String browser)
			throws InterruptedException {

		if(browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if(browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		else if(browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		}

//		driver.manage().window().maximize();
//
//		driver.manage().timeouts()
//		.implicitlyWait(Duration.ofSeconds(5));
//
//		driver.get("https://www.selenium.dev/");
//
//		System.out.println(browser + " browser executed");
		else {
			System.out.println("invalid broser");
		}
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/");
		System.out.println("title"+driver.getTitle());
//		Thread.sleep(3000);
//
		driver.close();
	}
	//assignment1 
//  checking for  validate search
  
//  use assert for search button clickable
  
//  asdjhga 578695,!@#$%^& ,shadgjhsa766543,(product,name,brand name,rating based ,
//  price based,discount)
  
// assignment 2 
//  register 5 user
	@AfterTest

	public void afterTest() {
          // driver.quit();
		//System.out.println("Data Provider execution completed");
	}
}