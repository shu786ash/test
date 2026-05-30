package WebDriver_pack;
 
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

//xpath syntax= //node[@attribute="attribute value"]
//select class - used select or deselect options with the help of by selectbyindex, selectbyvalue, selectbyvisibletext

public class DemoQA {
 
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		WebElement fname=driver.findElement(By.id("firstName"));
		//fname.click();
		fname.sendKeys("Ashish");
		
		WebElement lname=driver.findElement(By.id("lastName"));
		//fname.click();
		lname.sendKeys("Shukla");
		 WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("shu786ash123@gmail.com");
        Thread.sleep(1000);
		driver.findElement(By.id("gender-radio-1")).click();
		//input mobile number
		WebElement mobile = driver.findElement(By.id("userNumber"));
         mobile.sendKeys("6393549105");
        Thread.sleep(2000);
		
		// click on date of birth field
		driver.findElement(By.id("dateOfBirthInput")).click();
 
//		WebElement yr=driver.findElement(By.className("react-datepicker__year-select"));
//		WebElement mt=driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]"));
//		Select sel=new Select(yr);
//		sel.selectByIndex(100);
//		Select sel1=new Select(mt);
//		sel1.selectByVisibleText("May");
//		
//		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[5]/div[4]")).click();
		
		// select by xpath
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[1]/div/div[2]/select/option[102]")).click();
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[1]/div/div[1]/select/option[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[4]/div[1]")).click();
		
		// add subjects
		WebElement sub=driver.findElement(By.id("subjectsInput"));
		sub.click();
		sub.sendKeys("com");
		sub.sendKeys(Keys.ARROW_DOWN);
		sub.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label[1]")).click();

		
		driver.findElement(By.xpath("//*[@id=\"hobbies-checkbox-3\"]")).click();
		Thread.sleep(1000);
		WebElement img = driver.findElement(By.id("uploadPicture"));
		img.sendKeys("C:\\Users\\shu78\\OneDrive\\Desktop\\ashish_info.jpg");
		Thread.sleep(1000);
		driver.findElement(By.id("currentAddress")).sendKeys("Fatehpur");
		WebElement state = driver.findElement(By.id("react-select-3-input"));
		state.sendKeys("Uttar Pradesh");
		state.sendKeys(Keys.ENTER);

		
		WebElement city = driver.findElement(By.id("react-select-4-input"));
		city.sendKeys("Lucknow");
		city.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

	//	driver.findElement(By.id("submit")).click();
//		WebElement submit = driver.findElement(By.id("submit"));
//		submit.sendKeys(Keys.ENTER);
		TakesScreenshot tc = (TakesScreenshot)driver;
		File sc = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("DemoQAform.png");
		FileHandler.copy(sc, dest);
		Thread.sleep(5000);
		//js.executeScript("window.scrollBy(0,-500)");
		driver.quit();
 
	}
 
}
