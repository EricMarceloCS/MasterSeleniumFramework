package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver webDriver;
    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser) {
        this.webDriver = new DriverManager().initializeDriver(browser);

    }

    @AfterMethod
    public void quitDriver(){
        webDriver.quit();
    }
}
