package WebDriver_pack;
 
import java.time.Duration;
import java.util.function.Function;
 
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
// implicit wait- used for all elements(global)
// explicit wait- used for particular element(element based)
//fluent wait-use for specific element- 20 sec, 2 sec
public class Wait_Codes {
 
	public static void main(String[] args) {
	    WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        //implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        //
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));//maximum expected wait
//        driver.get("https://www.amazon.in/");
//       // first element= 2 sec= th 5sec=3 extra// actual waits
//        // second ele =11 sec= 10 sec= 3=
//        // 3 ele= 17 sec-- element not found
//        WebElement searchBox = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
//               
//        );
//        driver.navigate();
        
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        	    .withTimeout(Duration.ofSeconds(30))    // Max wait time
        	    .pollingEvery(Duration.ofSeconds(5))   // Check every 5 seconds
        	    .ignoring(NoSuchElementException.class); // Ignore this error during wait
 
        	WebElement element = wait.until(new Function<WebDriver, WebElement>() {
        	    public WebElement apply(WebDriver driver) {
        	        return driver.findElement(By.id("dynamicElement"));
        	    }
        	});
        	driver.quit();
 
	}
 
}