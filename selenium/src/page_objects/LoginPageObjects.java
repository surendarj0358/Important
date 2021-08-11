package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoginPageObjects {

    @FindBy(id = "txtUsername")
    public static WebElement username;

    @FindBy(id = "txtPassword")
    public static WebElement password;

    @FindBy(id = "btnLogin")
    public static WebElement submit;

    @FindBy(id = "menu_pim_viewMyDetails")
    public static WebElement viewMyDetails;

    @FindBy(id = "btnSave")
    public static WebElement clickEdit;

    @FindBy(id = "personal_txtEmpFirstName")
    public static WebElement firstName;

    @FindBy(id = "personal_txtEmpLastName")
    public static WebElement lastName;

    @FindBy(id = "personal_txtEmployeeId")
    public static WebElement employeeID;

    @FindBy(id = "personal_txtOtherID")
    public static WebElement id;

    @FindBy(id = "personal_txtLicenNo")
    public static WebElement licenseNo;

    @FindBy(id = "personal_txtLicExpDate")
    public static WebElement licenseDate;

    @FindBy(id = "personal_optGender_1")
    public static WebElement gender;

    @FindBy(id ="personal_cmbMarital" )
    public static WebElement maritalStatus;

}
