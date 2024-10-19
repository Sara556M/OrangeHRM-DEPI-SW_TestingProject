//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.PIMPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTesting {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    PIMPage pimPage;
    LogoutPage logoutPage;
    WebDriverWait wait;
    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";

    public LogoutTesting() {
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
    public void logout() {
        this.logoutPage = this.dashboardPage.goTologoutPage();
        this.logoutPage.selectLogoutfromdropdown("Logout");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
