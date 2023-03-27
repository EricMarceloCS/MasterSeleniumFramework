package dev.ericmarcelo.selenium.pom.pages.components;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import dev.ericmarcelo.selenium.pom.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductThumbnail extends BasePage {

    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public ProductThumbnail(WebDriver webDriver) {
        super(webDriver);
    }

    private By getAddToCartBtnElement(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public ProductThumbnail clickAddToCartButton(String productName) {
        By addToCartBtnElement = getAddToCartBtnElement(productName);
        webDriver.findElement(addToCartBtnElement).click();
        return this;
    }

    public CartPage clickViewCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink)).click();
        return new CartPage(webDriver);
    }
}
