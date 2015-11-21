package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static helpers.DriverSingleton.getDriver;
import static helpers.Locators.get;
import static helpers.Waiter.*;

public class ForgotPasswordPage {

    private static final String MAIL_SERVICES = "https://www.guerrillamail.com";
    private static final String SENDER_MAIL = "no-reply@the-internet.herokuapp.com";
    private static final String HEADER_EMAIL_MSG = "Forgot Password from the-internet";

    public static final By EMAIL_FIELD = get("forgot.emailField");
    public static final By RETRIEVE_PASSWORD_BUTTON = get("forgot.retrievePasswordButton");
    public static final By CONTENT_FIELD = get("forgot.contentField");
    public static final By INBOX_BUTTON = get("guerrilla.inboxButton");
    public static final By ALIAS_BUTTON = get("guerrilla.aliasField");
    public static final By SAVE_BUTTON = get("guerrilla.saveButton");
    public static final By LETTER = get("guerrilla.letter");
    public static final By EMAIL_SUBJECT = get("guerrilla.emailSubject");

    public static void restore(String email) {
        getDriver().findElement(EMAIL_FIELD).sendKeys(email);
        getDriver().findElement(RETRIEVE_PASSWORD_BUTTON).click();
    }

    public static void checkMail(String alias){
        //WebDriver htmlDriver = new HtmlUnitDriver();//A lot of errors
        WebDriver htmlDriver = new ChromeDriver();//without errors
        htmlDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        htmlDriver.get(MAIL_SERVICES);
        htmlDriver.findElement(INBOX_BUTTON).click();
        htmlDriver.findElement(ALIAS_BUTTON).sendKeys(alias);
        htmlDriver.findElement(SAVE_BUTTON).click();
        waitVisibilityOfElementLocated(htmlDriver, 10, LETTER);
        Assert.assertEquals(htmlDriver.findElement(LETTER).getText(), SENDER_MAIL);
        htmlDriver.findElement(LETTER).click();
        Assert.assertEquals(htmlDriver.findElement(EMAIL_SUBJECT).getText(),
                HEADER_EMAIL_MSG);
        htmlDriver.quit();
    }
}
