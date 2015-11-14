package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElemenPage {
    private final WebDriver driver;

    private By userName = By.id("username");
    private By password = By.id("password");
    private By login = By.cssSelector("button[type='submit']");

    private WebElement userNameField;
    private WebElement passwordField;
    private WebElement logInButton;

    public WebElemenPage(WebDriver driver) {
        this.driver = driver;
        userNameField = driver.findElement(userName);
        passwordField = driver.findElement(password);
        logInButton = driver.findElement(login);
    }

    public void logIn(String user, String password){
        userNameField.sendKeys(user);
        passwordField.sendKeys(password);
        logInButton.click();
    }
}
