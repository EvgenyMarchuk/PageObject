package helpers;

import org.testng.annotations.*;

import static helpers.DriverSingleton.getDriver;

public class TestBase {

    private final static String BASE_URL = "http://the-internet.herokuapp.com/";

    @BeforeTest
    public void setUp(){
        getDriver().navigate().to(BASE_URL);
    }

    @AfterTest
    public void tearDown(){
        DriverSingleton.quit();
    }
}
