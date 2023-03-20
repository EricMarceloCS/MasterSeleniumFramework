package dev.ericmarcelo.selenium.pom.base;

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

    public void load(String endPoint){
        webDriver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
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
