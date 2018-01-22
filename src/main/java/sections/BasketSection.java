package sections;

import com.google.common.base.Predicate;
import model.Flight;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.Waiter;

public class BasketSection {

    WebElement baseElement;
    Waiter waiter;

    public BasketSection(WebElement baseElement, Waiter waiter) {
        this.baseElement = baseElement;
        this.waiter = waiter;
    }

    public void clickOnContinueButton() {
        waiter.waitUntil(new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver driver) {
                return !baseElement.findElement(By.className("ej-button")).getAttribute("class").contains("disabled-basket");
            }
        });
        baseElement.findElement(By.className("ej-button")).click();
    }

    public void skip() {
        this.waiter.waitUntil(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-spinner")));
        baseElement.findElement(By.className("skip-link")).click();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            //ignore
        }
    }

    public Flight getDepartureFlightDetails() {
        return getFlight(baseElement.findElement(By.className("route-info-light")));
    }

    public Flight getReturnFlightDetails() {
        return getFlight(baseElement.findElement(By.className("return-flight")));
    }

    private Flight getFlight(WebElement element) {
        String title = element.findElement(By.cssSelector("[ej-focus-when=\"FocusTitle\"]")).getText();
        String dep = element.findElement(By.cssSelector(".departure .time-and-date")).getText();
        String arr = element.findElement(By.cssSelector(".arrival .time")).getText();
        String price = element.findElement(By.className("price")).getText();
        return new Flight(title, dep, arr, price);
    }
}
