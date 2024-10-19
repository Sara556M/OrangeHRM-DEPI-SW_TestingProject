//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver LoginDriver;
    public By usernameLocator = By.xpath("//input[@name='username']");
    public By passwordLocator = By.xpath("//input[@type='password']");
    public By loginButtonLocator = By.xpath("//button[@type='submit']");
    public By DashboardLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By errorMessageLocator = By.xpath("//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]");
    public By requirednameerrormeaasaeLoactor = By.xpath("//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]");

    public LoginPage(WebDriver driver) {
        this.LoginDriver = driver;
    }

    public void typeUsername(String userName) {
        WebElement usernameElement = this.LoginDriver.findElement(this.usernameLocator);
        usernameElement.sendKeys(new CharSequence[]{userName});
    }

    public void typePassword(String passWord) {
        WebElement passwordElement = this.LoginDriver.findElement(this.passwordLocator);
        passwordElement.sendKeys(new CharSequence[]{passWord});
    }

    public DashboardPage clickLogin() {
        WebElement loginButtonElement = this.LoginDriver.findElement(this.loginButtonLocator);
        loginButtonElement.click();
        return new DashboardPage(this.LoginDriver);
    }
}
