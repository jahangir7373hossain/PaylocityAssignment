package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;


    public static void setDriver(){

        WebDriverManager.chromedriver().setup();

        String browser = TestUtils.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.get(TestUtils.getProperty("appUrl"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
