package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Label extends ElementBase{

    public Label(SearchContext host, By locator) {
        super(host, locator);
    }

    public String getText(){
        return wrapElement.getText();
    }
}
