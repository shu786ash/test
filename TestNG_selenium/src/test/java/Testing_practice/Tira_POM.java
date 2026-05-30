
package Testing_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Tira_POM {

	WebDriver driver;

	public Tira_POM(WebDriver driver) {

		this.driver = driver;
	}

	By search =By.id("search");

	By branddropdown =By.xpath("//div[@id='Brand']//button");

	By nivea =By.xpath("//div[text()='Nivea']");

	By skintypedropdown =By.xpath("//div[@id='Skin Type']//button");

	By oily =By.xpath("//div[text()='Oily']");

	By product =By.xpath("/html/body/div/div/div[2]/div[4]/div[2]/div[2]/div/div/div[1]/a/div/div[1]/div[2]/div[1]/div[1]");

	By addtobag =By.xpath("//button[./span[text()='Add To Bag']]");

	By cart =By.cssSelector("a[href='/cart/bag']");

	By loginbutton =By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/div/button");

	By mobilenumber =By.xpath("//input[@id='mobile-number-input' or @name='mobile-number']");

	By checkbox =By.xpath("//div[contains(@class, 'filterCheckbox')] | //div[contains(@class, 'checkbox')]");

	By sendotp =By.xpath("//button[text()='Send OTP']");

	public void searchproduct() throws InterruptedException {

		driver.findElement(search).click();
		driver.findElement(search).sendKeys("Men's facewash");
		Thread.sleep(2000);
		driver.findElement(search).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	public void filterproduct()	throws InterruptedException {

		driver.findElement(branddropdown).click();

		Thread.sleep(2000);

		driver.findElement(nivea).click();

		Thread.sleep(2000);

		driver.findElement(skintypedropdown).click();

		Thread.sleep(2000);

		driver.findElement(oily).click();

		Thread.sleep(2000);
	}

	public void addtocart() throws InterruptedException {

		driver.findElement(product).click();

		Thread.sleep(3000);

		String mainwindow = driver.getWindowHandle();

		for(String win :driver.getWindowHandles()) {

			if(!win.equals(mainwindow)) {
				driver.switchTo().window(win);
				break;
			}
		}

		driver.findElement(addtobag).click();

		Thread.sleep(2000);
		driver.findElement(cart).click();
		Thread.sleep(2000);
	}

	public void login() throws InterruptedException {

		driver.findElement(loginbutton).click();
		Thread.sleep(2000);
		driver.findElement(mobilenumber).sendKeys("6393549105");
		Thread.sleep(2000);
		driver.findElement(checkbox).click();
		Thread.sleep(2000);
		driver.findElement(sendotp).click();
		Thread.sleep(2000);
	}
}