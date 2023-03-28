package dev.ericmarcelo.selenium.pom.base;

import dev.ericmarcelo.selenium.pom.constants.DriverType;
import dev.ericmarcelo.selenium.pom.factory.DriverManagerFactory;
import dev.ericmarcelo.selenium.pom.utils.CookieUtils;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {

    private final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    protected WebDriver getWebDriver() {
        return threadLocal.get();
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

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(@Optional String browser, ITestResult iTestResult){
        if(iTestResult.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("src" +
                    File.separator +
                    "test" +
                    File.separator +
                    "resources" +
                    File.separator +
                    "screenshots" +
                    File.separator +
                    browser +
                    File.separator +
                    iTestResult
                            .getTestClass()
                            .getRealClass()
                            .getSimpleName() +
                    "_" +
                    iTestResult
                            .getMethod()
                            .getMethodName() +
                    ".png"
            );
            takeScreenshot(destFile);
            takeScreenshotUsingAShot(destFile);
        }
        getWebDriver().quit();
    }

    private void takeScreenshot(File destFile) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getWebDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }

    }

    private void takeScreenshotUsingAShot(File destFile) {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(getWebDriver());

        try {
            ImageIO.write(screenshot.getImage(), "PNG", destFile);
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            ioException.printStackTrace();
        }
    }

    public void injectCookiesToBrowser(Cookies cookies) {
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie : seleniumCookies) {
            getWebDriver().manage().addCookie(cookie);
            System.err.println("***********COOKIE : " + cookie);
        }
    }
}
