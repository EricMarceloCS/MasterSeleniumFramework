package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.constants.Endpoints;
import dev.ericmarcelo.selenium.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void load(Endpoints endPoint){
        String file;
        switch(endPoint) {
            case ACCOUNT: file = "/account";
                break;
            case PRODUCT: file = "/product/blue-shoes";
                break;
            case HOME: file = "/";
                break;
            case CHECKOUT: file = "/checkout/";
                break;
            case STORE: file = "/store";
                break;
            case CART: file = "/?wc-ajax=add_to_cart";
                break;
            default:
                throw new RuntimeException("Invalid endpoint");
        }
        webDriver.get(ConfigLoader.getInstance().getBaseUrl() + "" +file);
    }

    public void waitForOverlaysToDisappear(By overlay) {
        List<WebElement> overlays = webDriver.findElements(overlay);
        if(overlays.size() > 0 ){
            webDriverWait
                    .until(ExpectedConditions.invisibilityOfAllElements(overlays));
        }
    }

    public WebElement waitForElementToBeVisible(By element){
        return webDriverWait
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
