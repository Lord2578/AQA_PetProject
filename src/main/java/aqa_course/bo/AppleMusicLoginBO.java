package aqa_course.bo;

import aqa_course.po.AppleMusicLoginPO;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ISuiteListener;
import org.testng.ITestListener;


import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicLoginBO implements ITestListener, ISuiteListener, IExecutionListener {
    private final WebDriver driver = getDriver();
    private final AppleMusicLoginPO loginPO = new AppleMusicLoginPO();
    protected final Logger logger = LogManager.getLogger(this.getClass());


    @Step("Log in with email")
    public void appleMusicLogIn(String email, String password) {
        getDriver().get("https://music.apple.com/us/home");
        logger.info("User starting login");
        loginPO.signIn(email, password);
        logger.info("User login completed");
    }

    @Step("Verifying login status")
    public boolean verifyLogin() {
        logger.info("Verifying if the user is logged in");
        boolean isLoggedIn = loginPO.isUserLoggedIn();
        logger.info("User login status: {}", isLoggedIn);
        return isLoggedIn;
    }
}