import Pages.BuzzPage;
import Pages.DashboardPage;
import Pages.LoginPage;
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

public class BuzzTesting {
    WebDriver driver;
    LoginPage loginPage;
    BuzzPage buzzPage;
    DashboardPage dashboardPage;
    WebDriverWait wait;
    String UserNameLogin = "Admin";
    String PasswordLogin = "admin123";
    String PostContent = "DEPI ENG. Halim TEAM GROUP2 ♥";
    String message = "Post content does not match!";

    public BuzzTesting() {
    }

    // Helper method to wait for an element
    public void waitForElement(By locator, int seconds) {
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
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

    @Test(priority = 1)
    public void validLogin() {
        this.loginPage.typeUsername(this.UserNameLogin);
        this.loginPage.typePassword(this.PasswordLogin);
        this.dashboardPage = this.loginPage.clickLogin();
        this.waitForElement(this.dashboardPage.DashboardLocator, 30);
    }

    @Test(priority = 2, dependsOnMethods = {"validLogin"})
    public void goToBuzzPage() {
        this.buzzPage = this.dashboardPage.goToBuzzPage();
        this.waitForElement(this.buzzPage.PostTextBox, 30);
    }

    @Test(priority = 3, dependsOnMethods = {"goToBuzzPage"})
    public void addBuzzPost() {
        this.buzzPage.typePost(this.PostContent);
        this.buzzPage.clickPostButton();
    }

    @Test(priority = 4, dependsOnMethods = {"addBuzzPost"})
    public void verifyBuzzPost() {
        // Navigate back to the Dashboard page
        this.dashboardPage = this.dashboardPage.goToDashboardPage();

        // Get the text of the latest Buzz post
        String actualPostContent = this.dashboardPage.getBuzzPostWithIndex();

        // Verify if the content of the latest post matches the content that was added
        Assert.assertEquals(actualPostContent, this.PostContent, this.message);
    }
/*
    @AfterClass
    public void tearDown() {
        this.driver.quit();
    }

 */
}
