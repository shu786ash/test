package WebDriver_pack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon1 {



	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		
		WebElement search=wait.until(  ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		
		search.click();
		search.sendKeys("Watch for women");
		search.sendKeys(Keys.ENTER);
		
		WebElement sonata=wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p_123/318887\"]/span/a/span")));
		
		sonata.click();
		
		WebElement black=wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p_n_g-1004149082091/1480923031\"]/span/a/span/div")));
		
		black.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		
//		WebElement imageLink = driver.findElement(By.xpath("//a[contains(@href,'watch')]"));
//		String url = imageLink.getAttribute("href");

		driver.navigate().to("https://www.amazon.in/sspa/click?ie=UTF8&spc=MTo0MTgyNTEwODgwOTU3NjQzOjE3NzkwOTI5MDk6c3BfYXRmOjMwMDkzMTI1NjczNzIzMjo6MDo6&url=%2FSonata-Quartz-Leather-Women-NS8976YL02W-NT8976YL02W%2Fdp%2FB00K2Q37JS%2Fref%3Dsr_1_1_sspa%3Fdib%3DeyJ2IjoiMSJ9.GZCBgbMvjtB9Pn481-yJmPXzHLhCtLuwPhLbyZyfiyjn3w8MmRKHvTcqtMSHK0a1ahgyXK1qEYiT0aN5L4Q0aV9CdAMeueR5hcDS5sV_MIUO8uoI_jnklAj5xOhRw-0X2R5MKvWuVenV8e2fgGRdAEwl4SaR2lI8fciEb38xfcFuWOAusFgElO_sg7HKWtohiHrcu575KWHJhyzHyGGMELoZmZvOblW1NXW4zOqREKP8fHrvZGeLy_ND5QcqLAEh4_J6Fhc1zWbK-ue4UXEE7EPVjCTfRBKqp-SFKuVIdvQ.p_5b1v1E_nLA1mVpd1ZtJuMVuXw-bPB3A27Udfa5d8o%26dib_tag%3Dse%26keywords%3DWatch%2Bfor%2Bwomen%26qid%3D1779092909%26refinements%3Dp_123%253A318887%252Cp_n_g-1004149082091%253A1480923031%26rnid%3D1480891031%26sr%3D8-1-spons%26aref%3DyMIrqRsYOF%26sp_csd%3Dd2lkZ2V0TmFtZT1zcF9hdGY%26psc%3D1&aref=yMIrqRsYOF&sp_cr=ZAZ");
		
//		WebElement watch=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"fbf6f964-2af7-4266-be13-d1581c8e1e36\"]/div/div/div/div/span/div/div/div[2]/div[1]/a/h2/span")));
		
//		watch.click();
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		File sc=tc.getScreenshotAs(OutputType.FILE);
		   
		File dest=new File("Watch.png");
		FileHandler.copy(sc,dest);	 
		
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		

	}

}