package pages;

import elements.Button;
import elements.InputField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageElementsPageObject {
    private InputField userName;
    private InputField password;
    private Button submit;

    public PageElementsPageObject(WebDriver driver){
        userName = new InputField(driver, By.id("username"));
        password = new InputField(driver, By.id("password"));
        submit = new Button(driver, By.cssSelector("button[type='submit']"));
    }

    public void logIn(String user, String pass){
        userName.setText(user);
        password.setText(pass);
        submit.click();
    }
}
