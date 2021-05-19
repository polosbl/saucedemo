package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertTrue(cartPage.isItemElementPresent(SAUCE_LABS_ONESIE));
    }

    @Test
    public void checkProductPriceTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE);
        String productPrice = productsPage.getItemPrice(SAUCE_LABS_ONESIE);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_ONESIE), productPrice);
    }

    @Test
    public void checkQuantityTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertEquals(cartPage.getProductQuantity(SAUCE_LABS_ONESIE), "1");
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL)
                .removeItemFromCart(SAUCE_LABS_ONESIE);
        Assert.assertFalse(cartPage.isItemElementPresent(SAUCE_LABS_ONESIE));
    }

    @Test
    public void removeItemFromCartTestChain() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL)
                .removeItemFromCart(SAUCE_LABS_ONESIE);
        Assert.assertFalse(cartPage.isItemElementPresent(SAUCE_LABS_ONESIE));
    }
}
