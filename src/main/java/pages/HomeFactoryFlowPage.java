package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFactoryFlowPage {
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

    public LogInFactoryFlowPage logOut(WebDriver driver){
        logoutButton.click();
        return PageFactory.initElements(driver, LogInFactoryFlowPage.class);
    }
}
