package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ByPage {
    private final WebDriver driver;

    private final By userName = By.id("username");
    private final By password = By.id("password");
    private final By login = By.cssSelector("button[type='submit']");


    public ByPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logIn(String user, String pass){
        driver.findElement(userName).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();
    }
}
