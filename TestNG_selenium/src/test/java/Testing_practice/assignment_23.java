package Testing_practice;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class assignment_23 {
	 WebDriver driver;
	 WebDriverWait wait;
	@BeforeTest
	public void beforeTest() {
		
ChromeOptions options = new ChromeOptions();

	    
	    options.addArguments("--disable-notifications");

	    options.addArguments("--disable-save-password-bubble");

	    
	    Map<String, Object> prefs = new HashMap<>();

	    prefs.put("credentials_enable_service", false);

	    prefs.put("profile.password_manager_enabled", false);

	    prefs.put("profile.password_manager_leak_detection", false);

	    options.setExperimentalOption("prefs", prefs);

	    driver = new ChromeDriver(options);

	    driver.manage().window().maximize();

	    wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    driver.get("https://www.saucedemo.com/");

        
	}
	@Test(priority = 1)
    public void login() throws InterruptedException {

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Successful");

        Thread.sleep(3000);
    }
	@Test(priority = 2)
    public void search_product() throws InterruptedException {

        

        WebElement product = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[text()='Sauce Labs Backpack']")));

        System.out.println("Product Found : "
                + product.getText());

        Thread.sleep(3000);
    }
	 @Test(priority = 3)
	    public void product_details() throws InterruptedException {

	        WebElement title =
	                driver.findElement(
	                        By.xpath("//div[text()='Sauce Labs Backpack']"));

	        System.out.println("Product Title : "
	                + title.getText());

	        WebElement price =
	                driver.findElement(
	                        By.className("inventory_item_price"));

	        System.out.println("Product Price : "
	                + price.getText());

	        // Rating not available in SauceDemo
	        System.out.println("Rating : Not Available");

	        Thread.sleep(3000);
	    }
	 @Test(priority = 4)
	    public void image_zoom() throws InterruptedException {

	        WebElement image =
	                driver.findElement(
	                        By.className("inventory_item_img"));

	        Actions act = new Actions(driver);

	        act.moveToElement(image).perform();

	        System.out.println("Mouse Hover Performed On Product Image");

	        Thread.sleep(3000);
	    }
	 @Test(priority = 5)
	    public void add_to_cart_visibility() throws InterruptedException {

	        WebElement addCart =
	                driver.findElement(
	                        By.id("add-to-cart-sauce-labs-backpack"));

	        if (addCart.isDisplayed()) {

	            System.out.println("Add To Cart Button Visible");
	        }

	        addCart.click();

	        Thread.sleep(3000);
	    }
	 @Test(priority = 6)
	    public void buy_button_visibility() throws InterruptedException {

	        // SauceDemo has no Buy button
	        // Using Cart button as alternative

	        WebElement cart =
	                driver.findElement(
	                        By.className("shopping_cart_link"));

	        if (cart.isDisplayed()) {

	            System.out.println("Cart Button Visible");
	        }

	        cart.click();

	        Thread.sleep(3000);
	    }
	 @Test(priority = 7)
	    public void checkout_button_visibility() throws InterruptedException {

	        WebElement checkout =
	                wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.id("checkout")));

	        if (checkout.isDisplayed()) {

	            System.out.println("Checkout Button Visible");
	        }

	        checkout.click();

	        System.out.println("Checkout Started");

	        Thread.sleep(3000);
	    }
	 @Test(priority = 8)
	 public void checkout_information() throws InterruptedException {

	     // First Name
	     WebElement firstName = wait.until(
	             ExpectedConditions.visibilityOfElementLocated(
	                     By.id("first-name")));

	     firstName.sendKeys("Ashish");

	     // Last Name
	     WebElement lastName =
	             driver.findElement(By.id("last-name"));

	     lastName.sendKeys("Shukla");

	     // Postal Code
	     WebElement postalCode =
	             driver.findElement(By.id("postal-code"));

	     postalCode.sendKeys("212601");

	     System.out.println("Checkout Information Entered");

	     Thread.sleep(2000);

	     // Continue Button
	     WebElement continueBtn =
	             driver.findElement(By.id("continue"));

	     if (continueBtn.isDisplayed()) {

	         System.out.println("Continue Button Visible");
	     }

	     continueBtn.click();

	     System.out.println("Continue Button Clicked");
	     driver.findElement(By.id("finish")).click();

	     Thread.sleep(3000);
	 }
	
  @AfterTest
  public void afterTest() {
  }

}