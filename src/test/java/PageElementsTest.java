import helpers.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.PageElementsPageObject;

import static helpers.DriverSingleton.getDriver;

public class PageElementsTest extends TestBase{
    private final String USER_NAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";
    private PageElementsPageObject loginPage;

    @BeforeMethod
    public void goToLink(){
        getDriver().findElement(By.linkText("Form Authentication")).click();
    }

    @Test
    public void pageElementsLoginTest(){
        loginPage = new PageElementsPageObject(getDriver());
        loginPage.logIn(USER_NAME, PASSWORD);
        //Assert ?????????????????????
    }
}
