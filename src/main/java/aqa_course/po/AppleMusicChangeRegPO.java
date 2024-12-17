package aqa_course.po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicChangeRegPO {
    private WebDriver driver = getDriver();

    @FindBy(xpath = "//*[@id=\"navigation\"]/div[1]/div/ul/li[3]/a")
    private WebElement radioButton;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/footer/div[1]/div/button")
    private WebElement changeRegion;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/footer/div[1]/dialog/div/div[2]/ul[3]/li[42]/a")
    private WebElement uaRegionOption;

    public AppleMusicChangeRegPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openRadioTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", radioButton);
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(radioButton)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(radioButton)).click();
    }

    public void openChangeRegion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(changeRegion)).click();
    }

    public void selectUaRegion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(uaRegionOption)).click();
    }
}