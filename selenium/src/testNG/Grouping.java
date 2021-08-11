package testNG;

import org.testng.annotations.Test;

public class Grouping {

    @Test(groups = {"Fiction"})
    public void fictionBook1(){
        System.out.println("fictionBook1");
    }
    @Test(groups = {"Fiction"})
    public void fictionBook2(){
        System.out.println("fictionBook2");
    }
    @Test(groups = {"NonFiction"})
    public void nonFictionBook1(){
        System.out.println("nonFictionBook1");
    }
    @Test(groups = {"Fiction"})
    public void fictionBook3(){
        System.out.println("fictionBook3");
    }
    @Test(groups = {"NonFiction"})
    public void nonFictionBook2(){
        System.out.println("nonFictionBook2");
    }
    @Test(groups = {"NonFiction"})
    public void nonFictionBook3(){
        System.out.println("nonFictionBook3");
    }

}
