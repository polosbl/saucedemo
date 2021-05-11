package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{


    @Test
    public void addProductToCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addItemToCart("Sauce Labs Onesie");
        cartPage.openPage();
        Assert.assertTrue(cartPage.isElementPresent("Sauce Labs Onesie"));
    }

    @Test
    public void checkProductPriceTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addItemToCart("Sauce Labs Onesie");
        String productPrice = productsPage.getItemPrice("Sauce Labs Onesie");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"),productPrice);
    }

    @Test
    public void checkQuantityTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addItemToCart("Sauce Labs Onesie");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductQuantity("Sauce Labs Onesie"),"1");
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addItemToCart("Sauce Labs Onesie");
        cartPage.openPage();
        cartPage.removeItemFromCart("Sauce Labs Onesie");
        Assert.assertTrue(!cartPage.isElementPresent("Sauce Labs Onesie"));
    }
}
