package Testing_practice;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel_data {
	@DataProvider(name = "loginData")
	public Object[][] getData() throws Exception {

		FileInputStream file = new FileInputStream("D:\\LoginData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows - 1][cols];
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

	@Test(dataProvider = "loginData")
	public void loginTest(
			String user1,
			String pass1) {
		System.out.println("Username : " + user1);
		System.out.println("Password : " + pass1);
		System.out.println("Login Successful");
	}
}