import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FileUploadPage;

import java.io.IOException;

import static helpers.DriverSingleton.getDriver;

public class FileUploadTest extends TestBase{

    private static final String SUCCESS_MSG = "File Uploaded!";

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("File Upload")).click();
    }

    @Test
    public void uploadFileTest() throws IOException, InterruptedException {
        FileUploadPage.uploadFile();
        Assert.assertEquals(getDriver().findElement(FileUploadPage.SUCCESS_MSG_TEXT).getText(), SUCCESS_MSG);
        Assert.assertTrue(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).isDisplayed());
        Assert.assertEquals(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).getText(),
                FileUploadPage.faleName);
    }

    @Test
    public void uploadFileInputTest() throws IOException, InterruptedException {
        FileUploadPage.uploadFileInput();
        Assert.assertEquals(getDriver().findElement(FileUploadPage.SUCCESS_MSG_TEXT).getText(), SUCCESS_MSG);
        Assert.assertTrue(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).isDisplayed());
        Assert.assertEquals(getDriver().findElement(FileUploadPage.UPLOAD_FILES_FIELD).getText(),
                FileUploadPage.faleName);
    }

}
