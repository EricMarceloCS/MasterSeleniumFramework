package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.ProductPage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigateFromHomeToStoreUsingMainMenu() {
        StorePage storePage = new HomePage(getWebDriver())
                .load()
                .getHeaderPage()
                .navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }

    @Test
    public void navigateFromStoreToProductPage() {
        ProductPage productPage = new StorePage(getWebDriver())
                .load()
                .navigateToProductPage();
        Assert.assertEquals(productPage.getTitle(), "Blue Shoes");
    }

    @Test
    public void navigateFromHomeToFeaturedProductPage() {
        ProductPage productPage = new HomePage(getWebDriver())
                .load()
                .navigateFromHomeToFeaturedProductPage();
        Assert.assertEquals(productPage.getTitle(), "Blue Shoes");
    }

}
