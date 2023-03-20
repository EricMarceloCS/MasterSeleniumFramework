package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchWithPartialMatch(){
        StorePage storePage = new StorePage(getWebDriver())
                .load()
                .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
    }
}
