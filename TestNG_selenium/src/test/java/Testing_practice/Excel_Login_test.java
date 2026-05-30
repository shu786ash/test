package Testing_practice;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel_Login_test {

	WebDriver driver;

	@DataProvider(name = "logindata")

	public Object[][] getData() throws Exception {

		FileInputStream file =
				new FileInputStream("D:\\LoginData.xlsx");

		XSSFWorkbook workbook =
				new XSSFWorkbook(file);

		XSSFSheet sheet =
				workbook.getSheet("Sheet2");

		int rows =
				sheet.getPhysicalNumberOfRows();

		int cols =
				sheet.getRow(0).getLastCellNum();

		Object[][] data =
				new Object[rows - 1][cols];

		for (int i = 1; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i - 1][j] =
						sheet.getRow(i)
						.getCell(j)
						.toString();
			}
		}

		workbook.close();

		return data;
	}

	@Test(dataProvider = "logindata")

	public void loginTest(
			String user1,
			String pass1)
			throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(5));

		driver.get(
		"http://zero.webappsecurity.com/login.html");

		WebElement username =
				driver.findElement(
				By.id("user_login"));

		username.sendKeys(user1);

		WebElement password =
				driver.findElement(
				By.id("user_password"));

		password.sendKeys(pass1);

		driver.findElement(
				By.name("submit"))
				.click();

		System.out.println(
				"Login Tested For : "
				+ user1);

		Thread.sleep(3000);

		driver.quit();
	}
}