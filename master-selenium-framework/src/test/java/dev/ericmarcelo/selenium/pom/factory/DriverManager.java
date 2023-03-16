package dev.ericmarcelo.selenium.pom.factory;

import dev.ericmarcelo.selenium.pom.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class DriverManager {

    public WebDriver initializeDriver(String browser) {

        WebDriver webDriver;

        switch(DriverType.valueOf(browser)) {
            case FIREFOX -> {
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

                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                break;
            }
            default -> {
                throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }

        return webDriver;
    }
}
