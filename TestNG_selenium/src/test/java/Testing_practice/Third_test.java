package Testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Third_test {
	
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

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("user-name")));

        username.sendKeys("problem_user");

        WebElement password =
                driver.findElement(By.id("password"));

        password.sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();
        
        System.out.println("Login Successful");

        Thread.sleep(3000);
    }
  
	@Test(priority = 2)
    public void multiple_search() throws InterruptedException {

        WebElement backpack =
                driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        System.out.println(backpack.getText());

        WebElement bikeLight =
                driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));

        System.out.println(bikeLight.getText());
//
//        WebElement tshirt =
//                driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
//
//        System.out.println(tshirt.getText());

        Thread.sleep(3000);
    }
	@Test(priority=3)
	public void left_menu_button() throws InterruptedException {

		   
	    WebElement menu = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.id("react-burger-menu-btn")));

	    menu.click();
       
	    
        System.out.println("Left Menu Opened");

	    Thread.sleep(3000);
	    
	    Thread.sleep(2000);

	    
	    WebElement allItems = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.id("inventory_sidebar_link")));

	    allItems.click();

	    System.out.println("All Items Selected");

	  
	    WebElement closeMenu = driver.findElement(
	            By.id("react-burger-cross-btn"));

	    closeMenu.click();

	    System.out.println("Left Menu Closed");

	    Thread.sleep(3000);
	}
	@Test(priority = 4)
	public void filter_button() throws InterruptedException {

	   
	    WebElement filter = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.className("product_sort_container")));

	    filter.click();

	    Thread.sleep(2000);

	    Select sl = new Select(filter);

	    sl.selectByVisibleText("Price (high to low)");

	    System.out.println("Filter Applied Successfully");

	    Thread.sleep(3000);
	}

	@Test(priority = 5)
    public void add_to_cart() throws InterruptedException {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        System.out.println("Product Added To Cart");

        Thread.sleep(3000);
    }
	@Test(priority = 6)
    public void product_details() throws InterruptedException {

        driver.findElement(
                By.xpath("//div[text()='Sauce Labs Backpack']"))
                .click();

        WebElement details =
                driver.findElement(By.className("inventory_details_desc"));

        System.out.println("Product Details : " + details.getText());

        Thread.sleep(3000);

        driver.navigate().back();
    }
	@Test(priority = 7)
    public void delete_cart_item() throws InterruptedException {

        driver.findElement(By.id("remove-sauce-labs-backpack"))
                .click();

        System.out.println("Cart Item Removed");

        Thread.sleep(3000);
    }

	@Test(priority = 8)
    public void add() throws InterruptedException {

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Thread.sleep(2000);

		driver.findElement(
				By.xpath("//*[@id=\"about_sidebar_link\"]"))
				.click();
		driver.navigate().back();
				Thread.sleep(3000);

				System.out.println("about section covered");

        Thread.sleep(1000);
    }
	@Test(priority = 9)
    public void logout() throws InterruptedException {

		driver.findElement(By.id("react-burger-menu-btn")).click();

		Thread.sleep(2000);

		driver.findElement(
				By.xpath("//*[@id=\"logout_sidebar_link\"]"))
				.click();

				Thread.sleep(3000);

				System.out.println("Logout successful");

        Thread.sleep(1000);
    }
	
  @AfterTest
  public void afterTest() throws InterruptedException {
	  System.out.println("Successfully done");
	  Thread.sleep(1000);
	  driver.close();
  }

}