package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @DataProvider(name = "Items")
    public Object[] items() {
        return new Object[]{
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        };
    }

    @Test(dataProvider = "Items")
    public void addProductToCartTest(String item) {
        productSteps
                .loginAndAddProductToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertTrue(cartPage.isItemElementPresent(item));
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void checkProductPriceTest(String item) {
        productSteps
                .loginAndAddProductToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        String productPrice = productsPage.getItemPrice(item);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertEquals(cartPage.getProductPrice(item), productPrice);
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void checkQuantityTest(String item) {
        productSteps
                .loginAndAddProductToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertEquals(cartPage.getProductQuantity(item), "1");
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void removeItemFromCartTest(String item) {
        productSteps
                .loginAndAddProductToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL)
                .removeItemFromCart(item);
        Assert.assertFalse(cartPage.isItemElementPresent(item));
    }

    @Test(dataProvider = "Items", retryAnalyzer = Retry.class)
    public void removeItemFromCartTestChain(String item) {
        productSteps
                .loginAndAddProductToCart(SAUCE_DEMO_BASE_URL, STANDARD_USER, STANDARD_USER_PASSWORD, item);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL)
                .removeItemFromCart(item);
        Assert.assertFalse(cartPage.isItemElementPresent(item));
    }
}
