package helpers;

import com.google.sitebricks.client.Web;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static helpers.DriverSingleton.getDriver;

public class Helper {

    public static void check(WebElement checkBox){
        setCheckBox(checkBox, true);
    }

    public static void unCheck(WebElement checkBox){
        setCheckBox(checkBox, false);
    }

    private static void setCheckBox(WebElement checkBox, boolean value){
        if (checkBox.isSelected() != value){
            checkBox.click();
        }
    }

    public static void saveScreenshot(String fileName) {
        TakesScreenshot screenMaker = (TakesScreenshot)getDriver();
        File screen = screenMaker.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("target/" + fileName));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void executeScriptCmd(String cmdProgram, File fileUpload) throws IOException {
        String filePath = fileUpload.getAbsolutePath();
        Runtime.getRuntime().exec(new String[] {cmdProgram, filePath});
    }

    public static void executeScriptCmd(String cmdProgram, String[] args) throws IOException {
        Runtime.getRuntime().exec(new String[] {cmdProgram, args[0], args[1]});
    }

    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public static List<String> getElementTexts(Collection<WebElement> elements){
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements){
            texts.add(element.getText());
        }
        return texts;
    }
}