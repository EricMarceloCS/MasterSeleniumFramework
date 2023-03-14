package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import dev.ericmarcelo.selenium.pom.objects.BillingAddress;
import dev.ericmarcelo.selenium.pom.objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By billingFirstName = By.id("billing_first_name");
    private final By billingLastName = By.id("billing_last_name");
    private final By billingAddress = By.id("billing_address_1");
    private final By billingCity = By.id("billing_city");

    private final By billingPostCode = By.id("billing_postcode");
    private final By billingEmail = By.id("billing_email");
    private final By placeOrder = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By showLogin = By.className("showlogin");
    private final By userName = By.id("username");
    private final By password = By.id("password");
    private final By login = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
       return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .enterAddress(billingAddress.getAddress())
                .enterCity(billingAddress.getCity())
                .enterPostCode(billingAddress.getPostalCode())
                .enterEmail(billingAddress.getEmail());

    }

    public CheckoutPage setUser(User user){
        enterUserName(user.getUserName())
                .enterPassword(user.getPassword());
        return this;
    }

    public CheckoutPage enterFirstName(String text) {
        WebElement webElement = waitForElementToBeVisible(billingFirstName);
        webElement.clear();
        webElement.sendKeys(text);

        return this;
    }

    public CheckoutPage enterLastName(String text) {
        WebElement webElement = waitForElementToBeVisible(billingLastName);
        webElement.clear();
        webElement.sendKeys(text);
        return this;
    }

    public CheckoutPage enterAddress(String text) {
        WebElement webElement = waitForElementToBeVisible(billingAddress);
        webElement.clear();
        webElement.sendKeys(text);
        return this;
    }
    public CheckoutPage enterCity(String text) {
        WebElement webElement = waitForElementToBeVisible(billingCity);
        webElement.clear();
        webElement.sendKeys(text);
        return this;
    }

    public CheckoutPage enterPostCode(String text) {
        WebElement webElement = waitForElementToBeVisible(billingPostCode);
        webElement.clear();
        webElement.sendKeys(text);
        return this;
    }

    public CheckoutPage enterEmail(String text) {
        WebElement webElement = waitForElementToBeVisible(billingEmail);
        webElement.clear();
        webElement.sendKeys(text);
        return this;
    }

    public CheckoutPage placeOrder(){
        waitForOverlaysToDisappear(this.overlay);
        webDriver.findElement(placeOrder).click();
        return this;
    }

    public String getNotice(){
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }

    public void enterLogin() {
        webDriver.findElement(showLogin).click();
    }

    public CheckoutPage enterUserName(String text){
        webDriver.findElement(userName).sendKeys(text);
        return this;
    }

    public CheckoutPage enterPassword(String text) {
        webDriver.findElement(password).sendKeys(text);
        return this;
    }

    public void login(){
        webDriver.findElement(login).click();
    }
}
