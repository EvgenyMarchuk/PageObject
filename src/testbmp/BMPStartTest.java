import net.lightbody.bmp.proxy.ProxyServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BMPStartTest {
    private final static String BASE_URL = "http://the-internet.herokuapp.com";
    private WebDriver driver;
    private ProxyServer bmp;

    @BeforeMethod
    public void setUp() throws Exception{
        bmp = new ProxyServer(8071);
        bmp.start();
        bmp.autoBasicAuthorization("the-internet.herokuapp.com", "admin", "admin");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, bmp.seleniumProxy());

        driver = new ChromeDriver(caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        driver.quit();
        driver = null;
        bmp.stop();
    }

    @Test
    public void bmpSimpleTest(){
        Assert.assertEquals(driver.getTitle(), "The Internet");
    }

    @Test
    public void bawSimpleTest(){
        driver.findElement(By.linkText("Basic Auth")).click();
        WebElement content = driver.findElement(By.id("content"));
        Assert.assertTrue(content.isDisplayed());
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Basic Auth");
    }
}
