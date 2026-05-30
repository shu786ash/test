package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;

	public Properties prop;

	@BeforeMethod

	public void setup() throws Exception {

		prop = new Properties();

		FileInputStream fis =
		new FileInputStream(
		"src/main/resources/config/config.properties");

		prop.load(fis);

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(10));

		driver.get(
		prop.getProperty("url"));
	}

	@AfterMethod

	public void tearDown() {

		driver.quit();
	}
}