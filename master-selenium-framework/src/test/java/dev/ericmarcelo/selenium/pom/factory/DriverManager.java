package dev.ericmarcelo.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverManager {

    public WebDriver initializeDriver() {

        WebDriverManager
                .firefoxdriver()
                .cachePath("src"
                        + File.separator
                        + "test"
                        + File.separator
                        + "resources"
                        + File.separator
                        + "drivers"
                        + File.separator
                        + "geckodriver")
                .setup();

        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();

        return webDriver;
    }
}
