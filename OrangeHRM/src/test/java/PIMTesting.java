//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.PIMPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    public PIMTesting() {
    }

    public void waitForElement(By locator, int seconds) {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds((long)seconds));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @BeforeClass
    public void setup() {
        this.driver = new ChromeDriver();
        this.driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
        this.waitForElement(this.loginPage.loginButtonLocator, 30);
    }

    @Test(
            priority = 1
    )
    public void validLogin() {
        this.loginPage.typeUsername(this.UserNameLogin);
        this.loginPage.typePassword(this.PasswordLogin);
        this.dashboardPage = this.loginPage.clickLogin();
        this.waitForElement(this.dashboardPage.DashboardLocator, 30);
    }

    @Test(
            priority = 2,
            dependsOnMethods = {"validLogin"}
    )
    public void PIMaddEmployee() {
        this.pimPage = this.dashboardPage.goTopimPage();
        this.waitForElement(this.pimPage.PIMLocator, 30);
        this.pimPage.clickAddButton();
        this.waitForElement(this.pimPage.AddEmpolyeeLocator, 30);
        this.pimPage.typeFirstname(this.Firstname);
        this.pimPage.typeLastName(this.LastName);
        this.pimPage.typeEmployeeID(this.EmployeeID);
        this.pimPage.uploadEmployeePicture(this.filePath);
        this.pimPage.clickSave();
        this.waitForElement(this.pimPage.EmployeefullnametextLocator, 30);
        this.pimPage.selectNationality(this.Nationality);
        this.pimPage.selectMartialStatus(this.MartialStatus);
        this.pimPage.typeotherID(this.otherID);
        this.pimPage.typeDriverlicensenumber(this.Driverlicensenumber);
        this.pimPage.typelicenseDate(this.licenseDate);
        this.pimPage.typebirthDate(this.birthDate);
        this.pimPage.clickGender();
        String actualResult = this.pimPage.getPersonalName();
        Assert.assertEquals(actualResult, this.expected, this.message2);
        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("window.scrollBy(0,350)", new Object[]{""});
        this.waitForElement(this.pimPage.SaveButtonpimLocator, 30);
        this.pimPage.clicksavepimButton();
    }

    @Test(
            priority = 3,
            dependsOnMethods = {"PIMaddEmployee"}
    )
    public void TerminationScenario() {
        this.pimPage.selectConfigurationStatus(this.ConfigurationStatus);
        this.waitForElement(this.pimPage.TerminationReasonsLocator, 30);
        this.pimPage.AddButtonTermination();
        this.waitForElement(this.pimPage.AddTerminationreasonTextLocator, 30);
        this.pimPage.typeTerminationReason(this.TerminationReason);
        this.pimPage.SaveButtonTermination();
        this.waitForElement(this.pimPage.RecordsFoundLocator, 30);
        boolean reasonFound = this.pimPage.isTerminationReasonPresent(this.TerminationReason);
        Assert.assertTrue(reasonFound, this.message3);
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
