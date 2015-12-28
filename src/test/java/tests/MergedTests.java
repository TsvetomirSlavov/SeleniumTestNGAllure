package tests;

import base.BaseTest;
import base.listeners.OnFailure;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleSearchImagePage;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultsPage;
import utils.RandomString;
import utils.ReadTextFromFile;

@Listeners({ OnFailure.class })
public class MergedTests extends BaseTest {


    @Test(description="Navigates to the New Post screen")
    public void test1(){
        log.info("Log step 1: Open search image");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.goToImageSearch();
        
        log.info("Log step 2: Perform search image by URL");
        GoogleSearchImagePage googleSearchImagePage = new GoogleSearchImagePage(driver);
        googleSearchImagePage.doImageSearch("http://www.joomlaworks.net/images/demos/galleries/abstract/7.jpg");
        

        log.info("Log step 3: Assert results");
        try {
            Assert.assertTrue(googleSearchPage.isElementPresent(By.xpath("//*[@id='sbfrm_l']")), "Results weren't found");
        } catch (Exception ex) {
            System.out.println("Cached!");
        }
    }

    @Test(description="Navigates to the New Post screen")
    public void test2(){
        log.info("Log step 1: Perform search");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.doSearch(RandomString.generateString(10));
        

        log.info("Log step 2: Assert results");
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        Assert.assertTrue(googleSearchResultsPage.isElementPresent(By.xpath("//*[@id='topstuff']/div[@class='mnr-c']")), "Results were found!");
        
    }

    @Test(description="Navigates to the New Post screen")
    public void test3(){
        log.info("Log step 1: Perform search");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        googleSearchPage.doSearch(ReadTextFromFile.read("./src/resources/Text.txt"));
        

        log.info("Log step 2: Assert results");
        GoogleSearchResultsPage googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        Assert.assertTrue(googleSearchResultsPage.isElementPresent(By.xpath("//p[contains(text(),'Your client has issued a malformed or illegal request.')]")), "Results were found!");
        
    }

}
