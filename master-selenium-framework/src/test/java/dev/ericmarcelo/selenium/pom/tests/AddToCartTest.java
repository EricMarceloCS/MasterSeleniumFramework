package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.ProductPage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() {
        CartPage cartPage = new StorePage(getWebDriver())
                .load()
                .clickAddToCartButton("Blue Shoes")
                .clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
    }

    @Test
    public void addToCartFromProductPage() {
        ProductPage productPage = new ProductPage(getWebDriver())
                .load()
                .clickAddToCartButton();
        Assert.assertTrue(
                productPage
                        .getMessage()
                        .stream()
                        .anyMatch(we -> we.getText().contains("“Blue Shoes” has been added to your cart."))
        );
    }
}
