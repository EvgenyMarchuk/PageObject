import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.BasicAuthPage;

import java.io.IOException;

import static helpers.DriverSingleton.getDriver;

public class BasicAuthTest extends TestBase{

    @Test
    public void basicAuthTest() throws IOException {
        BasicAuthPage.authorization();
        getDriver().findElement(By.linkText("Basic Auth")).click();
    }
}
