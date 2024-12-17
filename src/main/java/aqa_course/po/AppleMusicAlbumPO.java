package aqa_course.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static aqa_course.driver.DriverProvider.driver;
import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicAlbumPO {

    @FindBy(xpath = "//*[@id=\"search-input-form\"]/input")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/main/div/div[2]/div[1]/div/ul/li[4]/div/div/div[3]/div/amp-contextual-menu-button/button")
    private WebElement contextMenu;

    @FindBy(xpath = "/html/body/amp-contextual-menu/div/div/ul/amp-contextual-menu-item[1]/li/button")
    private WebElement viewDetails;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/main/div/div[1]/div/div/div[2]/div[2]/p/span[1]/span/a")
    private WebElement albumName;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/main/div/div[1]/div/div/div[2]/div[1]/div/button")
    private WebElement albumPreview;


    public AppleMusicAlbumPO() {
        WebDriver driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void search(String searchPost) {
        searchBox.clear();
        searchBox.sendKeys(searchPost);
        searchBox.submit();
    }

    public void openSongDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(contextMenu)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(contextMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewDetails)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(viewDetails)).click();
    }

    public void openAlbumSong() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(albumName)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(albumName)).click();
    }

    public void playAlbumPreview() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(albumPreview)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(albumPreview)).click();
    }



}
