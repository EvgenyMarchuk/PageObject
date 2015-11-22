import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FileUploadPage;

import java.io.File;
import java.io.IOException;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.executeScriptCmd;

public class FileUploadTest extends TestBase{

    private static final String SUCCESS_MSG = "File Uploaded!";
    private final String CMD_PROGRAM = "./src/main/resources/upload.exe";
    private static File FILE_UPLOAD_PATH = new File("./src/main/resources/test.txt");
    public static final String FILE_NAME = FILE_UPLOAD_PATH.getName();

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("File Upload")).click();
    }

    @Test
    public void uploadFileTest() throws InterruptedException, IOException {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/upload");
        FileUploadPage.viewButtonClick();
        executeScriptCmd(CMD_PROGRAM, FILE_UPLOAD_PATH);
        Thread.sleep(500);
        FileUploadPage.uploadButtonClick();
        Assert.assertEquals(getDriver().findElement(FileUploadPage.SUCCESS_MSG_TEXT).getText(), SUCCESS_MSG);
        Assert.assertTrue(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).isDisplayed());
        Assert.assertEquals(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).getText(),
                FILE_NAME);
    }

    @Test
    public void uploadFileInputTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/upload");
        FileUploadPage.uploadFileInput(FILE_UPLOAD_PATH.getAbsolutePath());
        Assert.assertEquals(getDriver().findElement(FileUploadPage.SUCCESS_MSG_TEXT).getText(), SUCCESS_MSG);
        Assert.assertTrue(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).isDisplayed());
        Assert.assertEquals(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).getText(),
                FILE_NAME);
    }

}
