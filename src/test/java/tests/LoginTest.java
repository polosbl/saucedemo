package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Incorrect credentials")
    public Object[][] incorrectCredentialsAndErrorMessages() {
        return new Object[][]{
                {"", "",EMPTY_FIELDS_ERROR_TEXT},
                {"1", "",EMPTY_PASSWORD_FIELD_ERROR_TEXT},
                {"1", "1",INCORRECT_DATA_IN_FIELDS_ERROR_TEXT}
        };
    }
//
    @Test
    public void login() {
        loginSteps.login(SAUCE_DEMO_BASE_URL,STANDARD_USER,STANDARD_USER_PASSWORD);
        Assert.assertEquals(productsPage.getCurrentUrl(),SAUCE_DEMO_PRODUCTS_URL);
    }

//    @Test
//    public void login() {
//        loginSteps.login(SAUCE_DEMO_BASE_URL,System.getenv("username"),System.getenv("secret_sauce"));
//        Assert.assertEquals(productsPage.getCurrentUrl(),SAUCE_DEMO_PRODUCTS_URL);
//    }

    @Test(dataProvider = "Incorrect credentials")
    public void loginWithIncorrectCredentials(String username,String password,String errorMessage) {
        loginSteps
                .loginWithError(SAUCE_DEMO_BASE_URL,username,password);
        Assert.assertEquals(loginSteps.getErrorMessageText(), errorMessage);
    }

    @Test
    public void closeErrorMessageTest() {
        loginSteps
                .loginWithErrorAndCloseErrorMessage(SAUCE_DEMO_BASE_URL);
        Assert.assertFalse(loginSteps.isErrorMessagePresent());
    }
}
