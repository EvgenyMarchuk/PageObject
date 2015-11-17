import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxesPage;

import static helpers.DriverSingleton.getDriver;

public class CheckBoxesTest extends TestBase{


    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void checkboxTest(){
        CheckboxesPage.selectCheckBoxes();
        Assert.assertTrue((getDriver().findElements(CheckboxesPage.CHECKBOXES)).get(0).isSelected());
        Assert.assertFalse((getDriver().findElements(CheckboxesPage.CHECKBOXES)).get(1).isSelected());
    }
}
