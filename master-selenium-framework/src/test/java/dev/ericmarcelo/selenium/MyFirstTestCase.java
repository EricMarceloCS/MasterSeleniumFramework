package dev.ericmarcelo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class MyFirstTestCase {

    @Test
    public void dummyTest() {
        System.setProperty("webdriver.chrome.driver", "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "drivers"
                + File.separator
                + "chromedriver");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://askomdch.com/");
        // webDriver.get("https://www.saucedemo.com/");
        // webDriver.get("https://demoqa.com/");
    }
}
