package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add {item} to cart")
    public ProductSteps loginAndAddProductToCart(String url, String username, String password, String item){
        loginPage
                .openPage(url)
                .waitForPageOpened()
                .login(username, password)
                .addItemToCart(item);
        return this;
    }
}
