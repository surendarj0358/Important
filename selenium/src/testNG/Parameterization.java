package testNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {

    @Test
    @Parameters("FictionBookName")
    public void fictionBook1(String bookName){
        System.out.println("The Fiction Book Name is : "+bookName);
    }
    @Test
    @Parameters("NonFictionBookName")
    public void nonFictionBook1(String bookTitle){
        System.out.println("The NOnFiction Book Name is : "+bookTitle);
    }
}
