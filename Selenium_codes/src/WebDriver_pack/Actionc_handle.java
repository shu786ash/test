package WebDriver_pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionc_handle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		driver.get("https://demoqa.com/buttons");
//
//		// Double click
//
//		WebElement dc = driver.findElement(By.id("doubleClickBtn"));
//
//		Thread.sleep(2000);
//
//		Actions ac = new Actions(driver);
//
//		ac.doubleClick(dc).perform();
//
//		Thread.sleep(2000);
//
//		// Right click
//
//		WebElement rc = driver.findElement(By.id("rightClickBtn"));
//
//		Thread.sleep(2000);
//
//		ac.contextClick(rc).perform();
//
//		Thread.sleep(2000);
//
//		// dynamic click
//
//		WebElement dcc = driver.findElement(
//				By.xpath("(//button[@class=\"btn btn-primary\"])[3]"));
//
//		Thread.sleep(2000);
//
//		ac.moveToElement(dcc).click().perform();
//		driver.get("https://demoqa.com/droppable");
//		WebElement sr = driver.findElement(By.id("draggable"));
//		WebElement tg = driver.findElement(By.id("droppable"));
//		Actions ac = new Actions(driver);
//		Thread.sleep(2000);
//		ac.dragAndDrop(sr, tg).perform();
//        Thread.sleep(2000);
        
//        driver.get("https://testautomationpractice.blogspot.com/");
//		WebElement sr = driver.findElement(By.id("draggable"));
//		//WebElement tg = driver.findElement(By.id("draggable"));
//		Actions ac = new Actions(driver);
//		Thread.sleep(2000);
//		ac.dragAndDropBy(sr, 0, 200).perform();//move right
//        Thread.sleep(2000);
//        ac.dragAndDropBy(sr, -20, 0).perform();//move left
//        Thread.sleep(2000);
		driver.get("https://testautomationpractice.blogspot.com/");
        WebElement sr=driver.findElement(By.xpath("(//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"])[1]"));
        Actions ac=new Actions(driver);
        WebElement moc=driver.findElement(By.xpath("//*[@id=\"HTML3\"]/div[1]/div/button"));
        Thread.sleep(2000);
        ac.moveToElement(moc).perform();
        Thread.sleep(2000);
		driver.close();
	}
}