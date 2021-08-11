package testNG;

import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;

public class TestNGFirst {

    @Test (priority = 1)
    public void firstTest (){
        System.out.println("This is the First Test");
    }

    @Test(priority = 2)
    public void secondTest(){

        System.out.println("This is the Second Test");
    }
    @Test(priority = 3)
    public void thirdTest(){

        System.out.println("This is the Third Test");
    }

    @Test(dependsOnMethods = "thirdTest")
    void fourthTest(){

        System.out.println("This is the Fourth Test");
    }

}
