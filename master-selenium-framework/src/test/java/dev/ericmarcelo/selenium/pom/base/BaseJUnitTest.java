package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.factory.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
public class BaseJUnitTest {

    protected WebDriver webDriver;
    @BeforeEach
    public void startDriver() {
      webDriver = new DriverManager().initializeDriver("FIREFOX");

    }

    @AfterEach
    public void quitDriver(){
        webDriver.quit();
    }
}
