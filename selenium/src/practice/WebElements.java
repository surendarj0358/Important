package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebElements {

    public static void main(String[] args) {

       System.setProperty("webdriver.chrome.driver","/home/surenj/Downloads/Selenium/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.navigate().to("http://www.leafground.com/pages/Link.html");

//     working with link text
       WebElement link =  driver.findElement(By.linkText("Go to Home Page"));
       link.click();
       driver.navigate().back();

       WebElement partialLink =  driver.findElement(By.partialLinkText("Home Page"));
       partialLink.click();

//     text box
       driver.findElement(By.xpath("//*[@id=\"post-153\"]/div[2]/div/ul/li[1]/a")).click();

       WebElement textBox1 = driver.findElement(By.id("email"));
       textBox1.sendKeys("user@mail.com");

       WebElement textBox2 = driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/div/input"));
       textBox2.sendKeys(" Text");

       String text = driver.findElement(By.name("username")).getAttribute("value");
       System.out.println(text);

       System.out.println(driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[3]/div/div")).getText());

       boolean staus = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/div/div/input")).isEnabled();
       System.out.println(staus);

       driver.navigate().back();

//     handle button

       driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[2]/a/img")).click();
       String url = driver.getCurrentUrl();
       System.out.println(url);

       driver.findElement(By.id("home")).click();
       String afterclick = driver.getCurrentUrl();
       System.out.println(afterclick);

//     Dropdown
       driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[5]/a")).click();
       WebElement dropdown =  driver.findElement(By.id("dropdown1"));
       Select select = new Select(dropdown);

       select.selectByValue("1");
       select.selectByIndex(2);
       select.selectByVisibleText("Selenium");

       driver.navigate().back();

//     handling popups
       driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[9]/a/img")).click();

       driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[1]/div/div/button")).click();

       Alert alert = driver.switchTo().alert();
       alert.accept();
         driver.navigate().back();


//     grids in webPage

         driver.findElement(By.xpath("//*[@id=\'post-153\']/div[2]/div/ul/li[8]/a/img")).click();

         List<WebElement> column = driver.findElements(By.tagName("th"));
         int noOfColumn = column.size();
         System.out.println(noOfColumn);

         List<WebElement> rows = driver.findElements(By.tagName("tr"));
         int noOfRows = column.size();
         System.out.println(noOfRows);

         WebElement tdvalue = driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
         String progressValue =  tdvalue.getText();
         System.out.println(progressValue);

         List<WebElement> progressValues = driver.findElements(By.xpath("//td[2]"));
         List<Integer> progressNumbers = new ArrayList<Integer>();

            for (WebElement progressElements:progressValues) {
                String progressString = progressElements.getText().replace("%","");
                progressNumbers.add(Integer.parseInt(progressString));
            }

         System.out.println(progressNumbers);
         int samllValue = Collections.min(progressNumbers);
         System.out.println(samllValue);
         String smallvalue = Integer.toString(samllValue)+"%";

         String xpath = "//td[normalize-space()="+"\""+ smallvalue +"\""+"]"+"//following::td[1]";
         System.out.println(xpath);
         WebElement check = driver.findElement(By.xpath("//td[normalize-space()=\"30%\"]//following::td[1]"));
         check.click();

    }
}
