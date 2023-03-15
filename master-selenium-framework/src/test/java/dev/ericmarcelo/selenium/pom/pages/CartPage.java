package dev.ericmarcelo.selenium.pom.pages;

import dev.ericmarcelo.selenium.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    /*
    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.cssSelector(".checkout-button.button.alt.wc-forward");
    */
    @FindBy(css = "td[class='product-name'] a")
    private WebElement productName;
    @FindBy(how = How.CSS, using = ".checkout-button.button.alt.wc-forward")
    @CacheLookup
    private WebElement checkoutButton;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public String getProductName() {
        return webDriverWait
                .until(ExpectedConditions.visibilityOf(productName))
                .getText();
    }

    public CheckoutPage checkout(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        return new CheckoutPage(webDriver);
    }
}
