import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomeFactoryPage;
import pages.LoginFactoryPage;

import java.util.concurrent.TimeUnit;

public class FactoryTest {

    private WebDriver driver;
    private LoginFactoryPage loginPageFactory;
    private HomeFactoryPage homePageFactory;
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
        loginPageFactory = PageFactory.initElements(driver, LoginFactoryPage.class);
        homePageFactory = PageFactory.initElements(driver, HomeFactoryPage.class);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginFactoryTest(){
        loginPageFactory.logIn(USER_NAME, PASSWORD);
        Assert.assertTrue(homePageFactory.getHeader().isDisplayed());
        Assert.assertTrue(homePageFactory.getLogoutButton().isDisplayed());
    }

    @Test
    public void logoutFactoryTest(){
        loginPageFactory.logIn(USER_NAME, PASSWORD);
        homePageFactory.logOut();
        Assert.assertTrue(loginPageFactory.getUserName().isDisplayed());
        Assert.assertTrue(loginPageFactory.getPassword().isDisplayed());
        Assert.assertTrue(loginPageFactory.getLoginButton().isDisplayed());
    }
}
