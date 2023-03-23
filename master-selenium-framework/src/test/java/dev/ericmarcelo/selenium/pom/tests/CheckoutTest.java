package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.api.actions.CartAPI;
import dev.ericmarcelo.selenium.pom.api.actions.SignUpAPI;
import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.Product;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    ////////////////// Direct Bank Transfer /////////////////////////////////////
/*

    @Test
    public void guestCheckoutUsingDirectBankTransfer() {
        CheckoutPage checkoutPage = new CheckoutPage(getWebDriver()).load();
        CartAPI cartAPI = new CartAPI();
        cartAPI.addToCart(1215, 1);
        injectCookiesToBrowser(cartAPI.getCookies());

        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");

        BillingAddress billingAddress = new BillingAddress()
                .setFirstName("demo")
                .setLastName("user")
                .setAddress("San Francisco")
                .setCity("San Francisco")
                .setPostalCode("94188")
                .setEmail("askomdch@gmail.com")
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());

        checkoutPage
                .load()
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .placeOrder();

        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        Thread.sleep(5000);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");

        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(user);
        CartAPI cartAPI = new CartAPI(signUpAPI.getCookies());
        Product product = new Product(1215);
        product.setName("Blue Shoes");
        cartAPI.addToCart(product.getProductId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getWebDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(signUpAPI.getCookies());
        checkoutPage.load();


        BillingAddress billingAddress = new BillingAddress()
                .setFirstName("demo")
                .setLastName("user")
                .setAddress("San Francisco")
                .setCity("San Francisco")
                .setPostalCode("94188")
                .setEmail("askomdch@gmail.com")
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());


        checkoutPage
                .load()
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .placeOrder();

        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }
*/

    ///////////////// Cash On Delivery ////////////////////////////
    @Test
    public void guestCheckoutUsingCashOnDelivery() {
        CheckoutPage checkoutPage = new CheckoutPage(getWebDriver()).load();
        CartAPI cartAPI = new CartAPI();
        cartAPI.addToCart(1215, 1);
        injectCookiesToBrowser(cartAPI.getCookies());

        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");

        BillingAddress billingAddress = new BillingAddress()
                .setFirstName("demo")
                .setLastName("user")
                .setAddress("San Francisco")
                .setCity("San Francisco")
                .setPostalCode("94188")
                .setEmail("askomdch@gmail.com")
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());

        checkoutPage
                .load()
                .setBillingAddress(billingAddress)
                .selectCashOnDelivery()
                .placeOrder();

        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }

    @Test
    public void loginAndCheckoutUsingCashOnDelivery() throws InterruptedException {
        Thread.sleep(5000);
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");

        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(user);
        CartAPI cartAPI = new CartAPI(signUpAPI.getCookies());
        Product product = new Product(1215);
        product.setName("Blue Shoes");
        cartAPI.addToCart(product.getProductId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getWebDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(signUpAPI.getCookies());
        checkoutPage.load();


        BillingAddress billingAddress = new BillingAddress()
                .setFirstName("demo")
                .setLastName("user")
                .setAddress("San Francisco")
                .setCity("San Francisco")
                .setPostalCode("94188")
                .setEmail("askomdch@gmail.com")
                .setUsername(user.getUsername())
                .setPassword(user.getPassword());


        checkoutPage
                .load()
                .setBillingAddress(billingAddress)
                .selectCashOnDelivery()
                .placeOrder();

        Assert.assertEquals(checkoutPage.getNotice(),
                "Thank you. Your order has been received."
        );
    }
}
