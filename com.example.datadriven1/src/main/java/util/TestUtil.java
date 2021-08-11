package util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {
    static Workbook workbook;
    static Sheet sheet;

    public static String testDataPath ="/home/surenj/IdeaProjects/com.example.datadriven1/src/main/java/testdata/worksheet.xlsx";

    public static Object[][] getExcelData(String sheetName){
        FileInputStream file = null;
        try {
             file = new FileInputStream(testDataPath);
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
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0;i<sheet.getLastRowNum();i++){
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                data[i][j] = sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }
}
