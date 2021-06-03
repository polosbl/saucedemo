package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";

    @Step("Opening cart page")
    public CartPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public String getProductQuantity(String productQuantity) {
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY,productQuantity))).getText();
    }

    public CartPage removeItemFromCart(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON,productName))).click();
        return this;
    }

    @Step("Checking is {productName} present in cart")
    public boolean isItemElementPresent(String productName) {
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, productName))).isEmpty();
    }
}
