package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void adToCartFromStorePage(){
        CartPage cartPage = new StorePage(getWebDriver())
                .load()
                .clickAddToCartButton("Blue Shoes")
                .clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    }
}
