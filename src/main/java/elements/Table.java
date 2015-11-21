package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static helpers.Helper.getElementsTexts;

public class Table extends ElementBase{

    public Table(SearchContext host, By locator) {
        super(host, locator);
    }

    public int getColumnNumber() {
        return getColumnElement(0).size();
    }

    public int getRowNumber() {
        return getRowElement(0).size();
    }

    public List<List<WebElement>> getColumns() {
        List<List<WebElement>> columns = new ArrayList<>();
        for (int i = 0; i < getColumnNumber(); i++) {
            columns.add(getColumnElement(i));
        }
        return columns;
    }

    public List<List<String>> getColumnsText() {
        List<List<String>> texts = new ArrayList<>();
        for (int i = 0; i < getColumnNumber(); i++) {
            texts.add(getColumnElementText(i));
        }
        return texts;
    }

    public List<List<WebElement>> getRows() {
        List<List<WebElement>> rows = new ArrayList<>();
        for (int i = 0; i < getRowNumber(); i++) {
            rows.add(getRowElement(i));
        }
        return rows;
    }

    public List<List<String>> getRowsText() {
        List<List<String>> texts = new ArrayList<>();
        for (int i = 0; i < getRowNumber(); i++) {
            texts.add(getRowElementText(i));
        }
        return texts;
    }

    public List<WebElement> getColumnElement(int index) {
        return wrapElement.findElements(By.cssSelector(String.format("td:nth-child(%d)", ++index)));
    }

    public List<String> getColumnElementText(int index) {
        return getElementsTexts(getColumnElement(index));
    }

    public List<WebElement> getRowElement(int index) {
        return wrapElement.findElements(By.cssSelector("tbody tr")).get(index).findElements(By.tagName("td"));
    }

    public List<String> getRowElementText(int index) {
        return getElementsTexts(getRowElement(index));
    }

    public List<WebElement> getHeaderElements() {
        return wrapElement.findElements(By.tagName("th"));
    }

    public List<String> getHeaderElementsText() {
        return getElementsTexts(getHeaderElements());
    }

    public WebElement getHeader(int index) {
        return getHeaderElements().get(index);
    }

    public String  getHeaderText(int index) {
        return getHeader(index).getText();
    }

    public WebElement getHeader(String  name) throws Exception {
        for (WebElement header : getHeaderElements()) {
            if (header.getText().equals(name)) {
                return header;
            }
        }
        throw new Exception ("No such header " + name);
    }

    public WebElement getCell(int x, int y) {
        return getRowElement(x).get(y);
    }

    public String getCellText(int x, int y) {
        return getCell(x, y).getText();
    }

    public void sort(String headerName) throws Exception {
        getHeader(headerName).click();
    }

    public void sort(int index) {
        getHeader(index).click();
    }


}
