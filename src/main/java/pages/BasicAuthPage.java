package pages;

import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import static helpers.Helper.executeScriptCmd;
import static helpers.Locators.get;

public class BasicAuthPage {
    private static final String CMD_PROGRAM = "./src/main/resources/wab.exe";
    private static final String[] ACCOUNT_DATA = {"admin", "admin"};
    public static final By HEAD_PAGE_LABEL = get("auth.contentHeadPage");
    public static final By CONTENT_EXAMPLE_LABEL = get("auth.contentSuccessMsg");

    public static void authorization() throws IOException {
        executeScriptCmd(CMD_PROGRAM, ACCOUNT_DATA);
    }
}
