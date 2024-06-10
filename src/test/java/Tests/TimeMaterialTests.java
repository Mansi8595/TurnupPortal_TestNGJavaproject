
package Tests;

import Pages.Homepage;
import Pages.Login;
import Pages.TimeMaterialPage;
import Utils.CommonDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TimeMaterialTests extends CommonDriver {
    //Login page object initialization and definition
    Login loginPageObj = new Login();
    //Home page object initialization and definition
    Homepage homePageObj = new Homepage();
    //TM page object initialization and definition
    TimeMaterialPage tmPageObj = new TimeMaterialPage();

    @BeforeTest
    public void SetUpTimeMaterial() {
        //Open Chrome Browser
        driver = new ChromeDriver();
        loginPageObj.LoginActions(driver , "hari", "123123");
        homePageObj.VerifyLoggedInUser(driver);
        System.out.println("User logged in successfully");
        homePageObj.NavigateToTimeMaterialPage(driver);
    }

    /*
     *This test is for testing the Time record creation
     *these are the test data used for the test
     *Type = TestAnalyst-June2024
     */
    @Test(priority = 1, description = "This test create a new Time/Material record with valid details")
    public void TestCreateTimeMaterialRecord() {
        tmPageObj.CreateTimeRecord(driver);
    }

    @Test(priority = 2, description = "This test update the Time/Material record with valid details")
    public void TestUpdateTimeMaterialRecord() {
        tmPageObj.EditNewlyCreatedTMRecord(driver);
    }

    @Test(priority = 3, description = "This test delete the last Time/Material record")
    public void TestDeleteTimeMaterialRecord() {
        tmPageObj.DeleteTMRecord(driver);
    }

    @AfterTest
    public void CloseTestRun() {
        driver.quit();
    }
}