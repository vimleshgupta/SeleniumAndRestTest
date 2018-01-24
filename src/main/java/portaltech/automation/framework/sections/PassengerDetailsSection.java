package portaltech.automation.framework.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PassengerDetailsSection {
    WebElement baseElement;

    public PassengerDetailsSection(WebElement baseElement) {
        this.baseElement = baseElement;
    }

    public boolean isDisplayed() {
        return baseElement.findElement(By.className("section-content")).isDisplayed();
    }

    public void selectReasonForTravel(String reason) {
        if ("Leisure".equals(reason)) {
            baseElement.findElement(By.name("reasonForTravel-2")).click();
        } else {
            baseElement.findElement(By.name("reasonForTravel-1")).click();
        }
    }

    public void selectTitle(String value) {
        Select select = new Select(baseElement.findElement(By.id("title-dropdown-adult-1")));
        select.selectByValue("string:" + value);
    }

    public void selectAge(String value) {
        Select select = new Select(baseElement.findElement(By.id("age-dropdown-adult-1")));
        select.selectByValue("number:" + value.replace("+", ""));
    }

    public void typeFirstname(String value) {
        baseElement.findElement(By.id("firstname-textbox-adult-1")).sendKeys(value);
    }
    public void typeLastname(String value) {
        baseElement.findElement(By.id("lastname-textbox-adult-1")).sendKeys(value);
    }

    public void clickOnContinueButton() {
        baseElement.findElement(By.className("ej-button")).click();
    }

    public boolean isDone() {
        return baseElement.findElement(By.className("section-tick-icon")).isDisplayed();
    }

    public String getDetails() {
        return baseElement.findElement(By.className("name")).getText();
    }
}
