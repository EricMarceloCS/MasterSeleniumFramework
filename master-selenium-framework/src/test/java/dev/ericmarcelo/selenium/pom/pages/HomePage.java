package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    private final By linkText = By.cssSelector(".ast-loop-product__link");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public StorePage navigateToStoreUsingMenu(){
        webDriver.findElement(storeMenuLink).click();
        return new StorePage(webDriver);
    }

    public HomePage load(){
        load("/");
        webDriverWait.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }

    public ProductPage navigateFromHomeToFeaturedProductPage() {
        webDriver.navigate().to("https://askomdch.com/product/blue-shoes/");
        return new ProductPage(webDriver);
    }
}
