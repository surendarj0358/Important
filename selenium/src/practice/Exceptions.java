package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exceptions {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/surenj/Downloads/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("hyderabad"+ Keys.ENTER);
        WebElement searc = driver.findElement(By.name("q"));
        search.sendKeys("zemoso");


    }

}
