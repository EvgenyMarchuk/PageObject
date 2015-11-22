import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DynamicLoadingPage;

import static helpers.DriverSingleton.getDriver;
import static helpers.Waiter.waitVisibilityOf;
import static helpers.Waiter.waitVisibilityOfElementLocated;

public class DynamicLoadingTest extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Dynamic Loading")).click();
    }

    @Test
    public void elementGotVisibleTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/dynamic_loading");
        Assert.assertTrue(getDriver().findElement(DynamicLoadingPage.EXAMPLE_ONE).isDisplayed(),
                "Element not visible");
        getDriver().findElement(DynamicLoadingPage.EXAMPLE_ONE).click();
        WebElement startButton = getDriver().findElement(DynamicLoadingPage.START_BUTTON);
        WebElement finishBlock = getDriver().findElement(DynamicLoadingPage.FINISH_BLOCK);
        startButton.click();
        Assert.assertFalse(startButton.isDisplayed(), "Start button didn't disappear");
        waitVisibilityOf(getDriver(), 10, finishBlock);
        Assert.assertTrue(finishBlock.isDisplayed(), "finishBlock is invisible");
        Assert.assertEquals(finishBlock.getText(), "Hello World!");
    }

    @Test
    public void elementAppearedTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/dynamic_loading");
        Assert.assertTrue(getDriver().findElement(DynamicLoadingPage.EXAMPLE_TWO).isDisplayed(),
                "Element not visible");
        getDriver().findElement(DynamicLoadingPage.EXAMPLE_TWO).click();
        WebElement startButton = getDriver().findElement(DynamicLoadingPage.START_BUTTON);
        By finishBlock = DynamicLoadingPage.FINISH_BLOCK;
        startButton.click();
        Assert.assertFalse(startButton.isDisplayed(), "Start button didn't disappear");
        waitVisibilityOfElementLocated(getDriver(), 10, finishBlock);
        Assert.assertTrue(getDriver().findElement(finishBlock).isDisplayed(), "finishBlock is invisible");
        Assert.assertEquals(getDriver().findElement(finishBlock).getText(), "Hello World!");
    }
}
