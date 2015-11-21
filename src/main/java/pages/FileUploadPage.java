package pages;

import org.openqa.selenium.By;

import static helpers.DriverSingleton.getDriver;
import static helpers.Locators.get;

public class FileUploadPage {

    public static final By VIEW_BUTTON = get("upload.viewButton");
    public static final By UPLOAD_BUTTON = get("upload.uploadButton");
    public static final By UPLOAD_FILES_FIELD = get("upload.uploadFiles");
    public static final By INPUT_FIELD = get("upload.inputField");
    public static final By SUCCESS_MSG_TEXT = get("upload.successMsg");

    public static void viewButtonClick(){
        getDriver().findElement(VIEW_BUTTON).click();
    }

    public static void uploadButtonClick() {
        getDriver().findElement(UPLOAD_BUTTON).click();
    }

    public static void uploadFileInput(String file) {
        getDriver().findElement(INPUT_FIELD).sendKeys(file);
        getDriver().findElement(UPLOAD_BUTTON).click();
    }

}
