package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {


    private final By productTitle = By.cssSelector(".product_title");
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

}
