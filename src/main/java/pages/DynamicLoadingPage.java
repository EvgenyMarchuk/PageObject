package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;

public class DynamicLoadingPage {
    public static final By EXAMPLE_ONE = get("dynamic.example1");
    public static final By EXAMPLE_TWO = get("dynamic.example2");
    public static final By START_BUTTON = get("dynamic.startButton");
    public static final By FINISH_BLOCK = get("dynamic.finishBlock");
}
