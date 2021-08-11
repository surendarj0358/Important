package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG2 {

    WebDriver driver;

@BeforeSuite
public void launchBrowser(){
    System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
    driver = new ChromeDriver();
}
    @Test(priority = 1)
    public void openGoogle (){
        driver.get("https://www.google.com/");
    }

    @Test(priority = 2)
    public void openFacebook(){
       driver.get("https://www.facebook.com/");
    }

    @Test(priority = 3)
    public void openYoutube(){
      driver.get("https://www.youtube.com/");
    }
@AfterSuite
    public void closeBrowser(){
    driver.quit();
}


}

