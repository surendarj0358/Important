package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {
public static WebDriver driver;
public static Properties properties = null;
    public Properties propertiseFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/home/surenj/IdeaProjects/selenium/src/pageobject_test_case/config.propertise");
        properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }
    @BeforeSuite
    public void launchBrowser() throws IOException {
        propertiseFile();
    String browser = properties.getProperty("browser");
    String url = properties.getProperty("url");
    String driverLocation = properties.getProperty("driverLocation");
    if (browser.equalsIgnoreCase("Chrome")){
        System.setProperty("webdriver.chrome.driver", driverLocation);
        driver = new ChromeDriver();
    }else if (browser.equalsIgnoreCase("firefox")){
        System.setProperty("webdriver.chrome.driver", driverLocation);
        driver = new ChromeDriver();
        }
    driver.manage().window().maximize();
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


}
