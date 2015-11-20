package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Button extends ElementBase{

    public Button(SearchContext host, By locator) {
        super(host, locator);
    }

    public void click(){
        wrapElement.click();
    }

    public void getText(){
        wrapElement.getText();
    }

    public boolean isEnabled(){
        return wrapElement.isEnabled();
    }

}
