package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronization {
    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver","/home/surenj/Downloads/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.in/");
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
        driver.findElement(By.id("nav-search-submit-button")).click();

//       driver.findElement(By.partialLinkText("New Apple iPhone 11")).click();


        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement iphone = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("New Apple iPhone 11 ")));
        iphone.click();


}
}
