package dev.ericmarcelo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class MyFirstTestCase {

    @Test
    public void dummyTest() {

        System.setProperty("webdriver.chrome.driver", "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "drivers"
                + File.separator
                + "chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/main/resources/extensions/SelectorsHub.crx"));
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://askomdch.com/");
        // webDriver.get("https://www.saucedemo.com/");
        // webDriver.get("https://demoqa.com/");
        webDriver.quit();
    }

    @Test
    public void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "drivers"
                + File.separator
                + "chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/main/resources/extensions/SelectorsHub.crx"));
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://askomdch.com/");
        webDriver.manage().window().maximize();

        webDriver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        webDriver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        webDriver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
                webDriver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”"
        );

        webDriver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Blue Shoes"
        );

        webDriver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        webDriver.findElement(By.id("billing_first_name")).sendKeys("demo");
        webDriver.findElement(By.id("billing_last_name")).sendKeys("user");
        webDriver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        webDriver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        webDriver.findElement(By.id("billing_postcode")).sendKeys("94188");
        webDriver.findElement(By.id("billing_email")).sendKeys("askomdch@gmail.com");
        webDriver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(webDriver.findElement(
                By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."
        );

        webDriver.quit();

    }
    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "drivers"
                + File.separator
                + "chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File("src/main/resources/extensions/SelectorsHub.crx"));
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("https://askomdch.com/");
        webDriver.manage().window().maximize();

        webDriver.findElement(By.cssSelector("#menu-item-1227 > a")).click();
        webDriver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        webDriver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
                webDriver.findElement(By.cssSelector(".woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”"
        );

        webDriver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("a[title='View cart']")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Blue Shoes"
        );

        webDriver.findElement(By.cssSelector(".checkout-button.button.alt.wc-forward")).click();
        webDriver.findElement(By.className("showlogin")).click();
        Thread.sleep(3000);

        webDriver.findElement(By.id("username")).sendKeys("demouser2");
        webDriver.findElement(By.id("password")).sendKeys("demopwd");
        webDriver.findElement(By.name("login")).click();

        webDriver.findElement(By.id("billing_first_name")).clear();
        webDriver.findElement(By.id("billing_last_name")).clear();
        webDriver.findElement(By.id("billing_address_1")).clear();
        webDriver.findElement(By.id("billing_city")).clear();
        webDriver.findElement(By.id("billing_postcode")).clear();
        webDriver.findElement(By.id("billing_email")).clear();

        webDriver.findElement(By.id("billing_first_name")).sendKeys("demo");
        webDriver.findElement(By.id("billing_last_name")).sendKeys("user");
        webDriver.findElement(By.id("billing_address_1")).sendKeys("San Francisco");
        webDriver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        webDriver.findElement(By.id("billing_postcode")).sendKeys("94188");

        webDriver.findElement(By.id("billing_email")).sendKeys("askomdch@gmail.com");
        Thread.sleep(5000);
        webDriver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assert.assertEquals(webDriver.findElement(
                        By.cssSelector(".woocommerce-notice")).getText(),
                "Thank you. Your order has been received."
        );

        webDriver.quit();

    }
}
