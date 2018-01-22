package sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Waiter;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DatePicker {

    WebElement baseElement;
    Waiter waiter;

    public DatePicker(WebElement baseElement, Waiter waiter) {
        this.baseElement = baseElement;
        this.waiter = waiter;
        this.waiter.waitUntil(visibilityOfElementLocated(By.className("route-date-picker-month")));
    }

    public void selectDate(String value) {
        baseElement.findElement(By.cssSelector("[data-date=\"" + value + "\"]")).click();
        this.waiter.waitUntil(invisibilityOfElementLocated(By.className("route-date-picker-month")));
    }
}
