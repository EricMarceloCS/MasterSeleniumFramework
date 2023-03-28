package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.constants.DriverType;
import dev.ericmarcelo.selenium.pom.factory.DriverManagerFactory;
import dev.ericmarcelo.selenium.pom.utils.CookieUtils;
import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.List;

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
    public synchronized void startDriver(String browser) {
       setWebDriver(DriverManagerFactory.getManager(DriverType.FIREFOX).createDriver());
       System.out.println("STARTING THREAD: " + Thread.currentThread().getId());

    }

    @AfterMethod
    public synchronized void quitDriver(){
        getWebDriver().quit();
    }

    public void injectCookiesToBrowser(Cookies cookies) {
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie : seleniumCookies) {
            getWebDriver().manage().addCookie(cookie);
            System.err.println("***********COOKIE : " + cookie);
        }
    }
}
