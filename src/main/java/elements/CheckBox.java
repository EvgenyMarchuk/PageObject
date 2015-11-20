package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

public class CheckBox extends ElementBase{

    public CheckBox(SearchContext host, By locator) {
        super(host, locator);
    }

    public boolean isSelected(){
        return wrapElement.isSelected();
    }

    public void check(){
        setCheckBox(true);
    }

    public void unCheck(){
        setCheckBox(false);
    }

    private void setCheckBox(boolean value){
        if (isSelected() != value){
            click();
        }
    }
}
