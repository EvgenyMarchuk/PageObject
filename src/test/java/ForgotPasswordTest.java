import helpers.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ForgotPasswordPage;

import static helpers.DriverSingleton.getDriver;

public class ForgotPasswordTest {

    private final static String BASE_URL = "http://the-internet.herokuapp.com/";
    private static final String EMAIL = "qguwlyqq@sharklasers.com";
    private static final String[] ALIAS_EMAIL = EMAIL.split("@");

    private static final String CONTENT_MSG = "Your e-mail's been sent!";

    @BeforeMethod
    public void setUp(){
        getDriver().navigate().to(BASE_URL);
        getDriver().findElement(By.linkText("Forgot Password")).click();
    }

    @AfterMethod
    public void tearDown(){
        DriverSingleton.quit();
    }

    @Test
    public void restorePasswordTest() throws InterruptedException {
        ForgotPasswordPage.restore(EMAIL);
        Assert.assertEquals(getDriver().findElement(ForgotPasswordPage.CONTENT_FIELD).getText(), CONTENT_MSG);
        ForgotPasswordPage.checkMail(ALIAS_EMAIL[0]);
    }
}
