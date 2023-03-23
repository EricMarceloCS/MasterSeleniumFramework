package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {


    private final By productTitle = By.cssSelector(".product_title");
    private final By addToCartButton = By.cssSelector(".single_add_to_cart_button");
    private final By message = By.cssSelector(".woocommerce-message");
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductPage load() {
        load("/product/blue-shoes");
        return this;
    }

    public String getTitle() {
        return webDriver.findElement(productTitle).getText();
    }

    public ProductPage clickAddToCartButton() {
        webDriver.findElement(addToCartButton).click();
        return this;
    }

    public List<WebElement> getMessage() {
        return webDriver.findElements(message);
    }

}
