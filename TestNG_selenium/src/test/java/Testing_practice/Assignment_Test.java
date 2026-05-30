//assignment1
//checking for validate search using Assert

package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment_Test {

	WebDriver driver;

	@DataProvider(name = "searchdata")

	public Object[][] dp1() {

		return new Object[][] {

			{"iphone"},            
			{"Samsung"},                         
			{"Laptop"},            
			{"4 star mobile"},      
			{"mobile under 20000"},  
			{"discount laptops"},    
			{"578695"},              
			{"!@#$%^&"},             
			{"asdjhga"},             
			{"shadgjhsa766543"}      
		};
	}

	@Test(dataProvider = "searchdata")

	public void validatesearch(String product)throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement search =driver.findElement(By.id("twotabsearchtextbox"));

		WebElement searchbutton =driver.findElement(By.id("nav-search-submit-button"));

		

		Assert.assertTrue(searchbutton.isDisplayed(),"Search button not displayed");

		Assert.assertTrue(searchbutton.isEnabled(),"Search button not enabled");
		  driver.navigate().refresh();
	//	search.clear();
		search.sendKeys(product);
		Thread.sleep(2000);
		searchbutton.click();
		System.out.println("Search Tested For : "+ product);
		//Thread.sleep(3000);
		
	}
	  @AfterClass
	  public void afterClass() {
		  
		  driver.quit();
	  }

}