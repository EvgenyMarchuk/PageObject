import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.saveScreenshot;

public class LoginTest extends TestBase{
    private final String USER_NAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";

    @BeforeMethod
    public void goToUrl(){
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }

    @Test
    public void staticLoginTest(){
        StaticLoginPage.login(USER_NAME, PASSWORD);
        saveScreenshot("screen.bmp");
        Assert.assertTrue(getDriver().findElement(StaticHomePage.FLASH).isDisplayed());
    }
}
