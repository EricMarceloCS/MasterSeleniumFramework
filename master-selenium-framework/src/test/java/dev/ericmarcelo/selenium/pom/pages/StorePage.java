package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");
    public StorePage(WebDriver webDriver) {
        super(webDriver);
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
    public String getTitle() {
        return webDriver.findElement(title).getText();
    }

    private By getAddToCartBtnElement(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public StorePage clickAddToCartButton(String productName) {
        By addToCartBtnElement = getAddToCartBtnElement(productName);
        webDriver.findElement(addToCartBtnElement).click();
        return this;
    }

    public CartPage clickViewCart() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink)).click();
        return new CartPage(webDriver);
    }
}
