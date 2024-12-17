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

public class AppleMusicLoginPO {
    private final WebDriver driver = getDriver();

    @FindBy(xpath = "/html/body/div/div/div[3]/div/amp-chrome-player/div[2]/div[2]/button")
    private WebElement signInButton;

    @FindBy(id = "accountName")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"modal-body\"]/cwc-app/div/div/div[3]/button")
    private WebElement continueButton;

    @FindBy(id = "password_text_field")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"sign-in\"]")
    private WebElement logInButton;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/amp-chrome-player/div[2]/div[2]/div/amp-contextual-menu-button/button")
    private WebElement profileButton;

    public AppleMusicLoginPO() {
        PageFactory.initElements(driver, this);
    }

    public void signIn(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        // Заміна стандартного методу sendKeys на JavaScript Executor для введення email
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value=arguments[1];", emailInput, email);

        // Продовження виконання кроків
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);

        logInButton.click();
    }

    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(profileButton)).isDisplayed();
    }
}