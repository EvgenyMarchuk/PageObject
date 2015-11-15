import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import static helpers.DriverSingleton.getDriver;

public class FormAuthenticationTest extends TestBase{
    private final String USER_NAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }

    @Test
    public void staticLoginTest(){
        StaticLoginPage.login(USER_NAME, PASSWORD);
        Assert.assertTrue(getDriver().findElement(StaticLoginPage.FLASH_HEADER).isDisplayed());
        Assert.assertTrue(getDriver().findElement(StaticLoginPage.LOGOUT_BUTTON).isDisplayed());
    }

    @Test
    public void staticLogoutTest(){
        StaticLoginPage.login(USER_NAME, PASSWORD);
        StaticLoginPage.logout();
        Assert.assertTrue(getDriver().findElement(StaticLoginPage.USER_NAME_FIELD).isDisplayed());
        Assert.assertTrue(getDriver().findElement(StaticLoginPage.PASSWORD_FIELD).isDisplayed());
        Assert.assertTrue(getDriver().findElement(StaticLoginPage.LOGIN_BUTTON).isDisplayed());
    }
}
