//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
    WebDriver logoutDriver;
    public By textForLogoutLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");

    public LogoutPage(WebDriver driver) {
        this.logoutDriver = driver;
    }

    public void selectLogoutfromdropdown(String status) {
        WebElement statusOption = this.logoutDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a"));
        statusOption.click();
    }
}
