package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());

    @Parameters({ "selenium.browser"})
    @BeforeTest
    public void setUp(@Optional("Firefox") String browserName) {
        driver = BrowserFactory.getBrowser(browserName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Set timeout fro 3 seconds");
        driver.get("http://www.google.by/");
        log.info("------ Start ------");
    }

    @Attachment
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterTest
    public void shutDown() {
        driver.quit();
        log.info("Driver shut down");
    }
}
