package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

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
}
