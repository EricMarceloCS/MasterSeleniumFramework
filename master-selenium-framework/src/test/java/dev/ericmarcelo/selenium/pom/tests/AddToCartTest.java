package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.data.providers.ProductsDataProvider;
import dev.ericmarcelo.selenium.pom.objects.Product;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.ProductPage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Optional;

public class AddToCartTest extends BaseTest {

    @Test
    public void addToCartFromStorePage() {
        CartPage cartPage = new StorePage(getWebDriver())
                .load()
                .getProductThumbnail()
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

    @Test
    public void addToCartFeaturedProducts() {
        List<Product> featuredProducts = new ProductsDataProvider().getFeaturedProducts();
        HomePage homePage = new HomePage(getWebDriver());
        Optional<Product> optionalProduct = featuredProducts.parallelStream().findAny();
        CartPage cartPage = homePage
                .load()
                .getProductThumbnail()
                .clickAddToCartButton(optionalProduct.get().getName())
                .clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), optionalProduct.get().getName());

    }

}
