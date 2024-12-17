package aqa_course.bo;

import aqa_course.po.AppleMusicCheckSchedulePO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicCheckScheduleBO implements ITestListener, ISuiteListener {
    protected final Logger logger = LogManager.getLogger(this.getClass());
    private final WebDriver driver = getDriver();
    private final AppleMusicCheckSchedulePO appleMusicCheckSchedulePO = new AppleMusicCheckSchedulePO(driver);

    @Step("Navigating to apple music home page")
    public AppleMusicCheckScheduleBO goToAppleMusicHomePage() {
        logger.info("navigating to apple music home page");
        driver.get("https://music.apple.com/us/home");
        return this;
    }

    @Step("Check radio schedule")
    public boolean checkRadioSchedule() throws InterruptedException {
        logger.info("navigate to radio tab");
        appleMusicCheckSchedulePO.openRadioTab();

        logger.info("opening advanced tab");
        appleMusicCheckSchedulePO.openAdvanceTab();

        logger.info("select radio schedule");
        appleMusicCheckSchedulePO.checkRadioSchedule();

        logger.info("U can see radio schedule");
        return true;
    }
}