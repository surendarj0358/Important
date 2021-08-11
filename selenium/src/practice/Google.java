package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Google {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/home/surenj/Downloads/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement searchBar = driver.findElement(By.name("q"));
                searchBar.sendKeys("selenium"+ Keys.ENTER);
//        WebElement searchButton = driver.findElement(By.className("gNO89b"))
//        searchButton.click();
    }
}
