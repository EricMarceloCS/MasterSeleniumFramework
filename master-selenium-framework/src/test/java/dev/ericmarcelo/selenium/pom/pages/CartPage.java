package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.cssSelector(".checkout-button.button.alt.wc-forward");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductName() {
        return webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(productName))
                .getText();
    }

    public CheckoutPage checkout(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new CheckoutPage(webDriver);
    }
}
