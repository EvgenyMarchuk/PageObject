import helpers.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AlertsPage;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.isAlertPresent;

public class AlertsTest extends TestBase{

    private static final String ALERT_PRESENT_ERROR = "Alert is present";
    private static final String ALERT_TEXT = "I am a JS Alert";
    private static final String ALERT_RESULT_TEXT = "You successfuly clicked an alert";
    private static final String CONFIRM_TEXT = "I am a JS Confirm";
    private static final String CONFIRM_CANCEL_RESULT_TEXT = "You clicked: Cancel";
    private static final String PROMPT_TEXT = "I am a JS prompt";

    private String alertText = "";

    private Alert alert;

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("JavaScript Alerts")).click();
    }

    @Test
    public void jsAlertsTest(){
        AlertsPage.jsAlert();
        alert = getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.accept();
        Assert.assertEquals(alertText, ALERT_TEXT);
        Assert.assertFalse(isAlertPresent(getDriver()), ALERT_PRESENT_ERROR);
        Assert.assertEquals(getDriver().findElement(AlertsPage.RESULT_TEXT).getText(), ALERT_RESULT_TEXT);
    }

    @Test
    public void jsConfirmTest(){
        AlertsPage.jsConfirm();
        alert = getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.dismiss();
        Assert.assertEquals(alertText, CONFIRM_TEXT);
        Assert.assertFalse(isAlertPresent(getDriver()), ALERT_PRESENT_ERROR);
        Assert.assertEquals(getDriver().findElement(AlertsPage.RESULT_TEXT).getText(), CONFIRM_CANCEL_RESULT_TEXT);
    }

    @Test
    public void jsPromptTest(){
        AlertsPage.jsPrompt();
        alert = getDriver().switchTo().alert();
        alertText = alert.getText();
        alert.sendKeys(AlertsPage.PROMPT_RESULT_TEXT);
        alert.accept();
        Assert.assertEquals(alertText, PROMPT_TEXT);
        Assert.assertFalse(isAlertPresent(getDriver()), ALERT_PRESENT_ERROR);
        Assert.assertEquals(getDriver().findElement(AlertsPage.RESULT_TEXT).getText(),
                "You entered: " + AlertsPage.PROMPT_RESULT_TEXT);
    }
}
