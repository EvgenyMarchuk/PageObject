package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginFactoryPage {
    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginButton;

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void logIn(String user, String pass){
        userName.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }

}
