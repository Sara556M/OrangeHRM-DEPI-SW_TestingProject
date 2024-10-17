package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    WebDriver DashboardPageDriver;

    // Locators
    public By DashboardLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']"); // PIM button locator
    public By AdminButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    // Constructor
    public DashboardPage(WebDriver driver) {
        this.DashboardPageDriver = driver;
    }

    // Method to click PIM button and navigate to PIMPage
    public AdminPage goToAdminPage() {
        WebElement AdminButton = DashboardPageDriver.findElement(AdminButtonLocator);
        AdminButton.click(); // Click the PIM button

        return new AdminPage(DashboardPageDriver);  // Return the PIMPage instance
    }
}
