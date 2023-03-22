package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.ProductPage;
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

    @Test
    public void searchWithExactMatch() {
        ProductPage productPage = new StorePage(getWebDriver())
                .load()
                .searchExact("Blue Shoes");
        Assert.assertEquals(productPage.getTitle(), "Blue Shoes");
    }

    @Test
    public void searchNonExistingProduct() {
        StorePage storePage = new StorePage(getWebDriver())
                .load()
                .search("car");

        Assert.assertEquals(
                storePage.getNoProduct(),
                "No products were found matching your selection.");
    }
}
