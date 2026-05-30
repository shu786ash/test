package WebDriver_pack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

public class AmazQA {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.get("https://www.amazon.in/");

		// search box visibility
		WebElement search = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

		search.click();
		search.sendKeys("wireless headphones");
		search.sendKeys(Keys.ENTER);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");

		// filter 1 visibility
		WebElement boat = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"p_123/214020\"]/span/a/div/label")));

		boat.click();

		//TakesScreenshot ts1 = (TakesScreenshot) driver;
		//File src1 = ts1.getScreenshotAs(OutputType.FILE);
	//	FileHandler.copy(src1, new File("BoatFilter.png"));

		// filter 2 visibility
		WebElement noise = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"p_n_g-1003195531111/27957752031\"]/span/a/span")));

		noise.click();

		//TakesScreenshot ts2 = (TakesScreenshot) driver;
	//	File src2 = ts2.getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(src2, new File("NoiseCancellation.png"));

		// filter 3 visibility
		WebElement rating = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"p_72/1318476031\"]/span/div/a/i")));

		rating.click();
		WebElement image = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//img[@class='s-image'])[1]")));
		Thread.sleep(3000);
			String producturl = image.findElement(
					By.xpath("./ancestor::a"))
					.getAttribute("href");
			image.click();

			Thread.sleep(5000);
			driver.navigate().to(producturl);

		// scroll down product page
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)");


		TakesScreenshot ts3 = (TakesScreenshot) driver;
		File src3 = ts3.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src3, new File("4StarFilter.png"));

		Thread.sleep(5000);

		driver.quit();
	}
}