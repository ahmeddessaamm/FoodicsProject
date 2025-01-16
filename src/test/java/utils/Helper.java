package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    public Helper() {
    }


    public static void caputreScreenshot(WebDriver driver, String ScreenshotName) {
        Path destination = Paths.get("./ScreenShots", ScreenshotName + ".png");

        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream out = new FileOutputStream(destination.toString());
            out.write((byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException var4) {
            System.out.print("Exception while taking S.S  :" + var4.getMessage());
        }

    }
}

