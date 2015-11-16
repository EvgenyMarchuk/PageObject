package helpers;

import org.testng.annotations.*;

import static helpers.DriverSingleton.getDriver;

public class TestBase {

    private final static String BASE_URL = "http://the-internet.herokuapp.com/";

    @BeforeMethod
    public void setUp(){
        getDriver().navigate().to(BASE_URL);
    }

    @AfterClass
    public void tearDown(){
        getDriver().manage().deleteAllCookies();
        DriverSingleton.quit();
    }
}
