import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.SortableDataTablesPage;


import java.util.Collections;
import java.util.List;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.getElementTexts;

public class SortableDataTablesTest extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Sortable Data Tables")).click();
    }

    @Test
    public void sortLastNameTest() throws InterruptedException {
        List<String> lastNameColumnText = getElementTexts(getColumnElements(1));
        SortableDataTablesPage.sortColumn();
        Collections.sort(lastNameColumnText);
        Assert.assertEquals(lastNameColumnText, getElementTexts(getColumnElements(1)));
        SortableDataTablesPage.sortColumn();
        Collections.reverse(lastNameColumnText);
        Assert.assertEquals(lastNameColumnText, getElementTexts(getColumnElements(1)));
    }

}
