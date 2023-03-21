package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.base.BaseJUnitTest;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import dev.ericmarcelo.selenium.pom.utils.BillingJacksonUtils;
import dev.ericmarcelo.selenium.pom.utils.ConfigLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstJUnitTestCase extends BaseJUnitTest {

    @Test
    public void dummyTest() {

        webDriver.get(ConfigLoader.getInstance().getBaseUrl());
    }

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws IOException {

        BillingAddress billingAddress = new BillingAddress();
        InputStream is = getClass().getClassLoader().getResourceAsStream("BillingAddress.json");
        BillingJacksonUtils.deserializeBillingAddressJson(is, billingAddress);

        StorePage storePage = new HomePage(webDriver)
                .load().navigateToStoreUsingMenu()
                .search("Blue");
        Assertions.assertEquals("Search results: “Blue”", storePage.getTitle());

        storePage.clickAddToCartButton("Blue Shoes");
        CartPage cartPage = storePage.clickViewCart();
        Assertions.assertEquals("Blue Shoes", cartPage.getProductName());

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .placeOrder();

        Assertions
                .assertEquals("Thank you. Your order has been received."
                        , checkoutPage.getNotice());

    }
    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() {

        StorePage storePage = new HomePage(webDriver)
                .load().navigateToStoreUsingMenu()
                .search("Blue");
        Assertions.assertEquals("Search results: “Blue”", storePage.getTitle());

        storePage.clickAddToCartButton("Blue Shoes");
        CartPage cartPage = storePage.clickViewCart();
        Assertions.assertEquals("Blue Shoes", cartPage.getProductName());

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.enterLogin();

        User user = new User()
                .setUsername(ConfigLoader.getInstance().getUsername())
                .setPassword(ConfigLoader.getInstance().getPassword());

        BillingAddress billingAddress = new BillingAddress()
                .setFirstName("demo")
                .setLastName("user")
                .setAddress("San Francisco")
                .setCity("San Francisco")
                .setPostalCode("94188")
                .setEmail("askomdch@gmail.com")
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());

        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.setUser(user);
        checkoutPage.login();
        checkoutPage.placeOrder();

        Assertions
                .assertEquals("Thank you. Your order has been received."
                        , checkoutPage.getNotice());
    }
}
