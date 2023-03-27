package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import dev.ericmarcelo.selenium.pom.constants.Endpoints;
import dev.ericmarcelo.selenium.pom.pages.components.HeaderPage;
import dev.ericmarcelo.selenium.pom.pages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By productNotFound = By.cssSelector(".woocommerce-no-products-found");
    private HeaderPage headerPage;
    private ProductThumbnail productThumbnail;
    public StorePage(WebDriver webDriver) {
        super(webDriver);
        headerPage = new HeaderPage(webDriver);
        productThumbnail = new ProductThumbnail(webDriver);
    }

    public StorePage load(){
        load(Endpoints.STORE);
        return this;
    }

    private StorePage enterTextIntoSearchField(String text) {
        webDriver.findElement(searchField).sendKeys(text);
        return this;
    }

    private StorePage clickSearchButton() {
        webDriver.findElement(searchButton).click();
        return this;
    }

    public StorePage search(String text) {
        enterTextIntoSearchField(text).clickSearchButton();
        return this;
    }

    public ProductPage searchExact(String text) {
        enterTextIntoSearchField(text).clickSearchButton();
        return new ProductPage(webDriver);
    }
    public String getTitle() {
        return webDriver.findElement(title).getText();
    }

    public String getNoProduct() {

        return webDriver.findElement(productNotFound).getText();
    }

    public ProductPage navigateToProductPage() {
        webDriver.findElement(searchField).sendKeys("Blue Shoes");
        webDriver.findElement(searchButton).click();
        return new ProductPage(webDriver);
    }

    public HeaderPage getHeaderPage() {
        return headerPage;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }
}
