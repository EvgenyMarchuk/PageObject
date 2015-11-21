import helpers.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.KeyPressPage;

import static helpers.DriverSingleton.getDriver;

public class KeyPressTest extends TestBase{

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Key Presses")).click();
    }

    @Test
    public void sendKeysTest() {
        final char[] CHARS = "ASERTYBYFUQ".toCharArray();
        Actions actions = new Actions(getDriver());
        for (char s : CHARS){
            String enteredValue = String.valueOf(s);
            actions.sendKeys(enteredValue).perform();
            Assert.assertEquals(getDriver().findElement(KeyPressPage.KEY_PRESS_RESULT).getText(),
                    "You entered: " + enteredValue);
        }
    }
}
