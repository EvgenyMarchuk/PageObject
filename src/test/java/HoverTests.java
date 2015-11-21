import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HoverPage;

import java.util.List;

import static helpers.DriverSingleton.getDriver;

public class HoverTests extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Hovers")).click();
    }

    @Test
    public void hoversTest(){
        List<WebElement> hoversList = getDriver().findElements(HoverPage.HOVER_FIGERES);
        int counter = 1;
        Actions actions = new Actions(getDriver());
        for (WebElement figure : hoversList){
            HoverPage.hoverFigure(actions, figure);
            Assert.assertTrue(figure.findElement(By.tagName("h5")).isDisplayed());
            Assert.assertEquals(figure.findElement(By.tagName("h5")).getText(), "name: user" + counter);
            counter++;
        }
    }
}
