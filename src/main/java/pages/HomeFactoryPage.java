package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeFactoryPage {
    @FindBy(css = ".secondary.radius")
    WebElement logoutButton;

    @FindBy(css = "#flash.success")
    WebElement header;

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getHeader() {
        return header;
    }

    public void logOut(){
        logoutButton.click();
    }

}
