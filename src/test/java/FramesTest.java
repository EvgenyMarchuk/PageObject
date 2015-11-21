import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public void nestedFrameTest(){
        getDriver().findElement(FramesPage.NESTED_FRAME).click();

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

    @Test
    public void iFrameTest(){
        getDriver().findElement(FramesPage.I_FRAME).click();
        getDriver().manage().window().setSize(new Dimension(640, 480));
        getDriver().findElement(By.id("mceu_9")).click();
        (new Actions(getDriver()))
                .sendKeys(Keys.LEFT_CONTROL + "A")
                .perform();
        getDriver().findElement(By.id("mceu_9")).click();
        (new Actions(getDriver()))
                .sendKeys("test1")
                .sendKeys(Keys.ENTER)
                .sendKeys("test2")
                .sendKeys(Keys.ENTER)
                .sendKeys("test3")
                .sendKeys(Keys.ENTER).perform();
        WebElement element = getDriver().findElement(By.id("mce_0_ifr"));
        getDriver().switchTo().frame(element);
    }
}
