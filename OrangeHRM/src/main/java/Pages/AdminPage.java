//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    WebDriver AdminDriver;
    public By EmployeeDropdownOptionsLocator = By.xpath("//div[@role='listbox']//span");
    public By AdminButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    public By AdmintextLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By AddUserTextLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public By UserroleDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    public By StatusDropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    public By AddButtonLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By EmployeeNameLocator = By.cssSelector("input[placeholder=\"Type for hints...\"]");
    public By UserNameLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    public By PasswordLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    public By ConfirmpasswordLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    public By SaveButtonLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    public By SystemUserLocator = By.cssSelector("h5[class=\"oxd-text oxd-text--h5 oxd-table-filter-title\"]");
    public By UserName2Locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    public By EmpolyeeName2Locator = By.cssSelector("input[placeholder=\"Type for hints...\"]");
    public By UserRole2Locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    public By Status2Locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");
    public By EmployeeDropdownOptions2Locator = By.xpath("//div[@role='listbox']//span");
    public By SearchButtonLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    public By PersonalNameLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");
    public By UserName3Locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]");
    public By JobButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]");
    public By WorkShiftTextLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public By AddWorkshiftButtonLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By ShiftNameLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input");
    public By FromWorkHourLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div[1]/input");
    public By ToWorkHourLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input");
    public By AssignedEmployeeLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div/div[2]/div/div[1]/input");
    public By AddWorkShiftTextLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6");
    public By saveButtonShiftLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]");
    public By LastWorkShiftTextLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 orangehrm-main-title\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    public By WorkshiftLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/h6");

    public AdminPage(WebDriver driver) {
        this.AdminDriver = driver;
    }

    public void selectUserRole(String role) {
        WebElement userRoleDropdown = this.AdminDriver.findElement(this.UserroleDropdownLocator);
        userRoleDropdown.click();
        WebElement roleOption = this.AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + role + "']"));
        roleOption.click();
    }

    public void selectStatus(String status) {
        WebElement statusDropdown = this.AdminDriver.findElement(this.StatusDropdownLocator);
        statusDropdown.click();
        WebElement statusOption = this.AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"));
        statusOption.click();
    }

    public void clickAddButton() {
        this.AdminDriver.findElement(this.AddButtonLocator).click();
    }

    public void clickSaveButton() {
        this.AdminDriver.findElement(this.SaveButtonLocator).click();
    }

    public void clickadminButton() {
        this.AdminDriver.findElement(this.AdminButtonLocator).click();
    }

    public void typeEmployeeNameAndSelectFirst(String employeeName) {
        WebElement employeeNameInput = this.AdminDriver.findElement(this.EmployeeNameLocator);
        employeeNameInput.sendKeys(new CharSequence[]{employeeName});
        WebDriverWait wait = new WebDriverWait(this.AdminDriver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeDropdownOptionsLocator));
        List<WebElement> dropdownOptions = this.AdminDriver.findElements(this.EmployeeDropdownOptionsLocator);
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = (WebElement)dropdownOptions.get(0);
            firstOption.click();
        } else {
            System.out.println("No options available in the dropdown");
        }

    }

    public void typeUserName(String UserName) {
        WebElement userename = this.AdminDriver.findElement(this.UserNameLocator);
        userename.sendKeys(new CharSequence[]{UserName});
    }

    public void typePassword(String password) {
        WebElement Password = this.AdminDriver.findElement(this.PasswordLocator);
        Password.sendKeys(new CharSequence[]{password});
    }

    public void typeconfirmPassword(String confirmpassword) {
        WebElement ConfirmPassword = this.AdminDriver.findElement(this.ConfirmpasswordLocator);
        ConfirmPassword.sendKeys(new CharSequence[]{confirmpassword});
    }

    public void typeUserName2(String UserName) {
        WebElement userename = this.AdminDriver.findElement(this.UserName2Locator);
        userename.sendKeys(new CharSequence[]{UserName});
    }

    public void typeEmployeeNameAndSelectFirst2(String employeeName) {
        WebElement employeeNameInput = this.AdminDriver.findElement(this.EmpolyeeName2Locator);
        employeeNameInput.sendKeys(new CharSequence[]{employeeName});
        WebDriverWait wait = new WebDriverWait(this.AdminDriver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeDropdownOptions2Locator));
        List<WebElement> dropdownOptions = this.AdminDriver.findElements(this.EmployeeDropdownOptions2Locator);
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = (WebElement)dropdownOptions.get(0);
            firstOption.click();
        } else {
            System.out.println("No options available in the dropdown");
        }

    }

    public void selectStatus2(String status) {
        WebElement statusDropdown = this.AdminDriver.findElement(this.Status2Locator);
        statusDropdown.click();
        WebElement statusOption = this.AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"));
        statusOption.click();
    }

    public void selectUserRole2(String role) {
        WebElement userRoleDropdown = this.AdminDriver.findElement(this.UserRole2Locator);
        userRoleDropdown.click();
        WebElement roleOption = this.AdminDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + role + "']"));
        roleOption.click();
    }

    public void clickSearchButton() {
        this.AdminDriver.findElement(this.SearchButtonLocator).click();
    }

    public String getPersonalName() {
        WebElement personalNameElement = this.AdminDriver.findElement(this.PersonalNameLocator);
        return personalNameElement.getText();
    }

    public void SelectJobdropdown() {
        WebElement jobDropdown = this.AdminDriver.findElement(this.JobButtonLocator);
        jobDropdown.click();
        WebElement roleOption = this.AdminDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[5]/a"));
        roleOption.click();
    }

    public void AddWorkshiftButton() {
        this.AdminDriver.findElement(this.AddWorkshiftButtonLocator).click();
    }

    public void typeShiftName(String ShiftName) {
        WebElement shiftName = this.AdminDriver.findElement(this.ShiftNameLocator);
        shiftName.sendKeys(new CharSequence[]{ShiftName});
    }

    public void ClearTextFrom() {
        WebElement elementToClear = this.AdminDriver.findElement(this.FromWorkHourLocator);
        elementToClear.click();
        Actions actions = new Actions(this.AdminDriver);
        actions.keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.CONTROL);
        actions.perform();
        actions.sendKeys(new CharSequence[]{Keys.DELETE});
        actions.perform();
    }

    public void typeFromHour(String FromHour) {
        WebElement fromhourElement = this.AdminDriver.findElement(this.FromWorkHourLocator);
        fromhourElement.sendKeys(new CharSequence[]{FromHour});
    }

    public void ClearTextTo() {
        WebElement elementToClear = this.AdminDriver.findElement(this.ToWorkHourLocator);
        elementToClear.click();
        Actions actions = new Actions(this.AdminDriver);
        actions.keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.CONTROL);
        actions.perform();
        actions.sendKeys(new CharSequence[]{Keys.DELETE});
        actions.perform();
    }

    public void typeToHour(String ToHour) {
        WebElement tohourElement = this.AdminDriver.findElement(this.ToWorkHourLocator);
        tohourElement.sendKeys(new CharSequence[]{ToHour});
    }

    public void typeAssignedEmployeeAndSelectFirst(String employeeName) {
        WebElement employeeNameInput = this.AdminDriver.findElement(this.AssignedEmployeeLocator);
        employeeNameInput.sendKeys(new CharSequence[]{employeeName});
        WebDriverWait wait = new WebDriverWait(this.AdminDriver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.EmployeeDropdownOptionsLocator));
        List<WebElement> dropdownOptions = this.AdminDriver.findElements(this.EmployeeDropdownOptionsLocator);
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = (WebElement)dropdownOptions.get(0);
            firstOption.click();
        } else {
            System.out.println("No options available in the dropdown");
        }

    }

    public void clickSaveShiftButton() {
        this.AdminDriver.findElement(this.saveButtonShiftLocator).click();
    }

    public PIMPage goTopimPage() {
        WebElement pimButtonElement = this.AdminDriver.findElement(this.PIMButtonLocator);
        pimButtonElement.click();
        return new PIMPage(this.AdminDriver);
    }
}
