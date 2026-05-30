package WebDriver_pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlValidation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        Thread.sleep(3000);
        //String expectedurl = "https://www.selenium.dev/downloads"; fail case hai 
        String expectedurl = "https://www.selenium.dev/downloads/";
        String actualurl = driver.getCurrentUrl();

        System.out.println("Expected URL is=" + expectedurl);
        System.out.println("Actual URL is=" + actualurl);

        if (expectedurl.equals(actualurl)) {
            System.out.println("URL validation pass");
        } else {
            System.out.println("URL validation fail");
        }

        Thread.sleep(3000);
        driver.close();
    }
}