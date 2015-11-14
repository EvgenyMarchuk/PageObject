package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

public class UIMapLoginPage {
    private final WebDriver driver;

    public final static By USER_NAME_FIELD = get("login.userNameField");
    public final static By PASSWORD_FIELD = get("login.passwordField");
    public final static By LOGIN_BUTTON = get("login.loginButton");

    public UIMapLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass){
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(pass);
        driver.findElement(LOGIN_BUTTON).click();
    }

}
