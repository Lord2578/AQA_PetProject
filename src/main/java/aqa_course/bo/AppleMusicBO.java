package aqa_course.bo;

import aqa_course.po.AppleMusicSearchPO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicBO  {
    private final WebDriver driver = getDriver();
    private final AppleMusicSearchPO appleMusicPo = new AppleMusicSearchPO();
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Step("Search post")
    public AppleMusicBO search(String post) throws InterruptedException {
        getDriver().get("https://music.apple.com/us/home");
        Thread.sleep(5000);
        appleMusicPo.search(post);
        return this;
    }

    @Step("Check search results")
    public void checkResults() {
        logger.info("Checking search results for musician");
        try {
            Thread.sleep(2000);
            WebElement results = driver.findElement(By.id("contents"));
            if (results.isDisplayed()) {
                System.out.println("results displayed");
            } else {
                System.out.println("no found");        }
        } catch (Exception e) {
            System.out.println("error while checking the results: " + e.getMessage());
        }}

    @Step("Play music from search and open it")
    public void openMusic() {
        logger.info("Playing music");
        appleMusicPo.playMusic();
    }
}
