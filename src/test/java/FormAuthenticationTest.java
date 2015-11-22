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
        FormAuthenticationPage.login(USER_NAME, PASSWORD);
        Assert.assertTrue(getDriver().findElement(FormAuthenticationPage.FLASH_HEADER).isDisplayed());
        Assert.assertTrue(getDriver().findElement(FormAuthenticationPage.LOGOUT_BUTTON).isDisplayed());
    }

    @Test
    public void staticLogoutTest(){
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/login");
        FormAuthenticationPage.login(USER_NAME, PASSWORD);
        FormAuthenticationPage.logout();
        Assert.assertTrue(getDriver().findElement(FormAuthenticationPage.USER_NAME_FIELD).isDisplayed());
        Assert.assertTrue(getDriver().findElement(FormAuthenticationPage.PASSWORD_FIELD).isDisplayed());
        Assert.assertTrue(getDriver().findElement(FormAuthenticationPage.LOGIN_BUTTON).isDisplayed());
    }
}