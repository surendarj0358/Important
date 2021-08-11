package datadriven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestUtil;

import java.io.IOException;
import java.lang.*;
import java.util.concurrent.TimeUnit;


public class Login {
WebDriver driver;

    @DataProvider
    public Object[][] dataEngine(){
        Object data[][] = TestUtil.getExcelData("Sheet1");
        return data;
    }


    @Test (dataProvider = "dataEngine")
    public void Login(String username, String passWord) throws IOException {

            driver.findElement(By.id("txtUsername")).sendKeys(username);
            driver.findElement(By.id("txtPassword")).sendKeys(passWord);
            driver.findElement(By.id("btnLogin")).click();
        }

    @BeforeSuite
    public void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
@AfterSuite
    public void tearDown () {
        driver.quit();
}

}