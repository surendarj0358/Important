package pageobject_test_case;

import common.CommonFunctions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import page_objects.LoginPageObjects;

import java.io.IOException;

public class Test1 extends CommonFunctions {

    @Test(priority = 1)
    public void login() throws IOException {

        PageFactory.initElements(driver,LoginPageObjects.class);
        LoginPageObjects.username.sendKeys(properties.getProperty("username"));
        LoginPageObjects.password.sendKeys(properties.getProperty("password"));
        LoginPageObjects.submit.click();

        LoginPageObjects.viewMyDetails.click();
        LoginPageObjects.clickEdit.click();
        LoginPageObjects.firstName.clear();
        LoginPageObjects.firstName.sendKeys("Surendar");
        LoginPageObjects.lastName.sendKeys("Kumar");
        LoginPageObjects.employeeID.sendKeys("2345");
        LoginPageObjects.id.sendKeys("123");
        LoginPageObjects.licenseNo.sendKeys("Awds1234");
        LoginPageObjects.licenseDate.sendKeys("2022-08-12");
        LoginPageObjects.gender.click();
        Select select = new Select(LoginPageObjects.maritalStatus);
        select.selectByValue("Single");
    }

}
