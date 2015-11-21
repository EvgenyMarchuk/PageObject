package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;

public class FramesPage {
    public static final By BODY_FRAME = get("frame.body");
    public static final By CONTENT_FRAME = get("frame.content");
    public static final By NESTED_FRAME = get("frame.nestedFrame");
    public static final By I_FRAME = get("frame.iFrame");

    public static void switchToFrame(WebDriver driver, String frame) {
        driver
                .switchTo().defaultContent()
                .switchTo().frame(frame);
    }

    public static void switchToParenFrame(WebDriver driver, String parentFrame, String frame) {
        driver
                .switchTo().defaultContent()
                .switchTo().frame(parentFrame)
                .switchTo().frame(frame);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
}
