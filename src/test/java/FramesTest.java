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

        FramesPage.switchToFrame(getDriver(), "frame-bottom");
        Assert.assertEquals(getDriver().findElement(FramesPage.BODY_FRAME).getText().trim(), "BOTTOM");

        FramesPage.switchToParenFrame(getDriver(), "frame-top", "frame-left");
        Assert.assertEquals(getDriver().findElement(FramesPage.BODY_FRAME).getText().trim(), "LEFT");

        FramesPage.switchToParenFrame(getDriver(), "frame-top", "frame-middle");
        Assert.assertEquals(getDriver().findElement(FramesPage.CONTENT_FRAME).getText().trim(), "MIDDLE");

        FramesPage.switchToParenFrame(getDriver(), "frame-top", "frame-right");
        Assert.assertEquals(getDriver().findElement(FramesPage.BODY_FRAME).getText().trim(), "RIGHT");
        FramesPage.switchToDefaultContent(getDriver());
    }
}
