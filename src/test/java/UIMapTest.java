import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class UIMapTest {

    private WebDriver driver;
    private UIMapLoginPage uiMapLoginPage;
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
        uiMapLoginPage = new UIMapLoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void uiMapLoginTest(){
        uiMapLoginPage.login(USER_NAME,PASSWORD);
        Assert.assertTrue(driver.findElement(By.cssSelector("#flash.success")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".secondary.radius")).isDisplayed());
    }
}
