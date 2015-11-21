package pages;

import org.openqa.selenium.By;

import static helpers.DriverSingleton.getDriver;
import static helpers.Locators.get;

public class AlertsPage {
    public static final By JS_ALERT = get("alert.jsAlert");
    public static final By JS_CONFIRM = get("alert.jsConfirm");
    public static final By JS_PROMPT = get("alert.jsPrompt");
    public static final By RESULT_TEXT = get("alert.result");
    public static final String PROMPT_RESULT_TEXT = "Hello!!!";

    public static void jsAlert() {
        getDriver().findElement(JS_ALERT).click();
    }

    public static void jsConfirm() {
        getDriver().findElement(JS_CONFIRM).click();
    }

    public static void jsPrompt() {
        getDriver().findElement(JS_PROMPT).click();
    }
}
