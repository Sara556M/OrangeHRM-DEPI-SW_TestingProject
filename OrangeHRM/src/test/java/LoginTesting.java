//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import Pages.DashboardPage;
import Pages.LoginPage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTesting {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    String validUserName = "Admin";
    String validUserName2 = "admin";
    String validPassword = "admin123";
    String invalidUserName = "InvalidUser";
    String invalidPassword = "wrongpassword";

    public LoginTesting() {
    }

    public void waitForElement(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds((long)seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
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
        this.loginPage.typeUsername(this.validUserName);
        this.loginPage.typePassword(this.validPassword);
        this.loginPage.clickLogin();
        this.waitForElement(this.loginPage.DashboardLocator, 30);
    }

    @Test(
            priority = 2
    )
    public void validLoginwithinvalidusername() {
        this.loginPage.typeUsername(this.validUserName2);
        this.loginPage.typePassword(this.validPassword);
        this.loginPage.clickLogin();
        this.waitForElement(this.loginPage.DashboardLocator, 30);
    }

    @Test(
            priority = 3
    )
    public void invalidUserName() {
        this.loginPage.typeUsername(this.invalidUserName);
        this.loginPage.typePassword(this.validPassword);
        this.loginPage.clickLogin();
        this.waitForElement(this.loginPage.errorMessageLocator, 30);
        String actualErrorMessage = this.driver.findElement(this.loginPage.errorMessageLocator).getText();
        Assert.assertTrue(actualErrorMessage.contains("Invalid credentials"), "Error message is not expected");
    }

    @Test(
            priority = 4
    )
    public void invalidPassword() {
        this.loginPage.typeUsername(this.validUserName);
        this.loginPage.typePassword(this.invalidPassword);
        this.loginPage.clickLogin();
        this.waitForElement(this.loginPage.errorMessageLocator, 30);
        String actualErrorMessage = this.driver.findElement(this.loginPage.errorMessageLocator).getText();
        Assert.assertTrue(actualErrorMessage.contains("Invalid credentials"), "Error message is not expected");
    }

    @Test(
            priority = 5
    )
    public void emptyUserName() {
        this.loginPage.typeUsername("");
        this.loginPage.typePassword(this.validPassword);
        this.loginPage.clickLogin();
        this.waitForElement(this.loginPage.requirednameerrormeaasaeLoactor, 30);
        String actualErrorMessage = this.driver.findElement(this.loginPage.requirednameerrormeaasaeLoactor).getText();
        Assert.assertTrue(actualErrorMessage.contains("Required"), "Error message is not expected");
    }

    @Test(
            priority = 6
    )
    public void emptyPassword() {
        this.loginPage.typeUsername(this.validUserName);
        this.loginPage.typePassword("");
        this.loginPage.clickLogin();
        this.waitForElement(this.loginPage.requirednameerrormeaasaeLoactor, 30);
        String actualErrorMessage = this.driver.findElement(this.loginPage.requirednameerrormeaasaeLoactor).getText();
        Assert.assertTrue(actualErrorMessage.contains("Required"), "Error message is not expected");
    }

    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }
}
