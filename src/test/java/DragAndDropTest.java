import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DragAndDropPage;

import static helpers.DriverSingleton.getDriver;

public class DragAndDropTest extends TestBase{
    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Drag and Drop")).click();
    }

    @Test
    public void dragAndDrop1Test() throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = getDriver().findElement(DragAndDropPage.SOURCE_ELEMENT);
        WebElement target = getDriver().findElement(DragAndDropPage.TARGET_ELEMENT);
        Actions actions = new Actions(getDriver());
        actions.dragAndDrop(source, target).perform();
        Assert.assertEquals(source.findElement(By.tagName("header")).getText(), "B");
        Assert.assertEquals(target.findElement(By.tagName("header")).getText(), "A");
    }

    @Test
    public void dragAndDrop2Test() throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = getDriver().findElement(DragAndDropPage.SOURCE_ELEMENT);
        WebElement target = getDriver().findElement(DragAndDropPage.TARGET_ELEMENT);
        Actions actions = new Actions(getDriver());
        actions
                .clickAndHold(source)
                .moveToElement(target)
                .release()
                .perform();
        actions.moveToElement(source).perform();
        Thread.sleep(2000);
        actions.click(source).perform();
        Thread.sleep(2000);
        actions.clickAndHold(source).perform();
        Thread.sleep(2000);
        actions.moveToElement(target).perform();
        Thread.sleep(2000);
        Assert.assertEquals(source.findElement(By.tagName("header")).getText(), "B");
        Assert.assertEquals(target.findElement(By.tagName("header")).getText(), "A");
    }

    @Test
    public void dragAndDrop3Test() throws InterruptedException {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = getDriver().findElement(DragAndDropPage.SOURCE_ELEMENT);
        WebElement target = getDriver().findElement(DragAndDropPage.TARGET_ELEMENT);
        Actions actions = new Actions(getDriver());
        actions
                .clickAndHold(source)
                .moveByOffset(200, 300)
                .release()
                .perform();
        actions.moveToElement(source).perform();
        Thread.sleep(2000);
        actions.click(source).perform();
        Thread.sleep(2000);
        actions.clickAndHold(source).perform();
        Thread.sleep(2000);
        actions.moveToElement(target).perform();
        Thread.sleep(2000);
        Assert.assertEquals(source.findElement(By.tagName("header")).getText(), "B");
        Assert.assertEquals(target.findElement(By.tagName("header")).getText(), "A");

    }
}
