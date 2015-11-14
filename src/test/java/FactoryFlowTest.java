import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

public class FactoryFlowTest {

    private WebDriver driver;
    private LogInFactoryFlowPage loginFactoryFlowPage;
    private HomeFactoryFlowPage homeFactoryFlowPage;
    private final static String BASE_URL = "http://the-internet.herokuapp.com/";
    private final String USER_NAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        driver.findElement(By.linkText("Form Authentication")).click();
        loginFactoryFlowPage = PageFactory.initElements(driver, LogInFactoryFlowPage.class);
        homeFactoryFlowPage = PageFactory.initElements(driver, HomeFactoryFlowPage.class);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginFactoryFlowTest(){
        loginFactoryFlowPage.logIn(driver, USER_NAME, PASSWORD);
        Assert.assertTrue(homeFactoryFlowPage.getHeader().isDisplayed());
        Assert.assertTrue(homeFactoryFlowPage.getLogoutButton().isDisplayed());
    }

    @Test
    public void logoutFactoryFlowTest(){
        loginFactoryFlowPage
                .logIn(driver, USER_NAME, PASSWORD)
                .logOut(driver)
                .verifyLoginPage(driver);
    }

}
