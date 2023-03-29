package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.api.actions.CartAPI;
import dev.ericmarcelo.selenium.pom.api.actions.CheckoutAPI;
import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.User;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.utils.FakerUtils;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxesTest extends BaseTest {

    @Test
    public void validateSalesTax() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(getWebDriver()).load();
        CheckoutAPI checkoutAPI = new CheckoutAPI();
        BillingAddress billingAddress = checkoutAPI.guestCheckout(this);
        System.out.println(billingAddress);
        CartPage cartPage = new CartPage(getWebDriver());

        checkoutPage
                .load()
                .setBillingAddress(billingAddress);
        Thread.sleep(10000);

        Assert.assertEquals(cartPage.getTax().substring(0, 12), "CA State Tax");

    }
}
