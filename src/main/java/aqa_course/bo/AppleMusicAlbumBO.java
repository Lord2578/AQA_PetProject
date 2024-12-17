package aqa_course.bo;

import aqa_course.po.AppleMusicAlbumPO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicAlbumBO implements ITestListener, ISuiteListener {
    private final WebDriver driver = getDriver();
    private final AppleMusicAlbumPO appleAlbumMusicPo = new AppleMusicAlbumPO();
    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Step("Search post")
    public AppleMusicAlbumBO search(String post) throws InterruptedException {
        getDriver().get("https://music.apple.com/us/home");
        Thread.sleep(5000);
        appleAlbumMusicPo.search(post);
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

    @Step("Open song details")
    public void openAlbum() {
        logger.info("Opening music details");
        appleAlbumMusicPo.openSongDetails();
        logger.info("Opening song album");
        appleAlbumMusicPo.openAlbumSong();
    }

    @Step("Play album preview")
    public void playAlbumPreview() {
        logger.info("Playing album preview");
        appleAlbumMusicPo.playAlbumPreview();
    }
}
