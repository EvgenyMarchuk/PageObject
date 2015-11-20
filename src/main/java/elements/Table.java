package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static helpers.Helper.getElementTexts;

public class Table extends ElementBase{

    public Table(SearchContext host, By locator) {
        super(host, locator);
    }

    public int getColumnNumber(){
        return getColumnElements(0).size();
    }

    public int getRowNumber(){
        return getRowElements(0).size();
    }

    public List<List<WebElement>> getRows(){
        List<List<WebElement>> row = new ArrayList<>();
        for (int i = 0; i < getRowNumber(); i++){
            row.add(getRowElements(i));
        }
        return row;
    }

    public List<List<WebElement>> getColumns(){
        List<List<WebElement>> column = new ArrayList<>();
        for (int i = 0; i < getColumnNumber(); i++){
            column.add(getColumnElements(i));
        }
        return column;
    }

    public List<WebElement> getColumnElements(int index){
        return wrapElement.findElements(By.cssSelector(String.format("td:nth-child(%d)", ++index)));
    }

    public List<WebElement> getRowElements(int index){
        return wrapElement.findElements(By.cssSelector("tbody tr")).get(index).findElements(By.tagName("td"));
    }

    public List<WebElement> getHeaderElements(){
        return wrapElement.findElements(By.tagName("th"));
    }

    public List<String> getHeaderElementTexts(){
        return getElementTexts(getHeaderElements());
    }

    public WebElement getHeader(int index){
        return getHeaderElements().get(index);
    }

    public String getHeaderText(int index){
        return getHeader(index).getText();
    }

    public WebElement getHeader(String name) throws Exception {
        for (WebElement header : getHeaderElements()){
            if (header.getText().equals(name)){
                return header;
            }
        }
        throw new Exception("No such header: " + name);
    }

    public WebElement getCell(int x, int y){
        return getRowElements(x).get(y);
    }

    public String getCellText(int x, int y){
        return getCell(x, y).getText();
    }

    public void sort(String headerName) throws Exception {
        getHeader(headerName).click();
    }

    public List<String> getColumnElementText(int index) {
        return null;
    }


}
