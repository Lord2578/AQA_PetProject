package aqa_course.bo;

import aqa_course.po.AppleMusicChangeRegPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicChangeRegBO implements ITestListener, ISuiteListener {
    protected final Logger logger = LogManager.getLogger(this.getClass());
    private final WebDriver driver = getDriver();
    private final AppleMusicChangeRegPO appleMusicChangeRegPO = new AppleMusicChangeRegPO(driver);

    @Step("Navigating to apple music home page")
    public AppleMusicChangeRegBO goToAppleMusicHomePage() {
        logger.info("navigating to apple music home page");
        driver.get("https://music.apple.com/us/home");
        return this;
    }

    @Step("Changing region to UA")
    public boolean changeToUaRegion() throws InterruptedException {
        logger.info("navigate to radio tab");
        appleMusicChangeRegPO.openRadioTab();

        logger.info("opening regions");
        appleMusicChangeRegPO.openChangeRegion();

        logger.info("selecting ua region");
        appleMusicChangeRegPO.selectUaRegion();

        logger.info("dark theme selected successfully");
        return true;
    }
}