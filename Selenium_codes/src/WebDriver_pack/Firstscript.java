package WebDriver_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firstscript {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty(null, null
		//create webdriver object
		WebDriver driver = new ChromeDriver();
		// navigate to url(webpage url)
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(3000);
		//find element
		driver.findElement(By.id("Layer_1")).click();
		Thread.sleep(3000);
		driver.close();
		

	}

}
