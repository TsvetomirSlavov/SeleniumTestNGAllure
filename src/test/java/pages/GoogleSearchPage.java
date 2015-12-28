package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {

    private By searchField = By.id("lst-ib");
    private By searchButton = By.xpath("//input[@type='submit']");
    private By searchImageAction = By.xpath("//a[@id='gb_2']/span[@class = 'gb_P']");

    final String CREATE_ACCOUNT_LINK = "//a[contains(text(), 'Create account')]";
    @FindBy(xpath = CREATE_ACCOUNT_LINK)
    private WebElement createAccountLink;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void doSearch(String key){
        driver.findElement(searchField).clear();
        log.info("Clear 'searchField'");
        driver.findElement(searchField).sendKeys(key);
        log.info("Send keys to 'searchField': " + key);
        driver.findElement(searchButton).click();
        log.info("Click 'searchButton'");
    }

    public void goToImageSearch(){
        driver.findElement(searchImageAction).click();
        log.info("Click 'searchImageAction'");
    }
}
