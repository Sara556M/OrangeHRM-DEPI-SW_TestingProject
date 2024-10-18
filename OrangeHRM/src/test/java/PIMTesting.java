import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.PIMPage;
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

public class PIMTesting {

    WebDriver driver;
    LoginPage loginPage;
    PIMPage pimPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    WebDriverWait wait;

    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";

    String Firstname = "Sara";
    String LastName = "Ramadan";
    String EmployeeID = "7873";
    String filePath = "C:\\Users\\sara\\Pictures\\Screenshots\\1.png";
    String Nationality = "Afghan";
    String MartialStatus = "Single";
    String otherID = "1234";
    String Driverlicensenumber = "125555";
    String licenseDate = "2024-03-05";
    String birthDate = "2001-16-08";
    String expected = "Sara Ramadan";
    String message2 = "Employee name does not match!";
    String ConfigurationStatus = "Termination Reasons";
    String TerminationReason = "Deceased";
    String message3 = "Termination reason 'Deceased' not found in records!";

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
    public void PIMaddEmployee() {
        //adminPage = dashboardPage.goToAdminPage();
        //waitForElement(adminPage.LastWorkShiftTextLocator, 30);
        pimPage = dashboardPage.goTopimPage();
        waitForElement(pimPage.PIMLocator, 30);
        pimPage.clickAddButton();
        waitForElement(pimPage.AddEmpolyeeLocator, 30);
        pimPage.typeFirstname(Firstname);
        pimPage.typeLastName(LastName);
        pimPage.typeEmployeeID(EmployeeID);
        pimPage.uploadEmployeePicture(filePath);
        pimPage.clickSave();
        waitForElement(pimPage.EmployeefullnametextLocator, 30);
        pimPage.selectNationality(Nationality);
        pimPage.selectMartialStatus(MartialStatus);
        pimPage.typeotherID(otherID);
        pimPage.typeDriverlicensenumber(Driverlicensenumber);
        pimPage.typelicenseDate(licenseDate);
        pimPage.typebirthDate(birthDate);
        pimPage.clickGender();
        String actualResult = pimPage.getPersonalName();
        Assert.assertEquals(actualResult, expected, message2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        waitForElement(pimPage.SaveButtonpimLocator, 30);
        pimPage.clicksavepimButton();
    }

    @Test(priority = 3, dependsOnMethods = "PIMaddEmployee")
    public void TerminationScenario() {
        pimPage.selectConfigurationStatus(ConfigurationStatus);
        waitForElement(pimPage.TerminationReasonsLocator, 30);
        pimPage.AddButtonTermination();
        waitForElement(pimPage.AddTerminationreasonTextLocator, 30);
        pimPage.typeTerminationReason(TerminationReason);
        pimPage.SaveButtonTermination();
        waitForElement(pimPage.RecordsFoundLocator, 30);
        boolean reasonFound = pimPage.isTerminationReasonPresent(TerminationReason);
        Assert.assertTrue(reasonFound, message3);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
