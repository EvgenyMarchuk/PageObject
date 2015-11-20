package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public abstract class ElementBase {
    protected final SearchContext host;
    protected final WebElement wrapElement;
    protected final By locator;

    public ElementBase(SearchContext host, By locator) {
        this.host = host;
        this.wrapElement = host.findElement(locator);
        this.locator = locator;
    }

    public void click(){
        wrapElement.click();
    }

    public void focus(){
        wrapElement.sendKeys("");
    }

    public WebElement getWrapElement() {
        return wrapElement;
    }

    public By getLocator() {
        return locator;
    }

    public SearchContext getHost() {
        return host;
    }
}
