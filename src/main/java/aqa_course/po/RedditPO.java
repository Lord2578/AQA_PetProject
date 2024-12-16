package aqa_course.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static aqa_course.driver.DriverProvider.driver;
import static aqa_course.driver.DriverProvider.getDriver;

public class RedditPO {
    @FindBy(xpath = "//*[@id=\"search-input\"]//label/div")
    WebElement searchBox;

    public RedditPO() {
        PageFactory.initElements(getDriver(), this);
    }

    public void search(String query) {
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.submit();
    }

    public void runFirstPost() {
        String postXPath = "//*[@id=\"t3_1heq4a3\"]/a[1]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Adjust timeout as needed
        WebElement firstPost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(postXPath)));
        firstPost.click();
    }
}
