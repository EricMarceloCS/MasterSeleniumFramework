package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import dev.ericmarcelo.selenium.pom.constants.Endpoints;
import dev.ericmarcelo.selenium.pom.pages.components.HeaderPage;
import dev.ericmarcelo.selenium.pom.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By linkText = By.cssSelector(".ast-loop-product__link");
    private HeaderPage headerPage;
    private ProductThumbnail productThumbnail;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        headerPage = new HeaderPage(webDriver);
        productThumbnail = new ProductThumbnail(webDriver);
    }

    public HomePage load(){
        load(Endpoints.HOME);
        webDriverWait.until(ExpectedConditions.titleContains("AskOmDch"));
        return this;
    }

    public ProductPage navigateFromHomeToFeaturedProductPage() {
        webDriver.navigate().to("https://askomdch.com/product/blue-shoes/");
        return new ProductPage(webDriver);
    }

    public HeaderPage getHeaderPage() {
        return headerPage;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
}
