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

public class LoginTesting {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    // Valid Credentials
    String validUserName = "Admin";
    String validUserName2 ="admin";
    String validPassword = "admin123";

    // Invalid Credentials
    String invalidUserName = "InvalidUser";
    String invalidPassword = "wrongpassword";

    // Error Message Locator

    public void waitForElement(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
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
        loginPage.typeUsername(validUserName);
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        // Assert that the dashboard is displayed (you might need to find a more specific locator)
        waitForElement(loginPage.DashboardLocator, 30); // Example dashboard locator
    }
    @Test(priority = 2)
    public void validLoginwithinvalidusername() {
        loginPage.typeUsername(validUserName2);
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        // Assert that the dashboard is displayed (you might need to find a more specific locator)
        waitForElement(loginPage.DashboardLocator, 30); // Example dashboard locator
    }

    @Test(priority = 3)
    public void invalidUserName() {
        loginPage.typeUsername(invalidUserName);
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        // Assert that the error message is displayed
        waitForElement(loginPage.errorMessageLocator, 30);
        String actualErrorMessage = driver.findElement(loginPage.errorMessageLocator).getText();
        Assert.assertTrue(actualErrorMessage.contains("Invalid credentials"), "Error message is not expected");
    }

    @Test(priority = 4)
    public void invalidPassword() {
        loginPage.typeUsername(validUserName);
        loginPage.typePassword(invalidPassword);
        loginPage.clickLogin();

        // Assert that the error message is displayed
        waitForElement(loginPage.errorMessageLocator, 30);
        String actualErrorMessage = driver.findElement(loginPage.errorMessageLocator).getText();
        Assert.assertTrue(actualErrorMessage.contains("Invalid credentials"), "Error message is not expected");
    }

    @Test(priority = 5)
    public void emptyUserName() {
        loginPage.typeUsername(""); // Empty username
        loginPage.typePassword(validPassword);
        loginPage.clickLogin();

        // Assert that the error message is displayed
        waitForElement(loginPage.requirednameerrormeaasaeLoactor, 30);
        String actualErrorMessage = driver.findElement(loginPage.requirednameerrormeaasaeLoactor).getText();
        Assert.assertTrue(actualErrorMessage.contains("Required"), "Error message is not expected");
    }

    @Test(priority = 6)
    public void emptyPassword() {
        loginPage.typeUsername(validUserName);
        loginPage.typePassword(""); // Empty password
        loginPage.clickLogin();

        // Assert that the error message is displayed
        waitForElement(loginPage.requirednameerrormeaasaeLoactor, 30);
        String actualErrorMessage = driver.findElement(loginPage.requirednameerrormeaasaeLoactor).getText();
        Assert.assertTrue(actualErrorMessage.contains("Required"), "Error message is not expected");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}