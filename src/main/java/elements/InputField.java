package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class InputField extends ElementBase{

    public InputField(SearchContext host, By locator) {
        super(host, locator);
    }

    public void append(String value){
        wrapElement.sendKeys(value);
    }

    public void setText(String text){
        clear();
        append(text);
    }

    private void clear() {
        wrapElement.clear();
    }

    public String getText(){
        return wrapElement.getAttribute("value");
    }

    public boolean isEnabled(){
        return wrapElement.isEnabled();
    }

}
