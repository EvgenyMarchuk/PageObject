package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;

import static helpers.DriverSingleton.getDriver;

public class StaticLoginPage {
    public static final By USER_NAME_FIELD = get("login.userNameField");
    public static final By PASSWORD_FIELD = get("login.passwordField");
    public static final By LOGIN_BUTTON = get("login.loginButton");
    public static final By LOGOUT_BUTTON = get("login.logoutButton");
    public static final By FLASH_HEADER = get("login.flash");

    public static void login(String user, String pass){
        getDriver().findElement(USER_NAME_FIELD).sendKeys(user);
        getDriver().findElement(PASSWORD_FIELD).sendKeys(pass);
        getDriver().findElement(LOGIN_BUTTON).click();
    }

    public static void logout() {
        getDriver().findElement(LOGOUT_BUTTON).click();
    }
}
