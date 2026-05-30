package Testing_practice;

import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel_Write {

	XSSFWorkbook workbook =new XSSFWorkbook();
	XSSFSheet sheet =workbook.createSheet("Results");
	int rownum = 1;
	@DataProvider(name = "userdata")
	public Object[][] getData() {
		return new Object[][] {
			{"admin","admin123","PASS"},
			{"ashish","ashish@123","FAIL"},
			{"ravi","ravi123","PASS"},
			{"testuser","test@123","FAIL"},
			{"rahul","rahul@786","PASS"}
		};
	}
	@Test(dataProvider = "userdata")
	public void writeExcel(String user,String pass,String result) throws Exception {

		sheet.getRow(0);
		if(sheet.getRow(0) == null) {
			sheet.createRow(0).createCell(0).setCellValue("Username");
			sheet.getRow(0).createCell(1).setCellValue("Password");
			sheet.getRow(0).createCell(2).setCellValue("Result");
		}
		sheet.createRow(rownum).createCell(0).setCellValue(user);
		sheet.getRow(rownum).createCell(1).setCellValue(pass);
		sheet.getRow(rownum).createCell(2).setCellValue(result);
		rownum++;
		FileOutputStream file =new FileOutputStream("D:\\Results5.xlsx");
		workbook.write(file);
		System.out.println("Data Written Successfully");
	}
}