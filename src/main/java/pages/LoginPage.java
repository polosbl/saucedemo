package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    public static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void openPage() {
        driver.get("https://www.saucedemo.com/");
    }

}
