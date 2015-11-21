import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasicAuthPage;

import java.io.IOException;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.executeScriptCmd;

public class BasicAuthTest extends TestBase{

    private static final String CMD_PROGRAM = "./src/main/resources/wab.exe";
    private static final String[] ACCOUNT_DATA = {"admin", "admin"};
    private static final String HEAD_PAGE = "Basic Auth";
    private static final String AUTH_SUCCESS = "Congratulations! You must have the proper credentials.";

    @BeforeMethod
    public void goToLink() throws IOException {
        executeScriptCmd(CMD_PROGRAM, ACCOUNT_DATA);
    }

    @Test
    public void basicAuthTest() {
        getDriver().findElement(By.linkText("Basic Auth")).click();
        Assert.assertEquals(getDriver().findElement(BasicAuthPage.HEAD_PAGE_LABEL).getText(),
                HEAD_PAGE);
        Assert.assertEquals(getDriver().findElement(BasicAuthPage.CONTENT_EXAMPLE_LABEL).getText(),
                AUTH_SUCCESS);
    }
}
