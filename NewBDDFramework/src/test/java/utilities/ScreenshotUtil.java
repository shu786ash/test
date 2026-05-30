package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(
    WebDriver driver,
    String screenshotName) {

        try {

            String timeStamp =
            new SimpleDateFormat("yyyyMMdd_HHmmss")
            .format(new Date());

            File src =
            ((TakesScreenshot)driver)
            .getScreenshotAs(OutputType.FILE);

            File dest =
            new File("./Screenshots/"
            + screenshotName + "_"
            + timeStamp + ".png");

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot Captured");

        }

        catch(IOException e) {

            System.out.println(e.getMessage());
        }
    }
}