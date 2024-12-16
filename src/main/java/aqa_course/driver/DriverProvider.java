package aqa_course.driver;

import aqa_course.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverProvider {
    public static WebDriver driver;

    /**
     * Returns a singleton instance of WebDriver based on the specified browser in the properties file.
     * Defaults to Chrome if no browser is specified.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = PropertyReader.getProperty("browser");
            if (browser == null || browser.isEmpty()) {
                browser = "chrome"; // Default to Chrome if no browser is specified
            }

            switch (browser.toLowerCase()) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "chrome":
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    /**
     * Quits the WebDriver instance and sets it to null.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}