package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void navigateFromHomeToStoreUsingMainMenu() {
        StorePage storePage = new HomePage(getWebDriver())
                .load()
                .navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getTitle(), "Store");
    }
}
