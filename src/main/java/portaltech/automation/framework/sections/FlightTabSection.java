package portaltech.automation.framework.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import portaltech.automation.framework.utility.Waiter;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class FlightTabSection {

    WebElement baseElements;
    Waiter waiter;

    public FlightTabSection(WebElement baseElements, Waiter waiter) {
        this.baseElements = baseElements;
        this.waiter = waiter;
    }

    public void selectFrom(String value) {
        baseElements.findElement(By.name("origin")).clear();
        baseElements.findElement(By.name("origin")).sendKeys(value);
        waiter.waitUntil(visibilityOfElementLocated(By.id("ui-id-1")));
        baseElements.findElement(By.className("ui-menu-item")).click();
    }

    public void selectTo(String value) {
        baseElements.findElement(By.name("destination")).clear();
        baseElements.findElement(By.name("destination")).sendKeys(value);
        waiter.waitUntil(visibilityOfElementLocated(By.id("ui-id-2")));
        baseElements.findElement(By.id("ui-id-2")).findElement(By.className("ui-menu-item")).click();
    }

    public String getAdultsQuantity() {
        return baseElements.findElement(By.className("quantity")).getAttribute("value");
    }

    public void clickOnShowFlightsButton() {
        baseElements.findElement(By.className("search-submit")).click();
    }

    public void clickOnDepartureDateButton() {
        baseElements.findElement(By.className("outbound-date-picker")).click();
    }

    public void clickOnReturnDateButton() {
        baseElements.findElement(By.className("return-date-picker")).click();
    }

    public void chooseOneway() {
        baseElements.findElement(By.className("checkbox-container")).click();
    }

    public boolean isDestinationErrorDisplayed() {
        return baseElements.findElement(By.cssSelector(".outer-destination")).getAttribute("class").contains("invalid");
    }

    public boolean isDepartureDateErrorDisplayed() {
        return baseElements.findElement(By.cssSelector(".outbound-date-picker .date-picker-button")).getAttribute("class").contains("invalid");
    }

    public boolean isReturnDateErrorDisplayed() {
        return baseElements.findElement(By.cssSelector(".return-date-picker .date-picker-button")).getAttribute("class").contains("invalid");
    }
}
