package Testing_practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assign_22 {

	public static void main(String[] args) throws InterruptedException {
	
	    WebDriver driver;
	    WebDriverWait wait = null;
	    

		driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.nykaa.com/");
    
        WebElement beautyAdvice =
                driver.findElement(By.xpath("//a[contains(text(),'Beauty Advice')]"));

        Actions act = new Actions(driver);

        act.moveToElement(beautyAdvice).perform();

        Thread.sleep(3000);

        
        driver.navigate().to("https://www.nykaa.com/sp/shop-all-buying-guide/shop-all-buying-guide");
       

        Thread.sleep(5000);
        
        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {

            driver.switchTo().window(win);
        }

        
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(3000);
        WebElement quiz =
                driver.findElement(By.xpath("//*[@id=\"647ec626afcf43a5c726811e\"]/a/img"));

        quiz.click();

        Thread.sleep(5000);
        WebElement quiz1 =driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/div/div[1]/div[2]/div[2]/img"));

        quiz1.click();
        List<WebElement> radio1 = driver.findElements(By.className("ques-radio"));
		js.executeScript("arguments[0].scrollIntoView(true);", radio1.get(1));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", radio1.get(1));
		
		List<WebElement> radio2 = driver.findElements(By.id("q2c"));
		js.executeScript("arguments[0].scrollIntoView(true);", radio2.get(0));
		Thread.sleep(300);
		js.executeScript("arguments[0].click();", radio2.get(0));
        
		List<WebElement> radio3 = driver.findElements(By.id("q3b"));
		js.executeScript("arguments[0].scrollIntoView(true);", radio3.get(0));
		Thread.sleep(300);
		js.executeScript("arguments[0].click();", radio3.get(0));

      
        Thread.sleep(5000);
       

       WebElement products =wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Products')]")));

        Assert.assertTrue(products.isDisplayed());

        System.out.println("Quiz Completed Successfully");

      
        js.executeScript("window.scrollBy(0,1000)");
        
        Thread.sleep(3000);
        driver.close();
        
        

	}
}