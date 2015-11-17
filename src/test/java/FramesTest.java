import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FramesPage;

import static helpers.DriverSingleton.getDriver;

public class FramesTest extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Frames")).click();
    }

    @Test
    public void frameTest(){
        getDriver().findElement(By.linkText("Nested Frames")).click();

        getDriver().switchTo().frame("frame-bottom");
        Assert.assertEquals(getDriver().findElement(FramesPage.BODY_FRAME).getText().trim(), "BOTTOM");

        getDriver()
                .switchTo().defaultContent()
                .switchTo().frame("frame-top")
                .switchTo().frame("frame-left");
        Assert.assertEquals(getDriver().findElement(FramesPage.BODY_FRAME).getText().trim(), "LEFT");

        getDriver()
                .switchTo().parentFrame()
                .switchTo().frame("frame-middle");
        Assert.assertEquals(getDriver().findElement(FramesPage.CONTENT_FRAME).getText().trim(), "MIDDLE");

        getDriver()
                .switchTo().parentFrame()
                .switchTo().frame("frame-right");
        Assert.assertEquals(getDriver().findElement(FramesPage.BODY_FRAME).getText().trim(), "RIGHT");
    }
}
