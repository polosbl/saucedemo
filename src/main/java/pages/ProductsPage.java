package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class ProductsPage extends HeaderPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='inventory_item']";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";

    @Step("Adding {itemName} to cart")
    public ProductsPage addItemToCart(String itemName) {
        log.info(String.format("Adding '%s' to cart by clicking on Add button. ",itemName)
                + "Locator: " + ADD_PRODUCT_TO_CART_BUTTON);
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, itemName))).click();
        return this;
    }

    public boolean isRemoveButtonDisplayed(String itemName) {
        log.info(String.format("Checking is Remove button displayed near '%s'. ",itemName)
                + "Locator: " + REMOVE_PRODUCT_FROM_CART_BUTTON);
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,itemName))).isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed(String itemName) {
        log.info(String.format("Checking is Add button displayed near '%s'. ",itemName)
                + "Locator: " + ADD_PRODUCT_TO_CART_BUTTON);
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON,itemName))).isDisplayed();
    }

    public String getItemPrice(String itemName) {
        log.info(String.format("Getting price of '%s'. ", itemName) + "Locator: " + PRODUCT_PRICE);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, itemName))).getText();
    }

    public ProductsPage removeItemFromCart(String itemName) {
        log.info(String.format("Removing '%s' from cart by clicking Remove button. ", itemName)
                + "Locator: " + REMOVE_PRODUCT_FROM_CART_BUTTON);
        driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON,itemName))).click();
        return this;
    }
}
