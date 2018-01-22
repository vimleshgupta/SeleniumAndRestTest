package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sections.*;

public class BasketPage extends AbstractPage {

    public BasketPage(RemoteWebDriver driver) {
        super(driver);
    }

    public static BasketPage newPage(RemoteWebDriver driver) {
        return new BasketPage(driver);
    }

    public FlightPickerSection flightPickerOnDepartureRoute() {
        return new FlightPickerSection(driver.findElement(By.className("funnel-leg")), waiter);
    }


    public FlightPickerSection flightPickerOnReturnRoute() {
        return new FlightPickerSection(driver.findElements(By.className("funnel-leg")).get(1), waiter);
    }

    public BasketSection basket() {
        return new BasketSection(driver.findElement(By.className("funnel-basket")), waiter);
    }

    public CabinBagSection cabinBag() {
        return new CabinBagSection(driver, waiter);
    }

    public void waitForPage(String page) {
        waiter.waitUntil(ExpectedConditions.titleContains(page));
    }
}
