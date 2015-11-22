import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DropDownPage;

import java.util.List;

import static helpers.DriverSingleton.getDriver;

public class DropDownTest extends TestBase{
    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Dropdown")).click();
    }

    @Test
    public void dropDownTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://the-internet.herokuapp.com/dropdown");
        WebElement select = getDriver().findElement(DropDownPage.DROP_DOWN_ELEMENT);
        Select dropDown = new Select(select);
        List<WebElement> options = dropDown.getOptions();
        Assert.assertEquals(options.size(), 3);
        Assert.assertFalse(dropDown.isMultiple());
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Please select an option");
        Assert.assertEquals(options.get(0).getText(), "Please select an option");
        Assert.assertFalse(options.get(0).isEnabled());
        Assert.assertEquals(options.get(1).getText(), "Option 1");
        Assert.assertEquals(options.get(2).getText(), "Option 2");
        dropDown.selectByValue("1");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Option 1");
    }
}
