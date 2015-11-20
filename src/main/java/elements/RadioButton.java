package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class RadioButton extends CheckBox{
    public RadioButton(SearchContext host, By locator) {
        super(host, locator);
    }
}
