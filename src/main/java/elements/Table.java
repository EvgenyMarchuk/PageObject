package elements;

import com.google.sitebricks.client.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static helpers.DriverSingleton.getDriver;

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
        return host.findElements(By.cssSelector(String.format("td:nth-child(%d)", ++index)));
    }

    public List<WebElement> getRowElements(int index){
        return host.findElements(By.cssSelector("tbody tr")).get(index).findElements(By.tagName("td"));
    }

    public List<WebElement> getHeaderElements(){
        return host.findElements(By.tagName("th"));
    }

    public WebElement getHeader(int index){
        return getHeaderElements().get(index);
    }

    public WebElement getHeader(String name) throws Exception {
        for (WebElement header : getHeaderElements()){
            if (header.getText().equals(name)){
                return header;
            }
        }
        throw new Exception("No such header: " + name);
    }
}
