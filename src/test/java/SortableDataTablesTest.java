import elements.Table;
import helpers.TestBase;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SortableDataTablesPage;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static helpers.DriverSingleton.getDriver;
import static helpers.Helper.getElementTexts;

public class SortableDataTablesTest extends TestBase{

    public static final int LAST_NAME_COLUMN = 0;

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Sortable Data Tables")).click();
    }

//    @Test
//    public void sortLastNameTest() throws InterruptedException {
//        List<String> lastNameColumnText = getElementTexts(getColumnElements(1));
//        SortableDataTablesPage.sortColumn();
//        Collections.sort(lastNameColumnText);
//        Assert.assertEquals(lastNameColumnText, getElementTexts(getColumnElements(1)));
//        SortableDataTablesPage.sortColumn();
//        Collections.reverse(lastNameColumnText);
//        Assert.assertEquals(lastNameColumnText, getElementTexts(getColumnElements(1)));
//    }

    @Test
    public void sortTableLastNameTest() throws Exception {
        Table table = new Table(getDriver(), By.id("table1"));
        List<String> lastNameColumnText = table.getColumnElementText(LAST_NAME_COLUMN);
        table.sort("Last Name");
        Collections.sort(lastNameColumnText);
        Assert.assertEquals(lastNameColumnText, table.getColumnElementText(LAST_NAME_COLUMN));
        table.sort("Last Name");
        Collections.reverse(lastNameColumnText);
        Assert.assertEquals(lastNameColumnText, table.getColumnElementText(LAST_NAME_COLUMN));
    }
}
