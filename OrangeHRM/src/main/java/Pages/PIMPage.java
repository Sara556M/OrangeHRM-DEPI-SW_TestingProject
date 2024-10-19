//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage {
    WebDriver PIMPageDriver;
    WebDriverWait wait;
    public By PIMLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By AddEmpolyeeLocator = By.cssSelector("h6[class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]");
    public By PIMButtonLocator = By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    public By AddButtonLocator = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");
    public By FirstNameLocator = By.xpath("//input[@placeholder='First Name']");
    public By LastNameLocator = By.xpath("//input[@placeholder='Last Name']");
    public By SaveButtonLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    public By PersonalNameLocator = By.xpath("//div[@class=\"orangehrm-edit-employee-name\"]/h6");
    public By PersonalDetailsLocator = By.xpath("//a[ contains(text(), \"Personal Details\")]");
    public By EmpolyeePictureLocator = By.cssSelector("img[class=\"employee-image\"]");
    public By UploadButtonLocator = By.cssSelector("input[type='file']");
    public By EmployeeIDLocator = By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]");
    public By OtherIDLoactor = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input");
    public By DriverLicenseNumberLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input");
    public By LicenseExpiryDateLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input");
    public By NationalitydropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]");
    public By MaritalStatusdropdownLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]");
    public By DateofBirthLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input");
    public By GenderFemaleLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label");
    public By EmployeefullnametextLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[1]/label");
    public By NationalityOptionsLocator = By.xpath("//div[@role='listbox']//span");
    public By MaritalStatusOptionsLocator = By.xpath("//div[@role='listbox']//span");
    public By SaveButtonpimLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button");
    public By ReportLocator = By.xpath("//a[contains(text(),'Reports')]");
    public By ConfigurationLocator = By.cssSelector("span[class=\"oxd-topbar-body-nav-tab-item\"]");
    public By TerminationReasonsLocator = By.cssSelector("p[class=\"oxd-text oxd-text--p orangehrm-main-title\"]");
    public By AddButtonTerminationLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    public By TerminationReasonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    public By SaveButtonTerminationLocator = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"");
    public By AddTerminationreasonTextLocator = By.cssSelector("p[class=\"oxd-text oxd-text--p orangehrm-main-title\"]");
    public By RecordsFoundLocator = By.cssSelector("span[class=\"oxd-text oxd-text--span\"]");
    public By recordsTableLocator = By.cssSelector("div[class=\"orangehrm-container\"]");
    public By textForLogoutLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p");

    public PIMPage(WebDriver driver) {
        this.PIMPageDriver = driver;
    }

    public void typeFirstname(String FirstName) {
        WebElement firstNameElement = this.PIMPageDriver.findElement(this.FirstNameLocator);
        firstNameElement.sendKeys(new CharSequence[]{FirstName});
    }

    public void waitForElement(By locator, int seconds) {
        this.wait = new WebDriverWait(this.PIMPageDriver, Duration.ofSeconds((long)seconds));
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void typeLastName(String LastName) {
        WebElement lastNameElement = this.PIMPageDriver.findElement(this.LastNameLocator);
        lastNameElement.sendKeys(new CharSequence[]{LastName});
    }

    public void ClearText() {
        WebElement elementToClear = this.PIMPageDriver.findElement(this.EmployeeIDLocator);
        elementToClear.click();
        Actions actions = new Actions(this.PIMPageDriver);
        actions.keyDown(Keys.CONTROL).sendKeys(new CharSequence[]{"a"}).keyUp(Keys.CONTROL);
        actions.perform();
        actions.sendKeys(new CharSequence[]{Keys.DELETE});
        actions.perform();
    }

    public void typeEmployeeID(String EmployeeID) {
        WebElement EmployeeIDElement = this.PIMPageDriver.findElement(this.EmployeeIDLocator);
        EmployeeIDElement.sendKeys(new CharSequence[]{EmployeeID});
    }

    public void clickSave() {
        WebElement saveButtonElement = this.PIMPageDriver.findElement(this.SaveButtonLocator);
        saveButtonElement.click();
    }

    public void clickPIMButton() {
        WebElement pimButtonElement = this.PIMPageDriver.findElement(this.PIMButtonLocator);
        pimButtonElement.click();
    }

    public void clickAddButton() {
        WebElement addButtonElement = this.PIMPageDriver.findElement(this.AddButtonLocator);
        addButtonElement.click();
    }

    public String getPersonalName() {
        WebElement personalNameElement = this.PIMPageDriver.findElement(this.PersonalNameLocator);
        return personalNameElement.getText();
    }

    public void uploadEmployeePicture(String filePath) {
        WebElement uploadButton = this.PIMPageDriver.findElement(this.UploadButtonLocator);
        uploadButton.sendKeys(new CharSequence[]{filePath});
    }

    public void typeotherID(String otherid) {
        WebElement otheridElement = this.PIMPageDriver.findElement(this.OtherIDLoactor);
        otheridElement.sendKeys(new CharSequence[]{otherid});
    }

    public void typeDriverlicensenumber(String Driverlicensenumber) {
        WebElement DriverlicenseElement = this.PIMPageDriver.findElement(this.DriverLicenseNumberLocator);
        DriverlicenseElement.sendKeys(new CharSequence[]{Driverlicensenumber});
    }

    public void typelicenseDate(String licenseDate) {
        WebElement licenseDateElement = this.PIMPageDriver.findElement(this.LicenseExpiryDateLocator);
        licenseDateElement.sendKeys(new CharSequence[]{licenseDate});
    }

    public void typebirthDate(String birthDate) {
        WebElement birthDateElement = this.PIMPageDriver.findElement(this.DateofBirthLocator);
        birthDateElement.sendKeys(new CharSequence[]{birthDate});
    }

    public void selectNationality(String nationality) {
        WebElement NationalityDropdown = this.PIMPageDriver.findElement(this.NationalitydropdownLocator);
        NationalityDropdown.click();
        WebElement nationalityOption = this.PIMPageDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + nationality + "']"));
        nationalityOption.click();
    }

    public void selectMartialStatus(String status) {
        WebElement MartialStatusDropdown = this.PIMPageDriver.findElement(this.MaritalStatusdropdownLocator);
        MartialStatusDropdown.click();
        WebElement statusOption = this.PIMPageDriver.findElement(By.xpath("//div[@role='listbox']//span[text()='" + status + "']"));
        statusOption.click();
    }

    public void clickGender() {
        WebElement GenderButtonElement = this.PIMPageDriver.findElement(this.GenderFemaleLocator);
        GenderButtonElement.click();
    }

    public void clicksavepimButton() {
        WebElement addButtonElement = this.PIMPageDriver.findElement(this.SaveButtonpimLocator);
        addButtonElement.click();
    }

    public void clickReportButton() {
        WebElement ReportElement = this.PIMPageDriver.findElement(this.ReportLocator);
        ReportElement.click();
    }

    public void selectConfigurationStatus(String status) {
        WebElement ConfigurationStatusDropdown = this.PIMPageDriver.findElement(this.ConfigurationLocator);
        ConfigurationStatusDropdown.click();
        WebElement statusOption = this.PIMPageDriver.findElement(By.xpath("//a[contains(text(),'Termination Reasons')]"));
        statusOption.click();
    }

    public void AddButtonTermination() {
        WebElement AddButtonTerminationElement = this.PIMPageDriver.findElement(this.AddButtonTerminationLocator);
        AddButtonTerminationElement.click();
    }

    public void typeTerminationReason(String TerminationReason) {
        WebElement TerminationReasonElement = this.PIMPageDriver.findElement(this.TerminationReasonLocator);
        TerminationReasonElement.sendKeys(new CharSequence[]{TerminationReason});
    }

    public void SaveButtonTermination() {
        WebElement SaveButtonTerminationElement = this.PIMPageDriver.findElement(this.SaveButtonTerminationLocator);
        SaveButtonTerminationElement.click();
    }

    public boolean isTerminationReasonPresent(String reason) {
        WebElement recordsTable = (WebElement)(new WebDriverWait(this.PIMPageDriver, Duration.ofSeconds(30L))).until(ExpectedConditions.visibilityOfElementLocated(this.recordsTableLocator));
        List<WebElement> rows = recordsTable.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]"));
        Iterator var4 = rows.iterator();

        WebElement row;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            row = (WebElement)var4.next();
            System.out.println("Row Text: " + row.getText());
        } while(!row.getText().contains(reason));

        return true;
    }
}
