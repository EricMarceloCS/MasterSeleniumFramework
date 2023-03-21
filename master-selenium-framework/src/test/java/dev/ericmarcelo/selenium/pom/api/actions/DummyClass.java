package dev.ericmarcelo.selenium.pom.api.actions;

import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.utils.FakerUtils;

public class DummyClass {

    public static void main(String[] args) {
        // Sign Up API
        //new SignUpAPI().getAccount();

        // Parse and fetch using Jsoup
        //System.out.println(new SignUpAPI().fetchRegisterNonceValueUsingJsoup());

        // Post Account API
        /*SignUpAPI signUpAPI = new SignUpAPI();
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");
        System.out.println(signUpAPI.register(user));
        System.out.println(signUpAPI.getCookies());*/

        // Add to cart API
        /*CartAPI cartAPI = new CartAPI();
        cartAPI.addToCart(1215, 1);
        System.out.println(cartAPI.getCookies());*/

        // Add to cart API Logged In
        SignUpAPI signUpAPI = new SignUpAPI();
        String username = "demouser" + new FakerUtils().generateRandomNumber();
        User user = new User()
                .setUsername(username)
                .setPassword("demopwd")
                .setEmail(username + "@askomdch.com");
        signUpAPI.register(user);
        System.out.println("REGISTER COOKIES: " + signUpAPI.getCookies());

        CartAPI cartAPI = new CartAPI(signUpAPI.getCookies());
        cartAPI.addToCart(1215, 1);
        System.out.println("CART COOKIES: " + cartAPI.getCookies());
    }
}
