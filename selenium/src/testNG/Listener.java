package testNG;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listener implements ITestListener {


    @Test(priority = 2)
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Case Is passed");
    }
}
