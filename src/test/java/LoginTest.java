import helpers.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.saveScreenshot;

public class LoginTest {
    private final static String BASE_URL = "http://the-internet.herokuapp.com/";
    private final String USER_NAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";

    @BeforeMethod
    public void setUp(){
        getDriver().navigate().to(BASE_URL);
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }

    @AfterMethod
    public void tearDown(){
        DriverSingleton.quit();
    }

    @Test
    public void staticLoginTest(){
        StaticLoginPage.login(USER_NAME, PASSWORD);
        saveScreenshot("screen.bmp");
        Assert.assertTrue(getDriver().findElement(StaticHomePage.FLASH).isDisplayed());
    }
}
