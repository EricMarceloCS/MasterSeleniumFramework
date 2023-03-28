package dev.ericmarcelo.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class FirefoxDriverManager implements DriverManager {

    @Override
    public WebDriver createDriver() {
        WebDriverManager
                .firefoxdriver()
                .cachePath("src"
                        + File.separator
                        + "test"
                        + File.separator
                        + "resources"
                        + File.separator
                        + "drivers")
                .setup();

        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        return webDriver;

    }
}
