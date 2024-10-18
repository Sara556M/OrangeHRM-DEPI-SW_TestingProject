import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
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

public class AdminTesting {

    WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    DashboardPage dashboardPage;
    WebDriverWait wait;

    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";

    String UserNameForadmin = "Abdullah Wahid";
    String Passwordforadmin = "Abdullah123@";
    String ConfirmPasswordforadmin = "Abdullah123@";
    String EmployeeNameSelectFirst = "Abdullah";
    String Statusforadminpage = "Enabled";
    String UserRoleforadminpage = "Admin";
    String Shiftname = "morning shift";
    String Expected = "Abdullah Wahid";
    String message = "not same";

    public void waitForElement(By locator, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        waitForElement(loginPage.loginButtonLocator, 30);
    }


    @Test(priority = 1)
    public void validLogin() {
        loginPage.typeUsername(UserNameLogin);
        loginPage.typePassword(PasswordLogin);
        dashboardPage = loginPage.clickLogin();
        waitForElement(dashboardPage.DashboardLocator, 30);
    }



    @Test(priority = 2, dependsOnMethods = "validLogin")
    public void AdminAddEmployee() {
        adminPage = dashboardPage.goToAdminPage();
        waitForElement(adminPage.AdmintextLocator, 30);
        adminPage.clickAddButton();
        waitForElement(adminPage.AddUserTextLocator, 30);
        adminPage.typeUserName(UserNameForadmin);
        adminPage.typePassword(Passwordforadmin);
        adminPage.typeconfirmPassword(ConfirmPasswordforadmin);
        adminPage.selectUserRole(UserRoleforadminpage);
        adminPage.selectStatus(Statusforadminpage);
        adminPage.typeEmployeeNameAndSelectFirst(EmployeeNameSelectFirst);
        adminPage.clickSaveButton();
        //to perform Scroll on application using Selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    @Test(priority = 3, dependsOnMethods = "AdminAddEmployee")
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
    public void AddShift() {
        adminPage.SelectJobdropdown();
        waitForElement(adminPage.WorkShiftTextLocator, 30);
        adminPage.AddWorkshiftButton();
        waitForElement(adminPage.AddWorkShiftTextLocator, 30);
        adminPage.typeShiftName(Shiftname);
        adminPage.typeAssignedEmployeeAndSelectFirst(EmployeeNameSelectFirst);
        adminPage.clickSaveShiftButton();
        waitForElement(adminPage.WorkshiftLocator, 30);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
