package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TakeScreenshot {
    public static String takeScreenshot(WebDriver driver, String str) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File imgPath = screenshot.getScreenshotAs(OutputType.FILE);

            File scrImg = new File(str);
            FileUtils.copyFile(imgPath, scrImg);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
