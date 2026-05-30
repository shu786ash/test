package Testing_practice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Register_test {
    WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		
		driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        
        driver.get("https://demo.automationtesting.in/Register.html");
	}

  @DataProvider(name ="data")
  public Object[][] dp() {
    return new Object[][] {
    	{"ashish", "shukla", "ashish@gmail.com", "9876543543"},
        {"ankit", "Agrawal", "ankit@gmail.com", "9876543540"},
        {"aman", "Agrawal", "aman@gmail.com", "9876543549"},
        {"anand", "Saxsena", "anand@gmail.com", "9876543548"},
        {"alok", "Agrawal", "alok@gmail.com", "9876543547"}
    };
  }
  @Test(dataProvider = "data")
  public void f(String firstname,String lastname,String email,String phone)throws InterruptedException {
	  
	   WebElement fname =
               driver.findElement(By.xpath("//input[@placeholder='First Name']"));

       fname.clear();
       fname.sendKeys(firstname);


       WebElement lname =
               driver.findElement(By.xpath("//input[@placeholder='Last Name']"));

       lname.clear();
       lname.sendKeys(lastname);

     
       WebElement emailField =
               driver.findElement(By.xpath("//input[@type='email']"));

       emailField.clear();
       emailField.sendKeys(email);

     
       WebElement phoneField =
               driver.findElement(By.xpath("//input[@type='tel']"));

       phoneField.clear();
       phoneField.sendKeys(phone);

       
       driver.findElement(By.xpath("//input[@value='FeMale']")).click();

      
       driver.findElement(By.id("checkbox1")).click();

    
       Assert.assertEquals(fname.getAttribute("value"), firstname);

       Assert.assertEquals(emailField.getAttribute("value"), email);

       System.out.println("Registration data entered for : " + firstname);

       Thread.sleep(2000);

 
       driver.navigate().refresh();
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}