package pages;

import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;

import static helpers.DriverSingleton.getDriver;
import static helpers.Locators.get;

public class FileUploadPage {

    private static final String CMD_PROGRAM = "./src/main/resources/ff_upload.exe";
    private static File file = new File("./src/main/resources/test.txt");
    private static final String FILE_UPLOAD = file.getAbsolutePath();
    public static final By VIEW_BUTTON = get("upload.viewButton");
    public static final By UPLOAD_BUTTON = get("upload.uploadButton");
    public static final By UPLOAD_FILES_FIELD = get("upload.uploadFiles");

    public static void uploadFile() throws IOException, InterruptedException {
        getDriver().findElement(VIEW_BUTTON).click();
        executeScriptCmd(CMD_PROGRAM, FILE_UPLOAD);
        Thread.sleep(500);
        getDriver().findElement(UPLOAD_BUTTON).click();
    }

    private static void executeScriptCmd(String cmdProgram, String fileUpload) throws IOException {
        Runtime.getRuntime().exec(new String[] {cmdProgram, fileUpload});
    }
}
