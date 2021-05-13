package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By ERROR_MESSAGE = By.xpath("//*[contains(@class,'error-message-container') " +
            "and contains(@class,'error')]");
    private static final By CLOSE_ERROR_MESSAGE_BUTTON = By.xpath("//*[@data-test='error']//button");
    private static final By BOT_LOGO = By.xpath("//*[@class='bot_column']");

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean isErrorMessagePresent() {
        try {
            driver.findElement(ERROR_MESSAGE);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void closeErrorMessage(){
        driver.findElement(CLOSE_ERROR_MESSAGE_BUTTON).click();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BOT_LOGO));
    }
}
