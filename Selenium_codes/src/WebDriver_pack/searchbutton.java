//package WebDriver_pack;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class searchbutton {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.google.com/");
//
//        Thread.sleep(2000);
//
//        driver.findElement(By.name("q")).click();
//
//        driver.findElement(By.name("q")).sendKeys("nature images");
//
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//
//    }
//
//}

package WebDriver_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchbutton {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tirabeauty.com/");

        Thread.sleep(1000);

        driver.findElement(By.id("search")).click();

        driver.findElement(By.id("search")).sendKeys("lipstick");

        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);

    }

}