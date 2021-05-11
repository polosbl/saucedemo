package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed("Sauce Labs Onesie"));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addItemToCart("Sauce Labs Onesie");
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed("Sauce Labs Onesie"));
    }

    @Test
    public void checkItemPriceTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        Assert.assertEquals(productsPage.getItemPrice("Sauce Labs Onesie"),"$7.99");
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addItemToCart("Sauce Labs Onesie");
        productsPage.removeItemFromCart("Sauce Labs Onesie");
        cartPage.openPage();
        Assert.assertTrue(!cartPage.isElementPresent("Sauce Labs Onesie"));
    }
}
