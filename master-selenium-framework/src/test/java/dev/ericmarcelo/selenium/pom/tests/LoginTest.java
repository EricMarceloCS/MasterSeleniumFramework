package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.api.actions.CartAPI;
import dev.ericmarcelo.selenium.pom.api.actions.SignUpAPI;
import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.objects.Product;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.pages.AccountPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.utils.FakerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void loginDuringCheckout() throws InterruptedException {

        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");

        SignUpAPI signUpAPI = new SignUpAPI();
        signUpAPI.register(user);
        CartAPI cartAPI = new CartAPI();
        Product product = new Product(1215);
        product.setName("Blue Shoes");
        cartAPI.addToCart(product.getProductId(), 1);

        CheckoutPage checkoutPage = new CheckoutPage(getWebDriver()).load();
        Thread.sleep(5000);
        injectCookiesToBrowser(cartAPI.getCookies());
        checkoutPage.load();
        Thread.sleep(5000);
        checkoutPage.enterLogin();

        checkoutPage
                .setUser(user)
                .login();
        Thread.sleep(5000);
        Assert.assertTrue(checkoutPage.getProductName().contains(product.getName()));
    }
    @Test
    public void loginFail() {
        AccountPage accountPage = new AccountPage(getWebDriver())
                .load()
                .enterBadLogin();
        Assert.assertTrue(accountPage.getErrorNotice().contains("Error"));

    }
}
