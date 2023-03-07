package dev.ericmarcelo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyFirstTestCase {

    @Test
    public void dummyTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://askomdch.com/");
        // webDriver.get("https://www.saucedemo.com/");
        // webDriver.get("https://demoqa.com/");
    }
}
