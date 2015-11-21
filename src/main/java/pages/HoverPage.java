package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static helpers.Locators.get;

public class HoverPage {
    public static final By HOVER_FIGERES = get("hover.figure");

    public static void hoverFigure(Actions actions, WebElement element) {
        actions.moveToElement(element).perform();
    }
}
