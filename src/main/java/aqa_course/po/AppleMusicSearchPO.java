package aqa_course.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static aqa_course.driver.DriverProvider.getDriver;

public class AppleMusicSearchPO {

    @FindBy(xpath = "//*[@id=\"search-input-form\"]/input")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"scrollable-page\"]/main/div/div[2]/div[3]/div/div[2]/section/div[1]/ul/li[1]/div/div/div[1]/div[3]/div[1]/button")
    private WebElement firstMusic;


    public AppleMusicSearchPO() {
        WebDriver driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public void search(String searchPost) {
        searchBox.clear();
        searchBox.sendKeys(searchPost);
        searchBox.submit();
    }

    public void playMusic() {
        firstMusic.click();
    }

}
