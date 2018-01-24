package portaltech.automation.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import portaltech.automation.framework.sections.AccountPageSection;
import portaltech.automation.framework.sections.ContactDetailsSection;
import portaltech.automation.framework.sections.PassengerDetailsSection;

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
