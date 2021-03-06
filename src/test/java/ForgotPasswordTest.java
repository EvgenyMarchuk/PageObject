import helpers.DriverSingleton;
import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ForgotPasswordPage;

import static helpers.DriverSingleton.getDriver;

public class ForgotPasswordTest extends TestBase{

    private static final String EMAIL = "qguwlyqq@sharklasers.com";
    private static final String[] ALIAS_EMAIL = EMAIL.split("@");
    private static final String CONTENT_MSG = "Your e-mail's been sent!";

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Forgot Password")).click();
    }

    @Test
    public void restorePasswordTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/forgot_password");
        ForgotPasswordPage.restore(EMAIL);
        Assert.assertEquals(getDriver().findElement(ForgotPasswordPage.CONTENT_FIELD).getText(), CONTENT_MSG);
        ForgotPasswordPage.checkMail(ALIAS_EMAIL[0]);
    }
}
