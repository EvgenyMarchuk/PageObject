package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;

public class BasicAuthPage {

    public static final By HEAD_PAGE_LABEL = get("auth.contentHeadPage");
    public static final By CONTENT_EXAMPLE_LABEL = get("auth.contentSuccessMsg");
}
