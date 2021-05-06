package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    //Loginpage.openPage()
    //loginPage.login(user,pass)
    //productsPage.addToCart("Item")
    //cartpage.openpage()
    //cartpage.getQuantity(Item)
    //cartpage.getPrice(Item)
    //Assertion

//    1 Quantity
//    2 Login
//    3 Remove


    @Test
    public void addProductToCartTest() {
        loginPage.openPage();
        loginPage.login("standard_user","secret_sauce");
        productsPage.addProductToCart("Sauce Labs Onesie");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"),"$7.99");
    }
}
