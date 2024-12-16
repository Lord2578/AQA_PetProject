package aqa_course.bo;

import aqa_course.po.RedditPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static aqa_course.driver.DriverProvider.driver;
import static aqa_course.driver.DriverProvider.getDriver;

public class RedditBO {
    static RedditPO redditPO = new RedditPO();
    public RedditBO search(String query) {
        getDriver().get("https://reddit.com/");
        redditPO.search(query);
        return this;
    }

    public void checkResults() {
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

    public void openFirstPost() {
        redditPO.runFirstPost();
    }
}
