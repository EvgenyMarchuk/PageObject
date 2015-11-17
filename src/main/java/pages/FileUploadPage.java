package pages;

import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.executeScriptCmd;
import static helpers.Locators.get;

public class FileUploadPage {

    private static final String CMD_PROGRAM = "./src/main/resources/upload.exe";
    private static File FILE_UPLOAD = new File("./src/main/resources/test.txt");
    public static final By VIEW_BUTTON = get("upload.viewButton");
    public static final By UPLOAD_BUTTON = get("upload.uploadButton");
    public static final By UPLOAD_FILES_FIELD = get("upload.uploadFiles");

    public static void uploadFile() throws IOException, InterruptedException {
        getDriver().findElement(VIEW_BUTTON).click();
        executeScriptCmd(CMD_PROGRAM, FILE_UPLOAD);
        Thread.sleep(500);
        getDriver().findElement(UPLOAD_BUTTON).click();
    }
}
