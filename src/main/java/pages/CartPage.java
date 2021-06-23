package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends HeaderPage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class='cart_item']";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class='inventory_item_price']";
    private static final String PRODUCT_QUANTITY = PRODUCT_ITEM + "//*[@class='cart_quantity']";
    private static final String REMOVE_BUTTON = PRODUCT_ITEM + "//button";

    public CartPage openPage(String url) {
        log.info("Opening Login page, URL: " + url);
        driver.get(url);
        return this;
    }

    public String getItemPrice(String itemName) {
        log.debug(String.format("Getting price of '%s' from cart. Locator: '%s'", itemName, PRODUCT_PRICE));
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, itemName))).getText();
    }

    public String getItemQuantity(String itemQuantity) {
        log.debug(String.format("Getting quantity of '%s'. Locator: '%s'", itemQuantity, PRODUCT_QUANTITY));
        return driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY,itemQuantity))).getText();
    }

    @Step("Removing {itemName} from cart")
    public CartPage removeItemFromCart(String itemName) {
        log.info(String.format("Removing '%s' from cart by clicking on remove button. Locator: ", itemName, REMOVE_BUTTON));
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON,itemName))).click();
        return this;
    }

    public boolean isItemElementPresent(String itemName) {
        log.info(String.format("Checking is '%s' present in cart.", itemName));
        return !driver.findElements(By.xpath(String.format(PRODUCT_ITEM, itemName))).isEmpty();
    }
}
