package pages;

import org.openqa.selenium.By;

import static helpers.DriverSingleton.getDriver;
import static helpers.Locators.get;

public class SortableDataTablesPage {
    private static final By CELL = get("tables.firstColumn");
    private static final By HEAD_COLUMN = get("tables.headColumn");


    public static void sortColumn() {
         getDriver().findElement(HEAD_COLUMN).click();
    }
}
