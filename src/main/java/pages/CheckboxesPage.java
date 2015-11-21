package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.*;
import static helpers.Locators.get;

public class CheckboxesPage {

    public static final By CHECKBOXES = get("checkbox.elementCheckbox");

    public static void selectCheckBoxes(List<WebElement> elements) {
        check(elements.get(0));
        unCheck(elements.get(1));
    }
}
