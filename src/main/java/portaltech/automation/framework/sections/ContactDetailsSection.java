package portaltech.automation.framework.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import portaltech.automation.framework.model.ContactDetails;

public class ContactDetailsSection {
    WebElement baseElement;

    public ContactDetailsSection(WebElement baseElement) {
        this.baseElement = baseElement;
    }

    public void selectTitle(String value) {
        Select select = new Select(baseElement.findElement(By.id("title-dropdown")));
        select.selectByValue("string:" + value);
    }

    public void typeFirstName(String value) {
        baseElement.findElement(By.id("firstname-textbox")).sendKeys(value);
    }

    public void typeSurname(String value) {
        baseElement.findElement(By.id("lastname-textbox")).sendKeys(value);
    }

    public void typePasssword(String value) {
        baseElement.findElement(By.id("password-textbox")).sendKeys(value);
    }

    public void typeAddress(String value) {
        baseElement.findElement(By.id("house-number-textbox")).sendKeys(value);
    }

    public void typeTownOrCity(String value) {
        baseElement.findElement(By.id("town-city-textbox")).sendKeys(value);
    }

    public void typePostcode(String value) {
        baseElement.findElement(By.id("postcode-textbox")).sendKeys(value);
    }

    public void typeTelephoneNumber(String value) {
        baseElement.findElement(By.id("phone-number-textbox")).sendKeys(value);
    }

    public boolean isDisplayed() {
        return baseElement.findElement(By.className("section-content")).isDisplayed();
    }

    public void clickOnContinueButton() {
        baseElement.findElement(By.className("ej-button")).click();
    }

    public boolean isDone() {
        return baseElement.findElement(By.className("section-tick-icon")).isDisplayed();
    }

    public ContactDetails getContactDetails() {
        String name = baseElement.findElement(By.className("name")).findElement(By.className("booker-detail-text")).getText();
        String email = baseElement.findElement(By.className("email")).findElement(By.className("booker-detail-text")).getText();
        String country = baseElement.findElement(By.className("resident")).findElement(By.className("booker-detail-text")).getText();
        String telephone = baseElement.findElement(By.className("telephone")).findElement(By.className("booker-detail-text")).getText();
        String address = baseElement.findElement(By.className("address")).findElement(By.className("booker-detail-text")).getText();
        return new ContactDetails(name, email, country, telephone, address);
    }
}
