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
    @Test(dataProvider = "Incorrect credentials")
    public void loginWithIncorrectCredentials(String username,String password,String errorMessage) {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login(username, password);
        Assert.assertEquals(loginPage.getErrorMessageText(), errorMessage);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login("1", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_PASSWORD_FIELD_ERROR_TEXT);
    }

    @Test
    public void loginAsIncorrectUserTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .login("1", "1");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }

    @Test
    public void closeErrorMessageTest() {
        loginPage
                .openPage(SAUCE_DEMO_BASE_URL)
                .waitForPageOpened()
                .loginWithError("1", "1")
                .closeErrorMessage();
        Assert.assertFalse(loginPage.isErrorMessagePresent());
    }
}
