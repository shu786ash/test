package Testing_practice;

import java.io.File;

import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class assignment_24 {

	public static void main(String[] args) throws InterruptedException,IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement contact = driver.findElement(By.id("phone"));
		WebElement address = driver.findElement(By.id("textarea"));
		WebElement gender = driver.findElement(By.id("female"));
		WebElement country = driver.findElement(By.id("country"));
		WebElement colors = driver.findElement(By.id("colors"));
		WebElement animals = driver.findElement(By.id("animals"));
		WebElement date1=driver.findElement(By.id("datepicker"));
		WebElement date2=driver.findElement(By.id("txtDate"));

		WebElement submit=driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[8]/button"));
		WebElement singlefile=driver.findElement(By.id("singleFileInput"));
		WebElement multifile=driver.findElement(By.id("multipleFilesInput"));	
		name.sendKeys("Ashish");
		email.sendKeys("ashish123@gmail.com");
		contact.sendKeys("9999999999");
		address.sendKeys("FATEHPUR U.P.");
		gender.click();
	
		Thread.sleep(1000);
	
		driver.findElement(By.id("tuesday")).click();
		driver.findElement(By.id("wednesday")).click();
		
		country.sendKeys("India");
		country.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		colors.sendKeys("Yellow");
		colors.sendKeys(Keys.ENTER);
		
		animals.sendKeys("Lion");
		animals.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		date1.sendKeys("05/13/2026");
		date1.sendKeys(Keys.ENTER);
//		
		date2.sendKeys("13/05/2026");
		date2.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("start-date")).sendKeys("05/15/2026");
		driver.findElement(By.id("end-date")).sendKeys("06/20/2026");
//		
		submit.click();
		Thread.sleep(1000);
//		
		 singlefile.sendKeys("C:\\Users\\Dell\\OneDrive\\Desktop\\Assignment_Day1");
		 multifile.sendKeys("C:\\Users\\Dell\\OneDrive\\Documents\\Assignment 9.pdf");
		 multifile.sendKeys("C:\\Users\\Dell\\OneDrive\\Documents\\Assignment 9.pdf");
//		
		 Thread.sleep(1000);
		
//		 TakesScreenshot tc=(TakesScreenshot)driver;
//		File sc=tc.getScreenshotAs(OutputType.FILE);
//		   
//		File dest=new File("Autoform.png");
//		FileHandler.copy(sc,dest);	 
		
		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Alert done");
		
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println(" Confirmation Alert done");
      
		driver.findElement(By.id("promptBtn")).click();
	
		Alert alert=driver.switchTo().alert();
		alert.sendKeys("Ashish");
		Thread.sleep(1000);
		alert.accept();
		System.out.println("Propmt Alert done");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)");
		
		WebElement pointme = driver.findElement(By.xpath("//*[@id=\"HTML3\"]/div[1]/div/button"));
		pointme.click();
		
		WebElement field1 = driver.findElement(By.id("field1"));
		field1.sendKeys("Hello Ashish !");
		
		WebElement dc=driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));
		Thread.sleep(3000);
		Actions ac=new Actions(driver);
		
		ac.doubleClick(dc).perform();
		WebElement src=driver.findElement(By.id("draggable"));
		
		WebElement des=driver.findElement(By.id("droppable"));
		
		ac.dragAndDrop(src, des).perform();
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/div"));
//		
		ac.dragAndDropBy(slider, 0, 80).perform();
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,400)");
		ac.dragAndDropBy(slider, -10, 0).perform();
		
		Thread.sleep(3000);
		WebElement sel = driver.findElement(By.id("comboBox"));
		sel.click();
		WebElement item=driver.findElement(By.xpath("//*[@id=\"dropdown\"]/div[2]"));
		item.click();
		
		
		Thread.sleep(3000);
		driver.close();
		

	}

}