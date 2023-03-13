package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeMethod
    public void startDriver() {
        this.webDriver = new DriverManager().initializeDriver();

    }

    @AfterMethod
    public void quitDriver(){
        webDriver.quit();
    }
}
