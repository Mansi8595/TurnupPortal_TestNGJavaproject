
package Tests;

import Pages.EmployeePage;
import Pages.Homepage;
import Pages.Login;
import Utils.CommonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeeTests extends CommonDriver {
    //Login page object initialization and definition
    Login loginPageObj = new Login();
    //Home page object initialization and definition
    Homepage homePageObj = new Homepage();
    //Employee page object initialization and definition
    EmployeePage employeePageObj = new EmployeePage();

    @BeforeTest
    public void SetUp() {
        //Open Chrome Browser
        driver = new ChromeDriver();

        loginPageObj.LoginActions(driver, "hari", "123123");
        System.out.println("User logged in successfully - EmployeeTests");
        homePageObj.VerifyLoggedInUser(driver);
        System.out.println("User logged in successfully - EmployeeTests");
        homePageObj.NavigateToEmployeePage(driver);
    }

    @Test(priority = 1, description = "This test create a Employee record with valid details")
    public void TestCreateEmployeeRecord() {
        employeePageObj.CreateEmployeeRecord(driver);
    }

    @Test(priority = 2, description = "This test update the Employee record with valid details")
    public void TestUpdateEmployeeRecord() {
        employeePageObj.EditEmployeeRecord(driver);
    }

    @Test(priority = 3, description = "This test delete the last Employee record")
    public void TestDeleteEmployeeRecord() {
        employeePageObj.DeleteEmployeeRecord(driver);
    }

    @AfterTest
    public void CloseTestRun() {
        driver.quit();
    }
}
