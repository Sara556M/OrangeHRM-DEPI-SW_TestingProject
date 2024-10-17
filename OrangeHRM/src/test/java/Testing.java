import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class Testing {
    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    PIMPage pimPage;
    DashboardPage dashboardPage;
    WebDriverWait wait;
    LogoutPage logoutpage;

    /*******for login Page*********************/
    String UserNameLogin ="Admin";
    String PasswordLogin ="admin123";
    /*****************************************/

    /***************for admin page *************************/
    String UserNameForadmin ="Abdullah Wahid";
    String Passwordforadmin = "Abdullah123@";
    String ConfirmPasswordforadmin ="Abdullah123@";
    String EmployeeNameSelectFirst ="Abdullah";
    String Statusforadminpage="Enabled";
    String UserRoleforadminpage = "Admin";
    String Shiftname ="morning shift";
    String Expected ="Abdullah Wahid";
    String message="not same";

    /****************************************************/

    /***************for pim page********************************/
    String Firstname ="Sara";
    String LastName ="Ramadan";
    String EmployeeID ="7873" ;
    String filePath ="C:\\Users\\sara\\Pictures\\Screenshots\\1.png";
    String Nationality ="Afghan";
    String MartialStatus ="Single" ;
    String otherID ="1234";
    String Driverlicensenumber ="125555";
    String licenseDate ="2024-03-05";
    String birthDate ="2001-16-08";
    String expected= "Sara Ramadan";
    String message2 ="Employee name does not match!";
    String ConfigurationStatus ="Termination Reasons";
    String TerminationReason="Deceased";
    String message3 ="Termination reason 'Deceased' not found in records!";
    /*********************************************************/

    // Create a reusable waitForElement function
    public void waitForElement(By locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Initialize the LoginPage
        loginPage = new LoginPage(driver);

        // Wait until the login button is visible
        waitForElement(loginPage.loginButtonLocator, 30);
    }

    @Test(priority = 1)
    public void login() {
        // Perform login actions
        loginPage.typeUsername(UserNameLogin);
        loginPage.typePassword(PasswordLogin);

        // After successful login, move to the dashboard
        dashboardPage = loginPage.clickLogin();  // Get the DashboardPage object
    }

    @Test(priority = 2, dependsOnMethods = "login")
    public void AdminAddEmployee() {

        waitForElement(dashboardPage.DashboardLocator, 30);

        adminPage = dashboardPage.goToAdminPage();
       // adminPage.clickadminButton();


        waitForElement(adminPage.AdmintextLocator, 30);
        adminPage.clickAddButton();
        waitForElement(adminPage.AddUserTextLocator, 30);
        // Type employee name and select the first dropdown option

        adminPage.typeUserName(UserNameForadmin);
        adminPage.typePassword(Passwordforadmin);
        adminPage.typeconfirmPassword(ConfirmPasswordforadmin);

        // Select "Admin"
        adminPage.selectUserRole(UserRoleforadminpage);

        // Select "Enabled"
        adminPage.selectStatus(Statusforadminpage);
        adminPage.typeEmployeeNameAndSelectFirst(EmployeeNameSelectFirst);

        adminPage.clickSaveButton();

        //wait



        //to perform Scroll on application using Selenium
//         JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,350)", "");



    }


    @Test(priority = 3,dependsOnMethods = "AdminAddEmployee")
    public void AdminSearchEmployee() {

        waitForElement(adminPage.SystemUserLocator, 30);
        adminPage.typeUserName2(UserNameForadmin);
        adminPage.selectStatus2(Statusforadminpage);
        adminPage.selectUserRole2(UserRoleforadminpage);
        adminPage.typeEmployeeNameAndSelectFirst2(EmployeeNameSelectFirst);

        adminPage.clickSearchButton();
        waitForElement(adminPage.PersonalNameLocator, 30);
        String actualResult = adminPage.getPersonalName();
        Assert.assertEquals(actualResult, Expected, message);
        waitForElement(adminPage.UserName3Locator, 30);
    }
    @Test(dependsOnMethods = "AdminSearchEmployee")
        public void AddShift()
        {
            adminPage.SelectJobdropdown();
            waitForElement(adminPage.WorkShiftTextLocator, 30);
            adminPage.AddWorkshiftButton();
            waitForElement(adminPage.AddWorkShiftTextLocator, 30);
        /*
        adminPage.ClearTextFrom( );
        adminPage.typeFromHour("05:00 PM");
        adminPage.ClearTextFrom( );
        adminPage.typeToHour("09:00 PM");
        */

            adminPage.typeShiftName(Shiftname);

            adminPage.typeAssignedEmployeeAndSelectFirst(EmployeeNameSelectFirst);
            adminPage.clickSaveShiftButton();
            waitForElement(adminPage.WorkshiftLocator, 30);
        }






    @Test(priority = 4, dependsOnMethods = "AddShift")
    public void PIMaddEmployee() {
        // Perform actions on PIM Page to add an employee
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        waitForElement(adminPage.LastWorkShiftTextLocator, 30);
        // Navigate to PIM page from the dashboard
        pimPage=adminPage.goTopimPage();

        // Wait for the Add Button to be visible
        waitForElement(pimPage.PIMLocator, 30);
        // Now click the Add Button
        pimPage.clickAddButton();
        waitForElement(pimPage.AddEmpolyeeLocator, 30);
        // Add employee details
        pimPage.typeFirstname(Firstname);
        pimPage.typeLastName(LastName);
        //pimPage.ClearText();
        pimPage.typeEmployeeID(EmployeeID);
        pimPage.uploadEmployeePicture(filePath); // Replace with actual path
        pimPage.clickSave();

        // Wait for the personal name to be visible
        waitForElement(pimPage.EmployeefullnametextLocator, 30);
        // Select nationality and other details
        pimPage.selectNationality(Nationality);
        pimPage.selectMartialStatus(MartialStatus);
        pimPage.typeotherID(otherID);
        pimPage.typeDriverlicensenumber(Driverlicensenumber);
        pimPage.typelicenseDate(licenseDate);
        pimPage.typebirthDate(birthDate);
        pimPage.clickGender();

        // Verify the employee name
        String actualResult = pimPage.getPersonalName();
        Assert.assertEquals(actualResult, expected, message2);

        // Scroll and click save on PIM page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        waitForElement(pimPage.SaveButtonpimLocator, 30);
        pimPage.clicksavepimButton();
    }

    @Test(priority = 5, dependsOnMethods = "PIMaddEmployee")
    public void TerminationScenario() {
        // Navigate to the Termination Reasons section
        pimPage.selectConfigurationStatus(ConfigurationStatus);
        waitForElement(pimPage.TerminationReasonsLocator, 30);

        // Add a termination reason
        pimPage.AddButtonTermination();
        waitForElement(pimPage.AddTerminationreasonTextLocator, 30);
        pimPage.typeTerminationReason(TerminationReason);
        pimPage.SaveButtonTermination();

        // Wait for the Records Found table to be visible
        waitForElement(pimPage.RecordsFoundLocator, 30);

        // Verify the added termination reason is present in the table by using the new method from PIMPage
        boolean reasonFound = pimPage.isTerminationReasonPresent(TerminationReason);
        Assert.assertTrue(reasonFound, message3);
    }

    @Test (priority = 8,dependsOnMethods = "TerminationScenario")
    public void logout()
    {
        logoutpage =pimPage.goTologoutPage();
        logoutpage.selectLogoutfromdropdown("Logout");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}