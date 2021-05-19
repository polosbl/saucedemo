package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_ONESIE));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_ONESIE));
    }

    @Test
    public void checkItemPriceTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD);
        Assert.assertEquals(productsPage.getItemPrice(SAUCE_LABS_ONESIE), "$7.99");
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(STANDARD_USER, STANDARD_USER_PASSWORD)
                .addItemToCart(SAUCE_LABS_ONESIE)
                .removeItemFromCart(SAUCE_LABS_ONESIE);
        cartPage
                .openPage(SAUCE_DEMO_CART_URL);
        Assert.assertFalse(cartPage.isItemElementPresent(SAUCE_LABS_ONESIE));
    }
}
