package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;
    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver == null){
            initDriver("chrome");
        }
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
        }
    }

    private static void initDriver(String browser) {
        String browserName = System.getProperty("browser", browser);
        String remote = System.getProperty("remote", "local");
        if (remote.equals("local")){
            switch (browserName) {
                case "firefox": default:
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                case "HtmlUnit":
                    driver = new HtmlUnitDriver();
                    break;
            }
        }else {
            DesiredCapabilities caps;
            switch (browserName) {
                case "chrome": default:
                    caps = DesiredCapabilities.chrome();
                    break;
                case "firefox":
                    caps = DesiredCapabilities.firefox();
                    break;
                case "ie":
                    caps = DesiredCapabilities.internetExplorer();
                    break;
                case "HtmlUnit":
                    caps = DesiredCapabilities.htmlUnitWithJs();
                    break;
                case "PhantomJS":
                    caps = DesiredCapabilities.phantomjs();
                    break;
            }
            try {
                driver = new RemoteWebDriver(new URL(remote), caps);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
