package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithEmptyFieldsTest(){
        loginPage.openPage();
        loginPage.login("","");
        Assert.assertEquals(loginPage.getErrorMessageText(),"Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyPasswordTest(){
        loginPage.openPage();
        loginPage.login("1","");
        Assert.assertEquals(loginPage.getErrorMessageText(),"Epic sadface: Password is required");
    }

    @Test
    public void loginAsIncorrectUserTest(){
        loginPage.openPage();
        loginPage.login("1","1");
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void closeErrorMessageTest(){
        loginPage.openPage();
        loginPage.login("1","1");
        loginPage.closeErrorMessage();
        Assert.assertTrue(!loginPage.isErrorMessagePresent());
    }
}
