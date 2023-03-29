package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.api.actions.CartAPI;
import dev.ericmarcelo.selenium.pom.api.actions.SignUpAPI;
import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.Product;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.pages.AccountPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test
    public void validateExistingOrder() throws InterruptedException {
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
        injectCookiesToBrowser(cartAPI.getCookies());
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

        Thread.sleep(5000);
        injectCookiesToBrowser(signUpAPI.getCookies());
        injectCookiesToBrowser(cartAPI.getCookies());
        AccountPage accountPage = checkoutPage.clickAccountMenu();
        Thread.sleep(5000);
        accountPage.selectOrders();
        Thread.sleep(5000);

        accountPage.clickOrderViewBtn();
        Assert.assertEquals(accountPage.getAccountOrderDetails(), "Order details");

    }
}
