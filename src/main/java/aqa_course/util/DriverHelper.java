package aqa_course.util;

import org.openqa.selenium.WebDriver;

public class DriverHelper {

    public static void maximizeWindow(WebDriver driver) {
        if (driver != null) {
            driver.manage().window().maximize();
            System.out.println("Browser window maximized");
        }
    }

    public static void quitDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully");
        }
    }
}
