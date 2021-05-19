package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement usernameInput;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[contains(@class,'error-message-container') and contains(@class,'error')]")
    public WebElement errorMessage;

    @FindBys({
            @FindBy(xpath = "//*[contains(@class,'error-message-container') and contains(@class,'error')]")
    })
    public List<WebElement> errorMessages;

    @FindBy(xpath = "//*[@data-test='error']//button")
    public WebElement closeErrorMessageButton;

    @FindBy(xpath = "//*[@class='bot_column']")
    public WebElement botLogo;

    public ProductsPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean isErrorMessagePresent() {
        return errorMessages.isEmpty();
    }

    public void closeErrorMessage() {
        closeErrorMessageButton.click();
    }

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage waitForPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(botLogo));
        return this;
    }
}
