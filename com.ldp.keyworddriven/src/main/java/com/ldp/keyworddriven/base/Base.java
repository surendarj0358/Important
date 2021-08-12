package com.ldp.keyworddriven.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties properties;

    public WebDriver launchDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
            driver = new ChromeDriver();

//            if (properties.getProperty("headless").equalsIgnoreCase("yes")) {
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
//                driver = new ChromeDriver(options);
//            } else {
//                driver = new ChromeDriver();
//            }
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;


    }
        public Properties propertyFile(){
            properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream("/home/surenj/IdeaProjects/com.ldp.keyworddriven/src/main/java/com/ldp/keyworddriven/config/config.propertise");
                properties.load(fileInputStream);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return properties;
        }
    }



















