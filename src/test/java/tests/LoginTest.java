package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    private static final String EMPTY_FIELDS_ERROR_TEXT  = "Epic sadface: Username is required";
    private static final String EMPTY_PASSWORD_FIELD_ERROR_TEXT  = "Epic sadface: Password is required";
    private static final String INCORRECT_DATA_IN_FIELDS_ERROR_TEXT  =
            "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void loginWithEmptyFieldsTest(){
        loginPage.openPage(SAUCE_DEMO_BASE_URL);
        loginPage.waitForPageOpened();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMessageText(),EMPTY_FIELDS_ERROR_TEXT);
    }

    @Test
    public void loginWithEmptyPasswordTest(){
        loginPage.openPage(SAUCE_DEMO_BASE_URL);
        loginPage.login("1","");
        Assert.assertEquals(loginPage.getErrorMessageText(),EMPTY_PASSWORD_FIELD_ERROR_TEXT);
    }

    @Test
    public void loginAsIncorrectUserTest(){
        loginPage.openPage(SAUCE_DEMO_BASE_URL);
        loginPage.login("1","1");
        Assert.assertEquals(loginPage.getErrorMessageText(),INCORRECT_DATA_IN_FIELDS_ERROR_TEXT);
    }

    @Test
    public void closeErrorMessageTest(){
        loginPage.openPage(SAUCE_DEMO_BASE_URL);
        loginPage.login("1","1");
        loginPage.closeErrorMessage();
        Assert.assertTrue(!loginPage.isErrorMessagePresent());
    }
}
