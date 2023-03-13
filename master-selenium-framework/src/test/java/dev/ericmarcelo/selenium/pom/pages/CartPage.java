package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductName() {
        return webDriver.findElement(productName).getText();
    }

    public CheckoutPage checkout(){
        webDriver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        return new CheckoutPage(webDriver);
    }
}
