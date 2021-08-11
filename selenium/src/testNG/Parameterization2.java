package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Parameterization2 {


    WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url"})
    void launchBrowser(String browser,String url) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
            driver = new ChromeDriver();

        }
        driver.get(url);
    }
    @Test(priority = 1)
    public void logo (){
        WebElement logo = driver.findElement(By.id("divLogo"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority = 2)
    public void homePage(){
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title);
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }


}

