import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxesPage;

import java.util.List;

import static helpers.DriverSingleton.getDriver;

public class CheckBoxesTest extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void checkboxTest(){
        List<WebElement> element = getDriver().findElements(CheckboxesPage.CHECKBOXES);
        CheckboxesPage.selectCheckBoxes(element);
        Assert.assertTrue((getDriver().findElements(CheckboxesPage.CHECKBOXES)).get(0).isSelected());
        Assert.assertFalse((getDriver().findElements(CheckboxesPage.CHECKBOXES)).get(1).isSelected());
    }
}
