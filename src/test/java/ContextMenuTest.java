import helpers.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContextMenuPage;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.isAlertPresent;

public class ContextMenuTest extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Context Menu")).click();
    }

    @Test(description = "only firefox browser")
    public void contextMenuTest(){
        Actions actions = new Actions(getDriver());
        WebElement contextBox = getDriver().findElement(ContextMenuPage.HOT_SPOT_BOX);
        actions
                .contextClick(contextBox)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER).perform();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        Assert.assertFalse(isAlertPresent(getDriver()), "Alert is present");
    }
}
