package portaltech.automation.framework.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import portaltech.automation.framework.model.Flight;
import portaltech.automation.framework.utility.Waiter;

public class FlightPickerSection {

    WebElement baseElement;
    Waiter waiter;

    public FlightPickerSection(WebElement baseElement, Waiter waiter) {
        this.baseElement = baseElement;
        this.waiter = waiter;
    }

    public Flight selectFirstAvailableFlight(String date) {
        WebElement element = baseElement.findElement(By.xpath("//h4[contains(., '"+ date +"')]/.."));
        element.findElement(By.className("flight-icon")).click();
        waiter.waitUntil(ExpectedConditions.attributeContains(element.findElement(By.tagName("button")), "class", "selectable selected"));
        String title = baseElement.findElement(By.tagName("h3")).getText();
        String depTime = element.findElement(By.cssSelector("[ej-date=\"::Flight.LocalDepartureTime\"]")).getText();
        String arrTime = element.findElement(By.cssSelector("[ej-date=\"::Flight.LocalArrivalTime\"]")).getText();
        String fare = element.findElement(By.className("price-container")).getText();
        return new Flight(title, depTime, arrTime, fare);
    }
}
