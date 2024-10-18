//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    WebDriver DashboardPageDriver;
    public By DashboardLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    public By AdminButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    public By textForLogoutLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");
    public By RecruitmentButtonLocator =  By.xpath("//a[contains(@href, 'Recruitment')]");

    public DashboardPage(WebDriver driver) {
        this.DashboardPageDriver = driver;
    }

    public AdminPage goToAdminPage() {
        WebElement AdminButton = this.DashboardPageDriver.findElement(this.AdminButtonLocator);
        AdminButton.click();
        return new AdminPage(this.DashboardPageDriver);
    }
    public RecruitmentPage goToRecruitmentPage() {
        WebElement RecruitmentButton = this.DashboardPageDriver.findElement(this.RecruitmentButtonLocator);
        RecruitmentButton.click();
        return new RecruitmentPage(this.DashboardPageDriver);
    }



    public PIMPage goTopimPage() {
        WebElement pimButton = this.DashboardPageDriver.findElement(this.PIMButtonLocator);
        pimButton.click();
        return new PIMPage(this.DashboardPageDriver);
    }

    public LogoutPage goTologoutPage() {
        WebElement LogoutElement = this.DashboardPageDriver.findElement(this.textForLogoutLocator);
        LogoutElement.click();
        return new LogoutPage(this.DashboardPageDriver);
    }
}
