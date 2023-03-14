package dev.ericmarcelo.selenium;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import dev.ericmarcelo.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void dummyTest() {

        webDriver.get("https://askomdch.com/");
        //webDriver.get("https://www.saucedemo.com/");
        // webDriver.get("https://demoqa.com/");
    }

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException, IOException {

        BillingAddress billingAddress = new BillingAddress();
        InputStream is = getClass().getClassLoader().getResourceAsStream("BillingAddress.json");
        billingAddress = JacksonUtils.deserializeJson(is, billingAddress);

        StorePage storePage = new HomePage(webDriver)
                .load().navigateToStoreUsingMenu()
                .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.setBillingAddress(billingAddress);

        Thread.sleep(3000);
        checkoutPage.placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );

    }
    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(webDriver)
                .load().navigateToStoreUsingMenu()
                .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.enterLogin();
        Thread.sleep(5000);

        User user = new User("demouser2", "demopwd");

        BillingAddress billingAddress = new BillingAddress()
                .setFirstName("demo")
                .setLastName("user")
                .setAddress("San Francisco")
                .setCity("San Francisco")
                .setPostalCode("94188")
                .setEmail("askomdch@gmail.com")
                .setUserName(user.getUserName())
                .setPassword(user.getPassword());

        checkoutPage.setBillingAddress(billingAddress);
        checkoutPage.setUser(user);
        Thread.sleep(3000);

        checkoutPage.login();

        Thread.sleep(5000);
        checkoutPage.placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }
}
