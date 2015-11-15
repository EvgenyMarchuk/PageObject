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
    public void goToUrl(){
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }

    @Test
    public void restorePasswordTest() {
        ForgotPasswordPage.restore(EMAIL);
        Assert.assertEquals(getDriver().findElement(ForgotPasswordPage.CONTENT_FIELD).getText(), CONTENT_MSG);
        ForgotPasswordPage.checkMail(ALIAS_EMAIL[0]);
    }
}
