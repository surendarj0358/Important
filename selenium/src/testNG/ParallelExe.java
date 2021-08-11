package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ParallelExe {


    @Test
    public void openGoogle (){
        System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }

    @Test
    public void openFacebook(){
        System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void openYoutube(){
        System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.quit();
    }

}
