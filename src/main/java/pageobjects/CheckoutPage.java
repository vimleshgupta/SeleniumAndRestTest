package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import sections.*;

public class CheckoutPage extends AbstractPage {

    public CheckoutPage(RemoteWebDriver driver) {
        super(driver);
    }

    public static CheckoutPage newPage(RemoteWebDriver driver) {
        return new CheckoutPage(driver);
    }

    public ContactDetailsSection contactDetailsSection() {
        return new ContactDetailsSection(driver.findElement(By.className("above-section")));
    }

    public PassengerDetailsSection passengerDetailsSection() {
        return new PassengerDetailsSection(driver.findElement(By.className("below-section")));
    }

    public AccountPageSection accountSection() {
        return new AccountPageSection(driver.findElement(By.className("funnel-sign-in-or-sign-up")), waiter);
    }
}
