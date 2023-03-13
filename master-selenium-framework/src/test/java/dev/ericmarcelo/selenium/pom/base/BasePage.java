package dev.ericmarcelo.selenium.pom.base;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void load(String str){
        webDriver.get("https://askomdch.com" + str);
    }
}
