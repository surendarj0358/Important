package com.ldp.keyworddriven.engine;

import com.ldp.keyworddriven.base.Base;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestEngine {

    public WebDriver driver;
    public Properties properties;
    public WebElement element;

    public Workbook workbook;
    public Sheet sheet;
    public Base base;

    public static ThreadLocal<Workbook> testBook = new ThreadLocal<Workbook>();
    public static ThreadLocal<Sheet> testSheet = new ThreadLocal<Sheet>();

    public String scenarioPath = ("/home/surenj/IdeaProjects/com.ldp.keyworddriven/src/main/java/com/ldp/keyworddriven/scenario/keyword.xlsx");

    public void getExcelData(String sheetName) {
        String locatorName = null;
        String locatorValue = null;

        FileInputStream file = null;
        try {
            file = new FileInputStream(scenarioPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        sheet = workbook.getSheet(sheetName);
        int k = 0;
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            try {
                String locator = sheet.getRow(i + 1).getCell(k + 1).toString().trim();
                if (!locator.equalsIgnoreCase("na")) {
                    locatorName = locator.split("=")[0].trim();
                    locatorValue = locator.split("=")[1].trim();
                }
                String action = sheet.getRow(i + 1).getCell(k + 2).toString().trim();
                String value = sheet.getRow(i + 1).getCell(k + 3).toString().trim();

                System.out.println(action);
                System.out.println(value);

                switch (action) {
                    case "open browser":
                        base = new Base();
                        properties = base.propertyFile();
                        if (value.isEmpty() || value.equalsIgnoreCase("NA")) {
                            driver = base.launchDriver(properties.getProperty("browser"));
                        } else {
                            driver = base.launchDriver(value);
                        }
                        break;

                    case "enter url":
                        if (value.isEmpty() || value.equalsIgnoreCase("NA")) {
                            driver.get(properties.getProperty("url"));
                        } else {
                            driver.get(value);
                        }
                        break;
                    case "quit":
                        driver.quit();
                        break;
                    default:
                        break;
                }

                switch (locatorName) {
                    case "id":
                        element = driver.findElement(By.id(locatorValue));
                        if (action.equalsIgnoreCase("sendkeys")) {
                            element.clear();
                            element.sendKeys(value);
                        } else if (action.equalsIgnoreCase("click")) {
                            element.click();
                        } else if (action.equalsIgnoreCase("isDisplayed")) {
                            element.isDisplayed();
                        } else if (action.equalsIgnoreCase("getText")) {
                            String text = element.getAccessibleName();
                            System.out.println(text);
                        }

                        locatorName = null;
                        break;
                    default:
                        break;
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}


