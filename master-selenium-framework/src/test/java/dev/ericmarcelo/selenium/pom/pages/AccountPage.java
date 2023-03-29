package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import dev.ericmarcelo.selenium.pom.constants.Endpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By usernameLogin = By.id("username");
    private final By passwordLogin = By.id("password");
    private final By submitLogin = By.cssSelector(".woocommerce-form-login__submit");
    private final By errorNotice = By.cssSelector(".woocommerce-notices-wrapper");
    private final By orderMenuItem = By.className("woocommerce-MyAccount-navigation-link--orders");
    private final By viewBtn = By.className("woocommerce-button");
    private final By orderDetails = By.className("woocommerce-order-details__title");

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AccountPage load() {
        load(Endpoints.ACCOUNT);
        return this;
    }

    public AccountPage enterBadLogin() {
        webDriver.findElement(usernameLogin).sendKeys("username");
        webDriver.findElement(passwordLogin).sendKeys("login");
        webDriver.findElement(submitLogin).click();
        return this;
    }

    public String getErrorNotice() {
        return webDriver.findElement(errorNotice).getText();
    }

    public AccountPage selectOrders() {
        webDriver.findElement(orderMenuItem).click();
        return this;
    }

    public AccountPage clickOrderViewBtn() {
        webDriver.findElement(viewBtn).click();
        return this;
    }

    public String getAccountOrderDetails() {
        return webDriver.findElement(orderDetails).getText();
    }
}
