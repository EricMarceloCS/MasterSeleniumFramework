package dev.ericmarcelo.selenium.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverManager {

    public WebDriver initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "drivers"
                + File.separator
                + "geckodriver");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
