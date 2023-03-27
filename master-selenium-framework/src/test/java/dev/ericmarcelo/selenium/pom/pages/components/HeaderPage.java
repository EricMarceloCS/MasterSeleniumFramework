package dev.ericmarcelo.selenium.pom.pages.components;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import dev.ericmarcelo.selenium.pom.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public HeaderPage(WebDriver webDriver) {
        super(webDriver);
    }

    public StorePage navigateToStoreUsingMenu(){
        webDriver.findElement(storeMenuLink).click();
        return new StorePage(webDriver);
    }
}
