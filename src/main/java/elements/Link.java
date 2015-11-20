package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class Link extends ElementBase{
    public Link(SearchContext host, By locator) {
        super(host, locator);
    }

    public String getText(){
        return wrapElement.getText();
    }

    public String getUrl(){
        return wrapElement.getAttribute("href");
    }
}
