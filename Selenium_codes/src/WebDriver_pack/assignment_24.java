package WebDriver_pack;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class assignment_24 {
	public static void main(String args[]) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement contact = driver.findElement(By.id("phone"));
		WebElement address = driver.findElement(By.id("textarea"));
		WebElement gender = driver.findElement(By.id("male"));
		WebElement country = driver.findElement(By.id("country"));
		WebElement colors = driver.findElement(By.id("colors"));
		WebElement animals = driver.findElement(By.id("animals"));
		WebElement date1=driver.findElement(By.id("datepicker"));
		WebElement date2=driver.findElement(By.id("txtDate"));
		//WebElement startdate=driver.findElement(By.xpath("//*[@id=\"start-date\"]"));
		//WebElement enddate=driver.findElement(By.xpath("//*[@id=\"end-date\"]"));
		WebElement submit=driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[8]/button"));
		WebElement singlefile=driver.findElement(By.id("singleFileInput"));
		WebElement multifile=driver.findElement(By.id("multipleFilesInput"));


		name.sendKeys("Ashish Shukla");
		Thread.sleep(1000);

		email.sendKeys("shu786ash123@gmail.com");
		Thread.sleep(1000);

		contact.sendKeys("6393549105");
		Thread.sleep(1000);

		address.sendKeys("Fatehpur U.P.");
		Thread.sleep(1000);

		gender.click();

		Thread.sleep(1000);

		driver.findElement(By.id("tuesday")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("wednesday")).click();

		Thread.sleep(1000);

		country.sendKeys("India");
		country.sendKeys(Keys.ENTER);

		Thread.sleep(1500);

		colors.sendKeys("Yellow");
		colors.sendKeys(Keys.ENTER);

		Thread.sleep(1500);

		animals.sendKeys("Lion");
		animals.sendKeys(Keys.ENTER);

		Thread.sleep(1500);

		date1.sendKeys("05/13/2026");
		date1.sendKeys(Keys.ENTER);

		Thread.sleep(1500);

		date2.sendKeys("18/05/2026");
		date2.sendKeys(Keys.ENTER);

		Thread.sleep(1500);

		driver.findElement(By.id("start-date")).sendKeys("11/11/2026");

		Thread.sleep(1500);

		driver.findElement(By.id("end-date")).sendKeys("16/12/2026");

		Thread.sleep(1500);

		submit.click();

		Thread.sleep(2000);

		singlefile.sendKeys("C:\\Users\\shu78\\OneDrive\\Desktop\\NIK PHOTO.jpg");

		Thread.sleep(2000);

		multifile.sendKeys("C:\\Users\\shu78\\OneDrive\\Desktop\\ashish_info.jpg");

		Thread.sleep(2000);

		multifile.sendKeys("C:\\Users\\shu78\\OneDrive\\Desktop\\ashish_info.pdf");

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(2000);

		TakesScreenshot tc=(TakesScreenshot)driver;

		File sc=tc.getScreenshotAs(OutputType.FILE);

		File dest=new File("Demoform1.png");

		FileHandler.copy(sc,dest);

		Thread.sleep(3000);
		
		
		// dynamic click

		WebElement dcc = driver.findElement(
	    By.xpath("//button[@class='start']"));
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.moveToElement(dcc).click().perform();
		Thread.sleep(2000);
		// simple alert

		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		// confirmation alert

		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);

		// prompt Alert

		driver.findElement(By.id("promptBtn")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Harry");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);

		// click on New Tab button

		WebElement newtab = driver.findElement(
		By.xpath("//button[contains(text(),'New Tab')]"));
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(newtab).click().perform();
		Thread.sleep(3000);

		// switch to new tab

		String mainwindow = driver.getWindowHandle();
		for(String win : driver.getWindowHandles()) {
			if(!win.equals(mainwindow)) {
				driver.switchTo().window(win);
				Thread.sleep(2000);
				driver.close();
			}
		}
		// back to main window
		driver.switchTo().window(mainwindow);
		Thread.sleep(2000);
		// popup window button

		WebElement popup = driver.findElement(By.id("PopUp"));
		ac1.moveToElement(popup).click().perform();
		Thread.sleep(3000);
		// handle popup window

		for(String win : driver.getWindowHandles()) {
			if(!win.equals(mainwindow)) {
				driver.switchTo().window(win);
				Thread.sleep(2000);
				driver.close();
			}
		}

		// switch back to main window

		driver.switchTo().window(mainwindow);
		Thread.sleep(2000);
		// mouse hover

		WebElement hover = driver.findElement(
	    By.xpath("//button[contains(text(),'Point Me')]"));
		Actions ac11 = new Actions(driver);
		Thread.sleep(2000);
		ac11.moveToElement(hover).perform();
		Thread.sleep(3000);
		// double click

		WebElement dc = driver.findElement(
		By.xpath("//button[contains(text(),'Copy Text')]"));
		Thread.sleep(2000);
		ac11.doubleClick(dc).perform();
		Thread.sleep(3000);

		// drag and drop

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		ac11.clickAndHold(source).perform();
		Thread.sleep(2000);
		ac11.moveToElement(target).perform();
		Thread.sleep(2000);
		ac11.release(target).perform();
		Thread.sleep(3000);
		// slider

		WebElement slider = driver.findElement(
		By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		Thread.sleep(2000);
		ac11.dragAndDropBy(slider, 80, 0).perform();
		Thread.sleep(3000);
		// scrolling dropdown
		WebElement drop = driver.findElement(By.id("comboBox"));
		drop.click();
		Thread.sleep(2000);
		drop.sendKeys("Item 7");
		Thread.sleep(2000);
		drop.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		     driver.quit();
	}

}
