package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

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
