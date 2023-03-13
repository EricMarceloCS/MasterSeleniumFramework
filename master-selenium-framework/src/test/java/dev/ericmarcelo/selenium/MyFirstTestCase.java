package dev.ericmarcelo.selenium;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.pages.HomePage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void dummyTest() {

        webDriver.get("https://askomdch.com/");
        //webDriver.get("https://www.saucedemo.com/");
        // webDriver.get("https://demoqa.com/");
    }

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(webDriver)
                .load().navigateToStoreUsingMenu()
                .search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartButton("Blue Shoes");
        Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();

        checkoutPage.
                enterFirstName("demo").
                enterLastName("user").
                enterAddress("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("askomdch@gmail.com");

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

        checkoutPage
                .enterUserName("demouser2")
                .enterPassword("demopwd")
                .login();

        checkoutPage.
                enterFirstName("demo").
                enterLastName("user").
                enterAddress("San Francisco").
                enterCity("San Francisco").
                enterPostCode("94188").
                enterEmail("askomdch@gmail.com");

        Thread.sleep(3000);
        checkoutPage.placeOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }
}
