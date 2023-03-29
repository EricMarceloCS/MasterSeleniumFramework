package dev.ericmarcelo.selenium.pom.api.actions;

import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.utils.FakerUtils;

public class CheckoutAPI {

    public BillingAddress guestCheckout(BaseTest baseTest) {

        CartAPI cartAPI = new CartAPI();
        cartAPI.addToCart(1215, 1);
        baseTest.injectCookiesToBrowser(cartAPI.getCookies());

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

        return billingAddress;
    }
}
