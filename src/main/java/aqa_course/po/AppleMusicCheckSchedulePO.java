package aqa_course.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicCheckSchedulePO {
    private WebDriver driver = getDriver();

    @FindBy(xpath = "//*[@id=\"navigation\"]/div[1]/div/ul/li[3]/a")
    private WebElement radioButton;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/main/div/div[2]/div/ul/li[1]/div/div[2]/amp-contextual-menu-button/button")
    private WebElement advanceButton;

    @FindBy(xpath = "/html/body/amp-contextual-menu/div/div/ul/amp-contextual-menu-item[1]/li/button")
    private WebElement viewSchedule;

    public AppleMusicCheckSchedulePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openRadioTab() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(radioButton)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(radioButton)).click();
    }

    public void openAdvanceTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(advanceButton)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(advanceButton)).click();
    }

    public void checkRadioSchedule() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(viewSchedule)).click();
    }
}