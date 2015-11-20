package elements;

import com.google.sitebricks.client.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends HasText{
    private Select select;

    public DropDown(SearchContext host, By locator) {
        super(host, locator);
        select = new Select(wrapElement);
    }

    public boolean isMultiple(){
        return select.isMultiple();
    }

    @Override
    public String getText(){
        return select.getFirstSelectedOption().getText();
    }

    public void selectByText(String text){
        select.selectByVisibleText(text);
    }

    public void selectByIndex(int index){
        select.selectByIndex(index);
    }

    public List<String> getOptions(){
        List<WebElement> options = select.getOptions();
        List<String> optionsText = new ArrayList<>();
        for(WebElement option: options){
            optionsText.add(option.getText());
        }
        return optionsText;
    }
}
