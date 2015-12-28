package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchImagePage extends BasePage {

    private By searchImage = By.xpath("//a[contains(@class ,'gsst_a')]");
    private By searchImageByURL = By.xpath("//input[@id='qbui']");
    private By searchSubmitButton = By.xpath("//td[@id='qbbtc']/input");

    public GoogleSearchImagePage(WebDriver driver) {
        super(driver);
    }

    public void doImageSearch(String url) {
        driver.findElement(searchImage).click();
        log.info("Click 'searchImage'");
        driver.findElement(searchImageByURL).clear();
        log.info("Clear 'searchImageByURL'");
        driver.findElement(searchImageByURL).sendKeys(url);
        log.info("Send keys to 'searchImageByURL': " + url);
        driver.findElement(searchSubmitButton).click();
        log.info("Click 'searchSubmitButton'");
    }
}
