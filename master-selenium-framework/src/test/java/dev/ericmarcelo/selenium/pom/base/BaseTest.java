package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    private ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    protected WebDriver getWebDriver() {
        WebDriver webDriver = threadLocal.get();
        return webDriver;
    }

    private void setWebDriver(WebDriver webDriver) {
        threadLocal.set(webDriver);
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser) {
       setWebDriver(new DriverManager().initializeDriver(browser));
       System.out.println("Starting Thread: " + Thread.currentThread().getId());

    }

    @AfterMethod
    public void quitDriver(){
        WebDriver webDriver = getWebDriver();
        webDriver.quit();
    }
}
