package testNG;

import org.testng.annotations.Test;

public class TestNG3 {

    @Test(priority = 1,enabled = true)
    public void secondarySchool (){
        System.out.println("Secondary results : All Pass");
    }

    @Test(dependsOnMethods = "secondarySchool")
    public void higherSecondary() {
        System.out.println("Higher Secondary results : All Pass");
    }

    @Test(dependsOnMethods = "higherSecondary")
    public void UG(){
        System.out.println("UG Final Result: All Clear");
    }

    @Test(dependsOnMethods = "UG")
    public  void PG(){

        System.out.println("PG Final Result: All Clear");
    }

}

