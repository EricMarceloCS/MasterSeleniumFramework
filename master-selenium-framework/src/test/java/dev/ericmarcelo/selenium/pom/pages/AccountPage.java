package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private final By usernameLogin = By.id("username");
    private final By passwordLogin = By.id("password");
    private final By submitLogin = By.cssSelector(".woocommerce-form-login__submit");

    private final By errorNotice = By.cssSelector(".woocommerce-notices-wrapper");

    public AccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AccountPage load() {
        load("/account");
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

}
