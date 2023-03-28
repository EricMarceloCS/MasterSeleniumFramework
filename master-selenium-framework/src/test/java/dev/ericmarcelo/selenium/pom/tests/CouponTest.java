package dev.ericmarcelo.selenium.pom.tests;

import dev.ericmarcelo.selenium.pom.api.actions.CartAPI;
import dev.ericmarcelo.selenium.pom.base.BaseTest;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import dev.ericmarcelo.selenium.pom.pages.CheckoutPage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CouponTest extends BaseTest {

    private final By couponInput = By.id("coupon_code");
    private final By couponRadioBtn = By.id("shipping_method_0_free_shipping2");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By offCart5 = By.className("coupon-offcart5");
    private final By off25 = By.className("coupon-off25");
    @Test
    public void validateFreeShipping() throws InterruptedException {
        CartPage cartPage = new StorePage(getWebDriver())
                .load()
                .getProductThumbnail()
                .clickAddToCartButton("Blue Shoes")
                .clickViewCart();

        getWebDriver().findElement(couponInput).sendKeys("freeship");
        getWebDriver().findElement(By.name("apply_coupon")).click();
        Thread.sleep(5000);
        cartPage.waitForOverlaysToDisappear(this.overlay);
        Assert.assertTrue(getWebDriver().findElement(couponRadioBtn).isSelected());

    }

    @Test
    public void validateOffCart5() throws InterruptedException {
        CartPage cartPage = new StorePage(getWebDriver())
                .load()
                .getProductThumbnail()
                .clickAddToCartButton("Blue Shoes")
                .clickViewCart();

        getWebDriver().findElement(couponInput).sendKeys("offcart5");
        getWebDriver().findElement(By.name("apply_coupon")).click();
        Thread.sleep(5000);
        cartPage.waitForOverlaysToDisappear(this.overlay);
        Assert.assertEquals(getWebDriver().findElement(offCart5).getText(), "Coupon: offcart5 -$5.00 [Remove]");
    }

    @Test
    public void validateOff25() throws InterruptedException {
        CartPage cartPage = new StorePage(getWebDriver())
                .load()
                .getProductThumbnail()
                .clickAddToCartButton("Blue Shoes")
                .clickViewCart();

        getWebDriver().findElement(couponInput).sendKeys("off25");
        getWebDriver().findElement(By.name("apply_coupon")).click();
        Thread.sleep(5000);
        cartPage.waitForOverlaysToDisappear(this.overlay);
        Assert.assertEquals(getWebDriver().findElement(off25).getText().substring(0, 13), "Coupon: off25");
    }
}
